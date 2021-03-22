package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Teacher;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryTeacher;
import ar.edu.unlam.tallerweb1.servicios.ServiceTeacher;


@Service
@Transactional
public class ServiceTeacherImpl implements ServiceTeacher {
	@Autowired
	private RepositoryTeacher repositoryTeacher;
	
	@Override
	public List<Teacher> getTeacherList() {
		return repositoryTeacher.getTeacherList();
	}

	@Override
	public String getTeachersAjax() {
		List<Teacher> teachers = this.repositoryTeacher.getTeacherList();
		String teacherAjax = "";
		for (Teacher teacher : teachers) {
			teacherAjax += "<option value=" + teacher.getId()+ ">"+teacher.getLastname() + " " + teacher.getName()+"</option>";
		}
		return teacherAjax;
	}

	@Override
	public Teacher getTeacherById(Long teacherId) {
		return repositoryTeacher.getTeacherById(teacherId);
	}

	@Override
	public void setName(Long id, String name) {
		Teacher teacher = getTeacherById(id);
		teacher.setName(name);
		
	}

	@Override
	public void setLastName(Long id, String lastname) {
		Teacher teacher = getTeacherById(id);
		teacher.setLastname(lastname);
		
	}

	@Override
	public void setDni(Long id, Long dni) {
		Teacher teacher = getTeacherById(id);
		teacher.setDni(dni);
		
	}

	@Override
	public void setActive(Long id, Boolean active) {
		Teacher teacher = getTeacherById(id);
		teacher.setActive(active);
		
	}

	@Override
	public Boolean teacherWithExistingDni(Long dni) {
		List<Teacher> teachers = getTeacherList();
		Boolean result = false;
		for (Teacher teacher : teachers) {
			System.out.println("comparo profesor dni " + teacher.getDni() + " con el dni " + dni);
			if(teacher.getDni().compareTo(dni) == 0) {
				System.out.println("lo cambie a true");
				result = true;
				return result;
			}
		}
		return result;
	}

}
