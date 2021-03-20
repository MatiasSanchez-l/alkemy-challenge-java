package ar.edu.unlam.tallerweb1.controladores;

import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;

@Controller
public class ControlerMateriasInscriptas {
	@Autowired
	private ServiceSubject serviceSubject;
	
	@RequestMapping(path = "/materias-inscriptas", method = RequestMethod.GET)
	public ModelAndView subjectsEnrolledView(HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
		if (usuarioLogueado == null) {
			return new ModelAndView("redirect:/login");
				}
		
		ModelMap modelo = new ModelMap();
		
		TreeSet subjectListSorted = null;
		
		if(usuarioLogueado.getRol().getDescription().equals("student")) {
			subjectListSorted = serviceSubject.getListOfSubjectsWhereStudentIsEnroll(usuarioLogueado);
		}
		
		modelo.put("subjects", subjectListSorted);
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("title", "Materias Inscriptas");
		return new ModelAndView("materiasInscriptas", modelo);
	}

}
