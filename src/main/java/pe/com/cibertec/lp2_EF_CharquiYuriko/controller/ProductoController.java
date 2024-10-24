package pe.com.cibertec.lp2_EF_CharquiYuriko.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.lp2_EF_CharquiYuriko.model.CategoriaEntity;
import pe.com.cibertec.lp2_EF_CharquiYuriko.model.ProductoEntity;
import pe.com.cibertec.lp2_EF_CharquiYuriko.model.UsuarioEntity;
import pe.com.cibertec.lp2_EF_CharquiYuriko.service.CategoriaService;
import pe.com.cibertec.lp2_EF_CharquiYuriko.service.ProductoService;
import pe.com.cibertec.lp2_EF_CharquiYuriko.service.UsuarioService;



@Controller
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {
	

	private final ProductoService productoService;
	private final CategoriaService categoriaService;
	private final UsuarioService usuarioService;
	
	

	@GetMapping("/")
	public String listarProducto(Model model , HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		String usuarioSesion = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEncontrado = usuarioService.buscarUsuarioPorCorreo(usuarioSesion);
		model.addAttribute("usuario", usuarioEncontrado.getNombres() + " " + usuarioEncontrado.getApellidos());
		
		List<ProductoEntity> listaProducto = productoService.buscarTodosProductos();
		model.addAttribute("listaprod", listaProducto);
		return "listar_producto";
	}

	@GetMapping("/registrar_producto")
	public String mostrarRegistrarProducto(Model model, HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		String usuarioSesion = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEncontrado = usuarioService.buscarUsuarioPorCorreo(usuarioSesion);
		model.addAttribute("usuario", usuarioEncontrado.getNombres() + " " + usuarioEncontrado.getApellidos());
		
		List<CategoriaEntity> listaCategoria = categoriaService.listarCategoria();

		model.addAttribute("categorias", listaCategoria);
		model.addAttribute("producto", new ProductoEntity());
		return "registrar_producto";
	}

	@PostMapping("/registrar_producto")
	public String registrarProducto(@ModelAttribute("producto") ProductoEntity producto) {
		productoService.crear(producto);
		return "redirect:/producto";
	}

	@PostMapping("/eliminar_producto")
	public String eliminarProducto(@RequestParam("productoId") int productoId) {
		productoService.eliminar(productoId);
		return "redirect:/listar_producto";
	}
	
	@GetMapping("/actualizar_producto")
	public String actualizarProducto(@RequestParam("productoId") int productoId, Model model) {
		model.addAttribute("categorias", categoriaService.listarCategoria());
		model.addAttribute("producto", productoService.buscarProductoPorId(productoId));
		return "registrar_producto";
		
	}
}
