package ista.cursoM5A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM5A.dao.IUsuariosDao;
import ista.cursoM5A.entity.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	private IUsuariosDao UDao;
	
	@Override
	@Transactional (readOnly=true) // indica que esta transacción es solo de lectura.
	public List<Usuarios> listarUsu() {
		return (List<Usuarios>) UDao.findAll();
	}

	@Override
	@Transactional // indica que esta operacion puede realizar modificaciones en la base de datos.
	public Usuarios save(Usuarios usus) {
		return UDao.save(usus);
	}

	@Override
	@Transactional (readOnly=true)
	public Usuarios buscarUsuId(Long id) {
		return UDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		UDao.deleteById(id);		
	}
	
}
