package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Schedule;
import ar.edu.unlam.tallerweb1.repositorios.RepositorySchedule;

@Repository
public class RepositoryScheduleImpl implements RepositorySchedule {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Schedule> getScheduleList() {
		return sessionFactory.getCurrentSession().createCriteria(Schedule.class).list();
	}

	@Override
	public Schedule getScheduleById(Long id) {
		return sessionFactory.getCurrentSession().get(Schedule.class, id);
	}

}
