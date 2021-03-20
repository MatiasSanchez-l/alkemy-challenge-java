package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.User;

public interface ServiceUser {
	User getUsuario(User usuario);

	void registrarUsuario(User usuario);

}
