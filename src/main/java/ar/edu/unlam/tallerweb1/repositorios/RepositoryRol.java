package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Rol;

public interface RepositoryRol {
	Rol getRolPorDescripcion(String descripcion);
}
