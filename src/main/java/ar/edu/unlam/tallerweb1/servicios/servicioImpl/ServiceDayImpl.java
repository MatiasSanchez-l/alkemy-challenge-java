package ar.edu.unlam.tallerweb1.servicios.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Day;
import ar.edu.unlam.tallerweb1.repositorios.RepositoryDay;
import ar.edu.unlam.tallerweb1.servicios.ServiceDay;

@Service
@Transactional
public class ServiceDayImpl implements ServiceDay {
	
	@Autowired
	private RepositoryDay repositoryDay;
	
	@Override
	public Day getDayById(Long id) {
		return repositoryDay.getDayById(id);
	}

}
