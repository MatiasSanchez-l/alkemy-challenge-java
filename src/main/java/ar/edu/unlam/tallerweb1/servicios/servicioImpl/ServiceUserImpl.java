package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryUser;
import ar.edu.unlam.tallerweb1.servicios.ServiceUser;

@Service
@Transactional
public class ServiceUserImpl implements ServiceUser {
	@Autowired
	private RepositoryUser servicioLoginDao;
	
	@Override
	public User getUser (User usuario) {
		return servicioLoginDao.consultarUsuario(usuario);
	}

	@Override
	public User getUserById(Long id) {
		return servicioLoginDao.getUserById(id);
	}

}
