package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Enroll;
import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryEnroll;
import ar.edu.unlam.tallerweb1.servicios.ServiceEnroll;

@Service
@Transactional
public class ServiceEnrollImpl implements ServiceEnroll {
	@Autowired
	private RepositoryEnroll repositryEnroll;
	
	@Override
	public void enrollStudentInSubjects(User student, List<Subject> subjects) {
		
		for(Subject subject : subjects) {
			Enroll enroll = new Enroll();
			enroll.setStuden(student);
			enroll.setSubject(subject);
			this.postEnroll(enroll);
		}
	}

	@Override
	public void postEnroll(Enroll enroll) {
		repositryEnroll.postEnroll(enroll);
	}

	@Override
	public List<Enroll> getEnrollList() {
		return repositryEnroll.getEnrollList();
	}

}
