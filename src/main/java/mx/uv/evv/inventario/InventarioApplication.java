package mx.uv.evv.inventario;

import java.time.LocalDateTime;

import mx.uv.evv.inventario.entity.Producto;
import mx.uv.evv.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductoRepository repository){
		return args -> {
			if (repository.count() > 0) {
				return;
			}

			repository.save(new Producto(null, "Laptop Dell", "i7 16GB RAM", 15500.50, 5, "Electronica", LocalDateTime.now()));
			repository.save(new Producto(null, "Mouse", "Inalambrico", 500.50, 5, "Electronica", LocalDateTime.now()));
			repository.save(new Producto(null, "Audifonos", "Sony", 1500.50, 1, "Electronica", LocalDateTime.now()));
		};
	}

}
