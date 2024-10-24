package pe.com.cibertec.lp2_EF_CharquiYuriko.service;

import java.util.List;

import pe.com.cibertec.lp2_EF_CharquiYuriko.model.ProductoEntity;

public interface ProductoService {

	List<ProductoEntity> buscarTodosProductos();
    ProductoEntity buscarProductoPorId(Integer id);
    ProductoEntity crear(ProductoEntity producto);
    ProductoEntity actualizar(ProductoEntity producto);
    void eliminar(Integer id);
}
