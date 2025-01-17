package ista.cursoM5A.service;

import java.util.List;

import ista.cursoM5A.entity.Usuarios;

public interface IUsuariosService {

	public List<Usuarios> listarUsu();
	
	public Usuarios save(Usuarios usus);
	
	public Usuarios buscarUsuId(Long id);
	
	public void delete(Long id);
	
}
