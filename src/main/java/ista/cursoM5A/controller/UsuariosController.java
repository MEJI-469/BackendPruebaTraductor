package ista.cursoM5A.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ista.cursoM5A.entity.Usuarios;
import ista.cursoM5A.service.IUsuariosService;

@RestController // esto indica que esta clase manejara solicitudes HTTP y devolverá respuestasen formato JSON.
@RequestMapping("/api/usuario") // todas las rutas definidas aqui comenzaran con "/api".
public class UsuariosController {

	@Autowired
	private IUsuariosService ServiS;

	
	// se asocia con el endpoint GET "/api/listado".
	@GetMapping("/listado")
	public Object listadoUsu() {
		return ServiS.listarUsu();
	}

	// buscar por id
	@GetMapping("/listadoID/{id}")
	public Usuarios show(@PathVariable("id") Long id) {
		return ServiS.buscarUsuId(id);
	}

	// guardar
	@PostMapping("/IngresarUsuario")
	@ResponseStatus(HttpStatus.CREATED) // devuelve un estado http 201 CREATED si la operacion tiene exito.
	public Usuarios create(@RequestBody Usuarios songs) {
		return ServiS.save(songs);
	}

	// editar
	@PutMapping("/editarUsu/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios update(@RequestBody Usuarios usus, @PathVariable("id") Long id) {
		// busca el usuario actual por su ID.
		Usuarios UActual = ServiS.buscarUsuId(id);

		UActual.setUsername(usus.getUsername());
		UActual.setPassword(usus.getPassword());

		return ServiS.save(UActual);
	}

	// eliminar
	@DeleteMapping("/eliminarID/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable("id") Long id) {
		ServiS.delete(id);
	}
	
}
