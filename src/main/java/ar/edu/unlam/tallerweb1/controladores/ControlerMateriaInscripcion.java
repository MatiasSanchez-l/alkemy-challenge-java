package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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

import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.servicios.ServiceEnroll;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;

@Controller
public class ControlerMateriaInscripcion {
	
	@Autowired
	private ServiceSubject serviceSubject;
	@Autowired
	private ServiceEnroll serviceEnroll;
	
	@RequestMapping(path = "/inscripcion", method = RequestMethod.GET)
	public ModelAndView enrollView(HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
		if (usuarioLogueado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelMap modelo = new ModelMap();
		TreeSet subjectListSorted = null;
		
		if(usuarioLogueado.getRol().getDescription().equals("student")) {
		subjectListSorted = serviceSubject.getListOfSubjectsWhereStudentIsNotEnroll(usuarioLogueado);
		}else {
			subjectListSorted = serviceSubject.getListOfSubjectsSortedAlphabetically();
		}
		
		modelo.put("subjects", subjectListSorted);
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("title", "Inscripci&oacute;n");
		return new ModelAndView("inscripcion", modelo);
	}
	
	
	@RequestMapping(path = "/validarInscripcion", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String enrollInSubject(
			@RequestParam(value = "subjectIds", required = false) String subjects,
			HttpServletRequest request) {
		
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
		
		if(usuarioLogueado.getRol().getDescription().equals("student")) {
			Boolean enrolled = false; 
			
			String separator0 = "&";
			String separator1 = "materiaAInscribirse=";
			String[] parameterSeparated = subjects.split(separator0);
			List<Long> subjectsIds = new ArrayList<Long>();
			
			for (int i = 0; i < parameterSeparated.length; i++) {
				String idString = parameterSeparated[i];
				
				String[] idStringSeparated =idString.split(separator1);
				
				Long idLong = Long.parseLong(idStringSeparated[1]);
				
				subjectsIds.add(idLong);
			}
			
			
			List<Subject> subjectsToEnroll = new ArrayList<Subject>();
			
			for (int i = 0; i < subjectsIds.size(); i++) {
				Subject subjectSearched = serviceSubject.getSubjectById(subjectsIds.get(i));
				subjectsToEnroll.add(subjectSearched);
			}
			
			serviceEnroll.enrollStudentInSubjects(usuarioLogueado, subjectsToEnroll);
			enrolled = true;
			json.addProperty("enrolled", enrolled);
		}else {
			json.addProperty("admin", true);
		}
		
		
		return gson.toJson(json);
	}
}
