package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Enroll;
import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryEnroll;

@Repository
public class RepositoryEnrollImpl implements RepositoryEnroll {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void postEnroll(Enroll enroll) {
		sessionFactory.getCurrentSession().save(enroll);
	}

	@Override
	public List<Enroll> getEnrollList() {
		return sessionFactory.getCurrentSession().createCriteria(Enroll.class).list();
	}

}
