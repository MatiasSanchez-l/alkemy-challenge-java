package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class SubjectsSortedAlphabetically implements Comparator<Subject>{

	@Override
	public int compare(Subject subject0, Subject subject1) {
		return subject0.getName().compareTo(subject1.getName());
	}

}
