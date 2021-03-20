package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.User;

public interface ServiceSubject {
	
	List<Subject> getListOfSubjects();
	TreeSet<Subject> getListOfSubjectsWhereStudentIsNotEnroll(User student);
	TreeSet<Subject> getListOfSubjectsWhereStudentIsEnroll(User student);
	TreeSet<Subject> getListOfSubjectsSortedAlphabetically();
	TreeSet<Subject> sortSubjectsAlphabetically(List<Subject> subjects);
	Subject getSubjectById(Long id);
}
