# Guía de Despliegue

## 1. Preparación del Entorno

### Requisitos del Sistema
- Java 17 o superior
- 512MB RAM mínimo
- 1GB espacio en disco
- Puerto 8080 disponible (configurable)

### Variables de Entorno
```bash
JAVA_HOME=/path/to/java
SPRING_PROFILES_ACTIVE=dev
SERVER_PORT=8080
```

## 2. Construcción del Proyecto

### Usando Maven Wrapper
```bash
./mvnw clean package
```

### Verificar el Build
```bash
ls -l target/catalog-0.0.1-SNAPSHOT.jar
```

## 3. Opciones de Despliegue

### 1. Ejecutar como Servicio Java

Crear archivo de servicio systemd:
```ini
[Unit]
Description=Tiquetera Catalog API
After=network.target

[Service]
Type=simple
User=tiquetera
ExecStart=/usr/bin/java -jar /path/to/catalog-0.0.1-SNAPSHOT.jar
Restart=always
Environment="SPRING_PROFILES_ACTIVE=prod"
Environment="SERVER_PORT=8080"

[Install]
WantedBy=multi-user.target
```

### 2. Contenedor Docker

Dockerfile incluido:
```dockerfile
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

Construir y ejecutar:
```bash
docker build -t tiquetera/catalog .
docker run -p 8080:8080 tiquetera/catalog
```

## 4. Configuración

### application.yml
```yaml
spring:
  application:
    name: catalog
server:
  port: 8080
```

### Perfiles
- dev: Desarrollo local
- tes: Pruebas
- prod: Producción

### Activar Perfil
```bash
java -jar catalog-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

## 5. Monitoreo

### Endpoints de Actuator
- /actuator/health
- /actuator/info
- /actuator/metrics

### Logs
- Ubicación: ./logs/catalog.log
- Nivel: INFO por defecto

### Configuración de Logs
```yaml
logging:
  level:
    root: INFO
    com.tiquetera: DEBUG
  file:
    name: ./logs/catalog.log
```

## 6. Backup y Recuperación

### Respaldo de Configuración
```bash
cp -r src/main/resources/application*.yml /backup/
```

### Restauración
```bash
cp /backup/application*.yml src/main/resources/
```

## 7. Seguridad

### Recomendaciones
1. Usar HTTPS en producción
2. Configurar CORS apropiadamente
3. Implementar rate limiting
4. Monitorear logs de acceso

### Configuración HTTPS
```yaml
server:
  ssl:
    key-store: classpath:keystore.p12
    key-store-password: ${KEYSTORE_PASSWORD}
    key-store-type: PKCS12
```

## 8. Escalabilidad

### Horizontal
- Balanceo de carga con nginx/haproxy
- Sesiones distribuidas si se implementan

### Vertical
- Aumentar memoria: -Xmx512m
- Ajustar pool de conexiones

## 9. Troubleshooting

### Problemas Comunes

1. Puerto en uso
```bash
netstat -tulpn | grep 8080
kill -9 PID
```

2. Memoria insuficiente
```bash
java -Xmx512m -jar catalog-0.0.1-SNAPSHOT.jar
```

3. Verificar estado
```bash
curl http://localhost:8080/actuator/health
```

## 10. Mantenimiento

### Diario
- Monitorear logs
- Verificar espacio en disco
- Comprobar endpoints de salud

### Semanal
- Revisar métricas
- Backup de configuración
- Análisis de logs

### Mensual
- Actualizar dependencias
- Revisar seguridad
- Optimizar rendimiento