# Guía de Desarrollo

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/tiquetera/catalog/
│   │       ├── config/          # Configuración
│   │       ├── controller/      # Controllers REST
│   │       ├── dto/            # Data Transfer Objects
│   │       ├── exception/      # Manejo de errores
│   │       ├── mapper/         # Mappers DTO-Entity
│   │       ├── model/          # Modelos de dominio
│   │       ├── repository/     # Repositorios
│   │       └── service/        # Servicios
│   └── resources/
│       ├── application.yml     # Configuración principal
│       ├── application-dev.yml # Perfil desarrollo
│       └── application-tes.yml # Perfil pruebas
```

## Componentes Principales

### 1. Controllers

Los controllers implementan la capa REST y están documentados con OpenAPI:

```java
@RestController
@RequestMapping("/venues")
public class VenueController {
    @Operation(summary = "Crear venue")
    @PostMapping
    public ResponseEntity<VenueDTO> create(@Valid @RequestBody VenueDTO dto) {
        // ...
    }
}
```

### 2. DTOs

Los DTOs incluyen validaciones y documentación OpenAPI:

```java
public class VenueDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre del venue", example = "Estadio Central")
    private String name;
    // ...
}
```

### 3. Mappers

Los mappers convierten entre DTOs y entidades:

```java
public class VenueMapper {
    public static Venue toDomain(VenueDTO dto) {
        // ...
    }
    
    public static VenueDTO toDto(Venue domain) {
        // ...
    }
}
```

## Configuración OpenAPI

La documentación OpenAPI está configurada en `OpenApiConfig.java`:

```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI catalogOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Tiquetera Catalog API")
                .version("0.1.0")
                // ...
            );
    }
}
```

## Manejo de Errores

El sistema usa un manejador global de excepciones en `GlobalExceptionHandler`:

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNotFound(/*...*/) {
        // ...
    }
}
```

## Guías de Desarrollo

### 1. Añadir un Nuevo Endpoint

1. Crear DTO con validaciones
2. Añadir mappers necesarios
3. Implementar lógica en service
4. Crear endpoint en controller con documentación OpenAPI
5. Añadir pruebas unitarias

### 2. Documentación de Código

- Usar JavaDoc en clases y métodos públicos
- Incluir ejemplos en anotaciones @Schema
- Documentar respuestas con @ApiResponse

### 3. Pruebas

- Crear pruebas unitarias para cada componente
- Usar casos de prueba que cubran casos edge
- Documentar escenarios de prueba

## Estándares de Código

1. **Nombrado**
   - CamelCase para clases y métodos
   - Nombres descriptivos y en inglés

2. **Documentación**
   - JavaDoc en clases y métodos públicos
   - Comentarios explicativos cuando sea necesario

3. **Organización**
   - Un archivo por clase
   - Paquetes por funcionalidad

4. **Validación**
   - Usar anotaciones Jakarta Validation
   - Validar en capa de servicio

## Flujo de Trabajo Git

1. Crear rama feature/bugfix
2. Desarrollar y probar
3. Actualizar documentación
4. Crear PR con descripción detallada