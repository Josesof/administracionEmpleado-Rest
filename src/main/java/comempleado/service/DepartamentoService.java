package comempleado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comempleado.entity.Departamento;
import comempleado.entity.DepartamentoRepository;
import comempleado.entity.Empleado;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return (List<Departamento>) departamentoRepository.findAll();
	}
	
	public Departamento save(Departamento empleado) {
		
		return departamentoRepository.save(empleado);

	}
	
	public Departamento findOne(Long id) {
		// TODO Auto-generated method stub
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		departamentoRepository.deleteById(id);

	}

	

}
