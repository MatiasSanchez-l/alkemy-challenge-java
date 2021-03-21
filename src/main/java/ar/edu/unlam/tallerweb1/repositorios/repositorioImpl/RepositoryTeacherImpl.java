package ar.edu.unlam.tallerweb1.repositorios.repositorioImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Teacher;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryTeacher;

@Repository
public class RepositoryTeacherImpl implements RepositoryTeacher {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Teacher> getTeacherList() {
		return sessionFactory.getCurrentSession().createCriteria(Teacher.class).list();
	}

	@Override
	public Teacher getTeacherById(Long teacherId) {
		return sessionFactory.getCurrentSession().get(Teacher.class, teacherId);
	}

}
