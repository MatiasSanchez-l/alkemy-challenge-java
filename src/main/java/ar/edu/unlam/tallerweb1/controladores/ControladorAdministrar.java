package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.User;

@Controller
public class ControladorAdministrar {
	
	@RequestMapping(path = "/administrar", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
				
	if (usuarioLogueado == null || usuarioLogueado.getRol().getDescription().equals("student")) {
			return new ModelAndView("redirect:/login");
				}
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("usuarioLogueado", usuarioLogueado);
		modelo.put("title", "Administrar");
		return new ModelAndView("administrar", modelo);
	}
}
