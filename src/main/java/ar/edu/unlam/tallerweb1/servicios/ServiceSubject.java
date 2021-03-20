package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Subject;

public interface ServiceSubject {
	
	List<Subject> getListOfSubjects();
	TreeSet<Subject> getListOfSubjectsSortedAlphabetically();
}
