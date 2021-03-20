package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryUser;
import ar.edu.unlam.tallerweb1.servicios.ServiceUser;

public class ServiceUserImpl implements ServiceUser {
	@Autowired
	private RepositoryUser servicioLoginDao;
	
	@Override
	public User getUser (User usuario) {
		return servicioLoginDao.consultarUsuario(usuario);
	}

}
