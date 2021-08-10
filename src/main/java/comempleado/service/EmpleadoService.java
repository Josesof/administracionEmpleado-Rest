package comempleado.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comempleado.entity.Empleado;
import comempleado.entity.EmpleadoRepository;

@Service
public class EmpleadoService {
	


	@Autowired
	private EmpleadoRepository empleadoRepository;



	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) empleadoRepository.findAll();
	}
	
	public Empleado save(Empleado empleado) {
		
		return empleadoRepository.save(empleado);

	}
	
	public Empleado findOne(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		empleadoRepository.deleteById(id);

	}

}
