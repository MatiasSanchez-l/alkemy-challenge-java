package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Schedule;


public interface ServiceSchedule {
	List<Schedule> getScheduleList();

	Schedule getScheduleById(Long scheduleId);
	
	void changeDay(Long id, Long dayId);
	void changeTeacher(Long id, Long teacherId);
}
