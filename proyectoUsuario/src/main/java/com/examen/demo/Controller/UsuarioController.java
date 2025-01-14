package com.examen.demo.Controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.Entity.Usuario;
import com.examen.demo.Services.UsuarioService;

@CrossOrigin(origins= {"http://192.168.40.68:8080"})

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	//LISTAR Usuario
	@GetMapping("/usuarios")

		public List<Usuario> index(){
		return usuarioService.findAll();
		
	}
		//BUSCAR Usuario
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	//GUARDAR Usuario

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	//EDITAR Usuario
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setEstado(usuario.getEstado());
		usuarioActual.setClave(usuario.getClave());
		usuarioActual.setNombre(usuario.getNombre());
		
		return usuarioService.save(usuarioActual);
	}
	//ELIMINAR Usuario
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
