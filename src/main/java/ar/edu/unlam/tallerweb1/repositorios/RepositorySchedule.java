package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Schedule;

public interface RepositorySchedule {
	List<Schedule> getScheduleList();

	Schedule getScheduleById(Long id);
}
