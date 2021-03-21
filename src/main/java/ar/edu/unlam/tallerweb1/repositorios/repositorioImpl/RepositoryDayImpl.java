package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Day;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryDay;

@Repository
public class RepositoryDayImpl implements RepositoryDay {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Day getDayById(Long id) {
		return sessionFactory.getCurrentSession().get(Day.class, id);
	}

}
