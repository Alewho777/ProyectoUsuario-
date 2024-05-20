package com.examen.demo.Services;

import java.util.*;

import com.examen.demo.Entity.Usuario;


public interface UsuarioService {
	public List<Usuario> findAll();
	public Usuario save(Usuario usuario);
	public Usuario findById(Long id);
	public void delete (Long id);
}
