# Tiquetera Catalog API

API REST para la gestión de eventos y venues (locaciones) del sistema Tiquetera.

## 📋 Tabla de Contenidos
1. [Características](#características)
2. [Requisitos](#requisitos)
3. [Instalación](#instalación)
4. [Uso](#uso)
5. [API Endpoints](#api-endpoints)
6. [Documentación](#documentación)
7. [Pruebas](#pruebas)
8. [Solución de Problemas](#solución-de-problemas)

## ✨ Características

- Gestión completa de Venues (CRUD)
- Gestión completa de Eventos (CRUD)
- Validación de datos
- Documentación OpenAPI/Swagger
- Persistencia en memoria
- Manejo global de errores

## 📦 Requisitos

- Java 17 o superior
- Maven 3.9+ (incluido wrapper mvnw)
- Puerto 8080 disponible (configurable)

## 🚀 Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/tiquetera/catalog.git
cd catalog
```

2. Verificar permisos del wrapper Maven:
```bash
chmod +x ./mvnw
```

3. Compilar el proyecto:
```bash
./mvnw clean package
```

## 💻 Uso

### Iniciar la aplicación

Usando Maven wrapper (recomendado):
```bash
./mvnw spring-boot:run
```

Usando el JAR empaquetado:
```bash
java -jar target/catalog-0.0.1-SNAPSHOT.jar
```

### Configuración

#### Perfiles disponibles
- `dev`: Desarrollo local
- `tes`: Pruebas

Para ejecutar con un perfil específico:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

#### Cambiar puerto
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

## 🔗 API Endpoints

### Venues

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/venues` | Crear venue |
| GET | `/venues` | Listar venues |
| GET | `/venues/{id}` | Obtener venue por ID |
| PUT | `/venues/{id}` | Actualizar venue |
| DELETE | `/venues/{id}` | Eliminar venue |

### Events

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/events` | Crear evento |
| GET | `/events` | Listar eventos |
| GET | `/events/{id}` | Obtener evento por ID |
| PUT | `/events/{id}` | Actualizar evento |
| DELETE | `/events/{id}` | Eliminar evento |

## 📖 Documentación

La documentación detallada está disponible en:

1. Swagger UI (cuando la aplicación está corriendo):
   - http://localhost:8080/swagger-ui.html

2. Documentación estática:
   - [Guía de Desarrollo](docs/development-guide.md)
   - [Ejemplos de API](docs/api-examples.md)
   - [Guía de Despliegue](docs/deployment-guide.md)

### Estructura de la Documentación
```
docs/
├── images/           # Capturas y diagramas
│   ├── api/         # Ejemplos de API
│   ├── setup/       # Guías de instalación
│   └── tests/       # Resultados de pruebas
├── api-examples.md   # Ejemplos de uso de API
├── development-guide.md # Guía para desarrolladores
└── deployment-guide.md  # Guía de despliegue
```

## 🧪 Pruebas

Ejecutar todas las pruebas:
```bash
./mvnw test
```

Pruebas específicas:
```bash
./mvnw test -Dtest=EventControllerTest
```

## 🔧 Solución de Problemas

### Logs
Los logs se encuentran en:
- Desarrollo: `./logs/catalog.log`
- Consola: Nivel INFO por defecto

### Problemas Comunes

1. Puerto en uso:
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

2. Limpiar proyecto:
```bash
./mvnw clean
```

3. Verificar dependencias:
```bash
./mvnw dependency:tree
```

## 📄 Licencia

Este proyecto está bajo la Licencia Apache 2.0 - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👥 Equipo

- Santiago Ortega
- Contacto: santiago@59782@gmail.com# catalog-service
