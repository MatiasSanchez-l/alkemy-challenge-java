package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Enroll;
import ar.edu.unlam.tallerweb1.modelo.Subject;
import ar.edu.unlam.tallerweb1.modelo.SubjectsSortedAlphabetically;
import ar.edu.unlam.tallerweb1.modelo.User;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryEnroll;
import ar.edu.unlam.tallerweb1.repositorios.RepositorySubject;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryUser;
import ar.edu.unlam.tallerweb1.servicios.ServiceSubject;

@Service
@Transactional
public class ServiceSubjectImpl implements ServiceSubject{
	
	@Autowired
	private RepositorySubject repositorysubject;
	@Autowired
	private RepositoryEnroll repositoryEnroll;
	
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

	@Override
	public TreeSet<Subject> getListOfSubjectsWhereStudentIsNotEnroll(User student) {
		
		TreeSet<Subject> subjectList= this.getListOfSubjectsSortedAlphabetically();
		List<Enroll> enrollList = repositoryEnroll.getEnrollList();
		
		for (Enroll enroll : enrollList) {
			if(enroll.getStuden().getId().equals(student.getId())) {
				subjectList.remove(enroll.getSubject());
			}
		}
		
		return subjectList;
	}
	
	@Override
	public TreeSet<Subject> getListOfSubjectsWhereStudentIsEnroll(User student) {
		
		List<Subject> subjectList= new ArrayList<Subject>();
		List<Enroll> enrollList = repositoryEnroll.getEnrollList();
		
		for (Enroll enroll : enrollList) {
			if(enroll.getStuden().getId().equals(student.getId())) {
				subjectList.add(enroll.getSubject());
			}
		}
		
		TreeSet<Subject> subjectListSorted = sortSubjectsAlphabetically(subjectList);
		
		return subjectListSorted;
	}

	@Override
	public TreeSet<Subject> sortSubjectsAlphabetically(List<Subject> subjects) {

		SubjectsSortedAlphabetically SortedAlphabetically = new SubjectsSortedAlphabetically();

		TreeSet<Subject> SubjectsSortedAlphabetically = new TreeSet<Subject>(SortedAlphabetically);

		SubjectsSortedAlphabetically.addAll(subjects);

		return SubjectsSortedAlphabetically;
	}

	@Override
	public void setName(Long id, String name) {
		Subject subject = getSubjectById(id);
		subject.setName(name);
	}

	@Override
	public void changeStartTime(Long id, Long time) {
		Subject subject = getSubjectById(id);
		subject.setStart_time(time);
	}

	@Override
	public void changeFinishTime(Long id, Long time) {
		Subject subject = getSubjectById(id);
		subject.setFinish_time(time);
	}

	@Override
	public void changeShift(Long id, String shift) {
		Subject subject = getSubjectById(id);
		subject.setShift(shift);
	}

	@Override
	public void changeMaxPlaces(Long id, Long places) {
		Subject subject = getSubjectById(id);
		subject.setMax_places(places);
		setCurrentPlaces(id);
	}

	@Override
	public void maxPlacesMinusOne(Long id) {
		Subject subject = getSubjectById(id);
		Long maxPlacesMinusOne = subject.getMax_places() - 1;
		
		subject.setMax_places(maxPlacesMinusOne);
	}

	@Override
	public void setCurrentPlaces(Long id) {
		Subject subject = getSubjectById(id);
		Long studentsEnroll = 0L;
		
		List <Enroll> enrolls = repositoryEnroll.getEnrollListBySubject(subject);
		studentsEnroll = new Long(enrolls.size());
		
		Long currentPlaces = subject.getMax_places() - studentsEnroll;
		
		subject.setCurrent_places(currentPlaces);
	}

}
