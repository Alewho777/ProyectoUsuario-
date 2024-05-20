package com.examen.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.Entity.Usuario;
import com.examen.demo.Dao.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioDao UsuarioDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) UsuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return UsuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return UsuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		UsuarioDao.deleteById(id);
	}

}
