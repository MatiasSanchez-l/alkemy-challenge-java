package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Day;
import ar.edu.unlam.tallerweb1.modelo.Schedule;
import ar.edu.unlam.tallerweb1.modelo.Teacher;
import ar.edu.unlam.tallerweb1.repositorios.RepositorySchedule;
import ar.edu.unlam.tallerweb1.servicios.ServiceDay;
import ar.edu.unlam.tallerweb1.servicios.ServiceSchedule;
import ar.edu.unlam.tallerweb1.servicios.ServiceTeacher;

@Service
@Transactional
public class ServiceScheduleImpl implements ServiceSchedule {
	
	@Autowired
	private RepositorySchedule repositorySchedule;
	
	@Autowired
	private ServiceDay serviceDay;
	
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@Override
	public List<Schedule> getScheduleList() {
		return repositorySchedule.getScheduleList();
	}

	@Override
	public Schedule getScheduleById(Long id) {
		return repositorySchedule.getScheduleById(id);
	}

	@Override
	public void changeDay(Long id, Long dayId) {
		Schedule schedule = getScheduleById(id);
		Day day = serviceDay.getDayById(dayId);
		schedule.setDay(day);
	}

	@Override
	public void changeTeacher(Long id, Long teacherId) {
		Schedule schedule = getScheduleById(id);
		Teacher teacher = serviceTeacher.getTeacherById(teacherId);
		schedule.setTeacher(teacher);
	}

}
