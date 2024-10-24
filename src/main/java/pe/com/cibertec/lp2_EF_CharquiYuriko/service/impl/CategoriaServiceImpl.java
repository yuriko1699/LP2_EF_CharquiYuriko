package pe.com.cibertec.lp2_EF_CharquiYuriko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.lp2_EF_CharquiYuriko.model.CategoriaEntity;
import pe.com.cibertec.lp2_EF_CharquiYuriko.repository.CategoriaRepository;
import pe.com.cibertec.lp2_EF_CharquiYuriko.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaEntity> listarCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
