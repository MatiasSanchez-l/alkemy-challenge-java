package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Teacher;

public interface ServiceTeacher {
	List<Teacher> getTeacherList();
	String getTeachersAjax();
	Teacher getTeacherById(Long teacherId);
	Boolean teacherWithExistingDni(Long dni);
	void setName(Long id, String name);
	void setLastName(Long id, String lastname);
	void setDni(Long id, Long dni);
	void setActive(Long id, Boolean active);
}
