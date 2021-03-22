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
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;
import ar.edu.unlam.tallerweb1.servicios.ServiceUser;

@Service
@Transactional
public class ServiceEnrollImpl implements ServiceEnroll {
	
	@Autowired
	private RepositoryEnroll repositryEnroll;
	@Autowired
	private ServiceSubject serviceSubject;
	@Autowired
	private ServiceUser serviceUser;
	
	@Override
	public void enrollStudentInSubjects(User student, List<Subject> subjects) {
		
		for(Subject subject : subjects) {
			Boolean studentInSubject = false;
			studentInSubject = studentAlreadyInSubject(student.getId(), subject.getId());
			if(!studentInSubject) {
				Enroll enroll = new Enroll();
				enroll.setStuden(student);
				enroll.setSubject(subject);
				this.postEnroll(enroll);
				serviceSubject.setCurrentPlaces(subject.getId());
			}
			
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

	@Override
	public List<Enroll> getEnrollListBySubject(Subject subject) {
		return repositryEnroll.getEnrollListBySubject(subject);
	}

	@Override
	public Boolean studentAlreadyInSubject(Long studentId, Long subjectId) {
		Boolean result = false;
		
		Subject subject = serviceSubject.getSubjectById(subjectId);
		User student = serviceUser.getUserById(studentId);
		Enroll enroll = getEnrollByStudentAndSubject(student, subject);
		
		if(enroll != null) {
			result = true;
		}
		return result;
	}

	@Override
	public Enroll getEnrollByStudentAndSubject(User student, Subject subject) {
		return repositryEnroll.getEnrollByStudentAndSubject(student, subject);
	}

}
