package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.User;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositoryUsuario {
	
	User consultarUsuario (User usuario);
}
