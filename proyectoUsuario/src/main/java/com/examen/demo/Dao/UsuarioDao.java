package com.examen.demo.Dao;
import org.springframework.data.repository.CrudRepository;
import com.examen.demo.Entity.Usuario;
public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
