package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRol;

@Repository
public class RepositorioRolImpl implements RepositorioRol {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Rol getRolPorDescripcion(String descripcion) {
		return (Rol)sessionFactory.getCurrentSession().createCriteria(Rol.class)
				.add(Restrictions.eq("description", descripcion)).uniqueResult();
	}

}
