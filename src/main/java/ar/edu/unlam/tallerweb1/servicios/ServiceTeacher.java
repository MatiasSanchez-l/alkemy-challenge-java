package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Teacher;

public interface ServiceTeacher {
	List<Teacher> getTeacherList();
	String getTeachersAjax();
	Teacher getTeacherById(Long teacherId);
	void changeName(Long id, String name);
	void changeLastName(Long id, String lastname);
	void changeDni(Long id, Long dni);
	void changeActive(Long id, Boolean active);
}
