package pe.com.cibertec.lp2_EF_CharquiYuriko.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.lp2_EF_CharquiYuriko.model.ProductoEntity;
import pe.com.cibertec.lp2_EF_CharquiYuriko.repository.ProductoRepository;
import pe.com.cibertec.lp2_EF_CharquiYuriko.service.ProductoService;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> buscarTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity crear(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity actualizar(ProductoEntity producto) {
        // Check if the product exists before updating
        if (productoRepository.existsById(producto.getProductoId())) {
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            
        }
    }
	
	
}
