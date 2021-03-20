package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.servicios.ServiceLogin;
import ar.edu.unlam.tallerweb1.servicios.ServiceRol;

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

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControlerLogin {

	private ServiceLogin servicioLogin;
	
	@Autowired
	private ServiceRol servicioRol;

	@Autowired
	public ControlerLogin(ServiceLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin(HttpServletRequest request) {
		
		User usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (User) request.getSession().getAttribute("USUARIO")
				: null;
		if (usuarioLogueado != null) {
			return new ModelAndView("redirect:/home");
		}
		
		ModelMap modelo = new ModelMap();
		modelo.put("title", "Login");
		return new ModelAndView("login", modelo);
	}


	@RequestMapping(path = "/validar-login", produces = "application/json",method = RequestMethod.POST)
	@ResponseBody
	public String validarLogin(
			@RequestParam(value = "dni", required = false) Long dni,
			@RequestParam(value = "legajo", required = false) Long legajo,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "rol", required = false) String rol,
			HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		Boolean dniVacio=false;
		Boolean legajoVacio=false;
		Boolean passwordVacio=false;
		Boolean rolVacio=false;
		Boolean errorLogin=false;
		
		if (dni == null) {
			dniVacio = true;
		}
		if (legajo == null) {
			legajoVacio = true;
		}
		if (password.isEmpty()) {
			passwordVacio = true;
		}
		
		Rol rolUsuario = null;
		if (rol.isEmpty()) {
			rolVacio = true;
		}else {
			rolUsuario = servicioRol.getRolPorDescripcion(rol);
		}
		
		json.addProperty("dniVacio", dniVacio);
		json.addProperty("legajoVacio", legajoVacio);
		json.addProperty("passwordVacio", passwordVacio);
		json.addProperty("rolVacio", rolVacio);
		
		
		
		User usuario = new User();
		usuario.setDni(dni);
		usuario.setLegajo(legajo);
		usuario.setPassword(password);
		usuario.setRol(rolUsuario);
		
		User usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		if(dniVacio.equals(false) && legajoVacio.equals(false) && passwordVacio.equals(false) && rolVacio.equals(false)){
			
			if (usuarioBuscado != null) {
				request.getSession().setAttribute("USUARIO", usuarioBuscado);
				
				json.addProperty("errorLogin", errorLogin);
				return gson.toJson(json);
			} else {
				errorLogin = true;
				json.addProperty("errorLogin", errorLogin);
			}
			
		}
		
		return gson.toJson(json);
	}
	
	@RequestMapping(path = "cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		request.getSession().invalidate();
		return new ModelAndView("redirect:/login", modelo);
	}


	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}
