package comempleado.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import comempleado.entity.Departamento;
import comempleado.entity.Empleado;
import comempleado.service.DepartamentoService;
import comempleado.service.EmpleadoService;




@CrossOrigin
@RequestMapping("departamento")
@RestController
public class departamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@RequestMapping(value = "/departamento", method = RequestMethod.GET)
	public List<Departamento> departamentos() {

		return departamentoService.findAll();
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Departamento create(@RequestBody Departamento departamento) {

		return departamentoService.save(departamento);

	}

	@GetMapping("/verdepartamento/{id}")
	public Departamento show(@PathVariable Long id) {
		return departamentoService.findOne(id);
	}

	@PutMapping("/editardepartamento/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Departamento update(@RequestBody Departamento departamentos, @PathVariable Long id) {
		Departamento departamento = departamentoService.findOne(id);

		departamento.setNombreDepartamento(departamentos.getNombreDepartamento());
		departamento.setCodigoDepartamento(departamentos.getCodigoDepartamento());
		departamento.setDepartamento(departamento.getDepartamento());
		departamento.setFechaCreacion(departamentos.getFechaCreacion());
		

		return departamentoService.save(departamento);
	}
	
	
	@DeleteMapping("/eliminardepartamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delet(@PathVariable Long id) {
		departamentoService.delete(id);
	}

}
