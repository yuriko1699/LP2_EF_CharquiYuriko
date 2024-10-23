package pe.com.cibertec.lp2_EF_CharquiYuriko.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.lp2_EF_CharquiYuriko.model.UsuarioEntity;


public interface UsuarioService {
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(UsuarioEntity usuarioEntity);
	UsuarioEntity buscarUsuarioPorCorreo(String correo);
}
