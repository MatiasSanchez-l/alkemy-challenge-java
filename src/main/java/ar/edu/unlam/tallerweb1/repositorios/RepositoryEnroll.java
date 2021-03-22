package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Enroll;
import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;

public interface RepositoryEnroll {
	void postEnroll(Enroll enroll);

	List<Enroll> getEnrollList();

	List<Enroll> getEnrollListBySubject(Subject subject);

	Enroll getEnrollByStudentAndSubject(User student, Subject subject);
}
