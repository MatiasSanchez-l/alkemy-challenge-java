package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryRol;
import ar.edu.unlam.tallerweb1.servicios.ServiceRol;


@Service
@Transactional
public class ServiceRolImpl implements ServiceRol {
	@Autowired
	private RepositoryRol repositorioRol;
	
	@Override
	public Rol getRolPorDescripcion(String descripcion) {
		Rol rol = repositorioRol.getRolPorDescripcion(descripcion);
		return rol;
	}

}
