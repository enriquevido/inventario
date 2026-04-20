package mx.uv.evv.inventario.repository;

import mx.uv.evv.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
