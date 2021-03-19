package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRol;
import ar.edu.unlam.tallerweb1.servicios.ServicioRol;


@Service
@Transactional
public class ServicioRolImpl implements ServicioRol {
	@Autowired
	private RepositorioRol repositorioRol;
	
	@Override
	public Rol getRolPorDescripcion(String descripcion) {
		Rol rol = repositorioRol.getRolPorDescripcion(descripcion);
		return rol;
	}

}
