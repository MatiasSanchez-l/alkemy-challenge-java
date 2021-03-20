package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryUsuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("repositorioUsuario")
public class RepositoryUserImpl implements RepositoryUsuario {
	@Autowired
	private SessionFactory sessionFactory;

    @Autowired
	public RepositoryUserImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User consultarUsuario(User usuario) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("dni", usuario.getDni()))
				.add(Restrictions.eq("legajo", usuario.getLegajo()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.add(Restrictions.eq("rol", usuario.getRol()))
				.uniqueResult();
	}

}
