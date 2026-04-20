package mx.uv.eyrc.inventario.controller;

import java.net.ResponseCache;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.uv.eyrc.inventario.entity.Producto;
import mx.uv.eyrc.inventario.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService service;

    // Aquí puedes agregar métodos para manejar las solicitudes HTTP (GET, POST, PUT, DELETE)
    @GetMapping
    public List<Producto> ListarTodos() {
        return service.ListarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> ObtenerPorId(@PathVariable Long id) {
        return service.BuscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> Crear(@RequestBody Producto producto) {
        Producto nuevoProducto = service.Guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> Actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto actualizado = service.Guardar(producto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return ResponseEntity.noContent().build();
    }
}