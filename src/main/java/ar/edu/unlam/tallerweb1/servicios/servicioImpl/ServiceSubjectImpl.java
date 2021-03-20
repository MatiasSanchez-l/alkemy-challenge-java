package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.SubjectsSortedAlphabetically;
import ar.edu.unlam.tallerweb1.repositorios.RepositorySubject;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;

@Service
@Transactional
public class ServiceSubjectImpl implements ServiceSubject{
	
	@Autowired
	private RepositorySubject repositorysubject;
	
	@Override
	public List<Subject> getListOfSubjects() {
		
		return repositorysubject.getListOfSubjects();
	}

	@Override
	public TreeSet<Subject> getListOfSubjectsSortedAlphabetically() {
		List<Subject> subjects = this.getListOfSubjects();

		SubjectsSortedAlphabetically SortedAlphabetically = new SubjectsSortedAlphabetically();

		TreeSet<Subject> SubjectsSortedAlphabetically = new TreeSet<Subject>(SortedAlphabetically);

		SubjectsSortedAlphabetically.addAll(subjects);

		return SubjectsSortedAlphabetically;
	}

	@Override
	public Subject getSubjectById(Long id) {
		return repositorysubject.getSubjectById(id);
	}

}
