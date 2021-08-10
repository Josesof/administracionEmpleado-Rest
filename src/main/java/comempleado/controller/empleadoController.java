package comempleado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import comempleado.entity.Empleado;
import comempleado.service.EmpleadoService;

@RestController
@CrossOrigin
@RequestMapping("empleado")
public class empleadoController  {
	
	
	@Autowired
	private EmpleadoService empleadoService;

	
	@RequestMapping(value = "/empleado", method = RequestMethod.GET)
	public List<Empleado> clientes() {

		return empleadoService.findAll();
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado empleado) {

		return empleadoService.save(empleado);

	}

	@GetMapping("/ver/{id}")
	public Empleado show(@PathVariable Long id) {
		return empleadoService.findOne(id);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado empleados, @PathVariable Long id) {
		Empleado empleado = empleadoService.findOne(id);

		empleado.setNombre(empleados.getNombre());
		empleado.setNombreCalle(empleados.getNombreCalle());
		empleado.setContrasena(empleados.getContrasena());
		empleado.setDireccionCodigoPostal(empleados.getDireccionCodigoPostal());
		empleado.setNumeroTelefono(empleados.getNumeroTelefono());
		empleado.setFechaCreacion(empleados.getFechaCreacion());
		empleado.setFechaFin(empleados.getFechaFin());		
		

		return empleadoService.save(empleado);
	}
	
	
	@DeleteMapping("/eliminar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delet(@PathVariable Long id) {
		empleadoService.delete(id);
	}

}
