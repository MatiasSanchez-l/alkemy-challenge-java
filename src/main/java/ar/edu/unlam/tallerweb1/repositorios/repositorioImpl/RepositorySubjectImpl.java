package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.repositorios.RepositorySubject;

@Repository
public class RepositorySubjectImpl implements RepositorySubject {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Subject> getListOfSubjects() {
		return sessionFactory.getCurrentSession().createCriteria(Subject.class).list();
	}

	@Override
	public Subject getSubjectById(Long id) {
		return sessionFactory.getCurrentSession().get(Subject.class, id);
	}

}
