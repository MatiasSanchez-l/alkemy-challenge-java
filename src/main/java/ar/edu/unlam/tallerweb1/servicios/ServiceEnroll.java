package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Enroll;
import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;

public interface ServiceEnroll {
	void postEnroll(Enroll enroll);
	void enrollStudentInSubjects(User student, List<Subject> subjects);
	List<Enroll> getEnrollList();
}
