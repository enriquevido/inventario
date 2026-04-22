# API Rest - Inventario de productos

API REST completa para gestionar el inventario de una tienda, construida en Spring Boot, Gradle, PostgreSQL y dockerizada.

## Tech stack
- Spring Boot 4.0.5
- Gradle
- PostgreSQL
- JPA - Hibernate
- Docker, Docker compose

## Cómo ejecutar localmente
```bash
#1. Clonar el repositorio
git clone https://github.com/enriquevido/inventario.git

#2. Entrar a la carpeta inventario
cd inventario

#3. Ejecutar con Docker Compose
docker compose up --build
```

## Endpoints
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| GET | /api/productos | Lista todos los productos |
| GET | /api/productos/{id} | Obtener productos por ID |
| POST | /api/productos | Crear nuevo producto |
| PUT | /api/productos/{id} | Actualizar producto |
| DELETE | /api/productos/{id} | Eliminar producto |
