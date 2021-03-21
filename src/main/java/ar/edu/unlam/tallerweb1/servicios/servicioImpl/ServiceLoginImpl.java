package ar.edu.unlam.tallerweb1.servicios.servicioImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositoryUser;
import ar.edu.unlam.tallerweb1.servicios.ServiceLogin;
import ar.edu.unlam.tallerweb1.modelo.User;

@Service("servicioLogin")
@Transactional
public class ServiceLoginImpl implements ServiceLogin {

	private RepositoryUser servicioLoginDao;

	@Autowired
	public ServiceLoginImpl(RepositoryUser servicioLoginDao){
		this.servicioLoginDao = servicioLoginDao;
	}

	@Override
	public User getUser (User usuario) {
		return servicioLoginDao.consultarUsuario(usuario);
	}

}
