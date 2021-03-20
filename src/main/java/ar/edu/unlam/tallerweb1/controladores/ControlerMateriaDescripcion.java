package ar.edu.unlam.tallerweb1.controladores;

import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;

@Controller
public class ControlerMateriaDescripcion {
	
	@Autowired
	private ServiceSubject serviceSubject;
	
	@RequestMapping(path = "/materia", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
		if (usuarioLogueado == null) {
			return new ModelAndView("redirect:/login");
				}
		
		ModelMap modelo = new ModelMap();
		
		TreeSet subjectListSorted = serviceSubject.getListOfSubjectsSortedAlphabetically();
		
		modelo.put("subjects", subjectListSorted);
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("title", "Materias");
		return new ModelAndView("materia", modelo);
	}
	
	@RequestMapping(path = "/materia/descripcion", method = RequestMethod.GET)
	public ModelAndView irAHome(
			@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
		if (usuarioLogueado == null || id == null) {
			return new ModelAndView("redirect:/login");
				}
		
		ModelMap modelo = new ModelMap();
		
		Subject subject = serviceSubject.getSubjectById(id);
		
		modelo.put("subject", subject);
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("title", "Materia Descripci&oacute;n");
		return new ModelAndView("materiaDescripcion", modelo);
	}

}
