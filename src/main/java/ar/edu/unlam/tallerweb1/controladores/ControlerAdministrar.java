package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.edu.unlam.tallerweb1.modelo.Schedule;
import ar.edu.unlam.tallerweb1.modelo.Teacher;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.servicios.ServiceSchedule;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;
import ar.edu.unlam.tallerweb1.servicios.ServiceTeacher;

@Controller
public class ControlerAdministrar {
	@Autowired
	private ServiceSchedule serviceSchedule;
	
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@Autowired
	private ServiceSubject serviceSubject;
	
	@RequestMapping(path = "/administrar", method = RequestMethod.GET)
	public ModelAndView adminView(
			@RequestParam(value = "editarMateria", required = false) Boolean editarMateria,
			@RequestParam(value = "editarProfesor", required = false) Boolean editarProfesor,
			HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
		if (usuarioLogueado == null || usuarioLogueado.getRol().getDescription().equals("student")) {
			return new ModelAndView("redirect:/login");
				}
		
		ModelMap modelo = new ModelMap();
		
		
		List<Schedule> schedules = serviceSchedule.getScheduleList();
		List<Teacher> teachers = serviceTeacher.getTeacherList();
		
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("editarMateria", editarMateria);
		modelo.put("editarProfesor", editarProfesor);
		modelo.put("schedules", schedules);
		modelo.put("teachers", teachers);
		modelo.put("title", "Administrar");
		return new ModelAndView("administrar", modelo);
	}
	
	@RequestMapping(path = "/editarMateria", method = RequestMethod.POST)
	public ModelAndView editSubject(
			@RequestParam(value = "name", required = false) String subjectName,
			@RequestParam(value = "day", required = false) Long dayId,
			@RequestParam(value = "startTime", required = false) Long subjectStartTime,
			@RequestParam(value = "finishTime", required = false) Long subjectFinishTime,
			@RequestParam(value = "shift", required = false) String shift,
			@RequestParam(value = "teacher", required = false) Long teacherId,
			@RequestParam(value = "maxPlaces", required = false) Long maxPlaces,
			@RequestParam(value = "scheduleId", required = false) Long scheduleId,
			HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
		if(usuarioLogueado == null) {
			return new ModelAndView("redirect:/administrar?editarMateria=false");
		}
	
		Schedule schedule = serviceSchedule.getScheduleById(scheduleId);
		Long subjectId = schedule.getSubject().getId();
		
		serviceSubject.changeName(subjectId, subjectName);
		serviceSubject.changeStartTime(subjectId, subjectStartTime);
		serviceSubject.changeFinishTime(subjectId, subjectFinishTime);
		serviceSubject.changeShift(subjectId, shift);
		serviceSubject.changeMaxPlaces(subjectId, maxPlaces);
		
		serviceSchedule.changeDay(scheduleId, dayId);
		serviceSchedule.changeTeacher(scheduleId, teacherId);
		
		return new ModelAndView("redirect:/administrar?editarMateria=true");
	}
	
	@RequestMapping(path = "/editarProfesor", method = RequestMethod.POST)
	public ModelAndView editTeacher(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastname", required = false) String lastname,
			@RequestParam(value = "dni", required = false) Long dni,
			@RequestParam(value = "active", required = false) Boolean active,
			@RequestParam(value = "teacherId", required = false) Long id,
			HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
		if(usuarioLogueado == null) {
			return new ModelAndView("redirect:/administrar?editarProfesor=false");
		}
		serviceTeacher.changeName(id, name);
		serviceTeacher.changeLastName(id, lastname);
		serviceTeacher.changeDni(id, dni);
		serviceTeacher.changeActive(id, active);
		
		return new ModelAndView("redirect:/administrar?editarProfesor=true");
	}
	
	@RequestMapping(path = "/getTeachersAjax", produces = "application/json")
	@ResponseBody
	public String getTeachersAjax() {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		String teacherList = serviceTeacher.getTeachersAjax();
		json.addProperty("datosTeachers", teacherList);
		return gson.toJson(json);
	}
}
