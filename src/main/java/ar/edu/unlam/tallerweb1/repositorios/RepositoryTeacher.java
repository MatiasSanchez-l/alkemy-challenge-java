package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Teacher;

public interface RepositoryTeacher {
	List<Teacher> getTeacherList();

	Teacher getTeacherById(Long teacherId);
}
