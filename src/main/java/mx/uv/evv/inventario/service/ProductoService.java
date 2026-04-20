package mx.uv.evv.inventario.service;

import lombok.RequiredArgsConstructor;
import mx.uv.evv.inventario.entity.Producto;
import mx.uv.evv.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductoService {
    private final ProductoRepository repository;

    public List<Producto> listAll(){
        return repository.findAll();
    }

    public Optional<Producto> searchId(Long id){
        return repository.findById(id);
    }

    public Producto save(Producto producto){
        return repository.save(producto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
