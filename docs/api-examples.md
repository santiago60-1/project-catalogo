# Ejemplos de API

## Venues API

### 1. Crear Venue

#### Request
```http
POST /venues
Content-Type: application/json

{
  "name": "Estadio Central",
  "address": "Av Principal #123",
  "capacity": 20000
}
```

#### Response
```http
HTTP/1.1 201 Created
Location: /venues/1
Content-Type: application/json

{
  "id": 1,
  "name": "Estadio Central",
  "address": "Av Principal #123",
  "capacity": 20000
}
```

### 2. Listar Venues

#### Request
```http
GET /venues
```

#### Response
```http
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": 1,
    "name": "Estadio Central",
    "address": "Av Principal #123",
    "capacity": 20000
  }
]
```

## Events API

### 1. Crear Evento

#### Request
```http
POST /events
Content-Type: application/json

{
  "name": "Concierto Rock",
  "description": "Festival de Rock 2026",
  "venueId": 1,
  "date": "2026-03-15T20:00:00"
}
```

#### Response
```http
HTTP/1.1 201 Created
Location: /events/1
Content-Type: application/json

{
  "id": 1,
  "name": "Concierto Rock",
  "description": "Festival de Rock 2026",
  "venueId": 1,
  "date": "2026-03-15T20:00:00"
}
```

## Errores Comunes

### 1. Recurso No Encontrado

```http
HTTP/1.1 404 Not Found
Content-Type: application/json

{
  "timestamp": "2025-10-28T10:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Venue no encontrado",
  "path": "/venues/999"
}
```

### 2. Error de Validación

```http
HTTP/1.1 400 Bad Request
Content-Type: application/json

{
  "timestamp": "2025-10-28T10:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "name: El nombre del venue no puede estar vacío",
  "path": "/venues"
}
```

## Ejemplos con cURL

### Crear Venue
```bash
curl -X POST http://localhost:8080/venues \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Estadio Central",
    "address": "Av Principal #123",
    "capacity": 20000
  }'
```

### Crear Evento
```bash
curl -X POST http://localhost:8080/events \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Concierto Rock",
    "description": "Festival de Rock 2026",
    "venueId": 1,
    "date": "2026-03-15T20:00:00"
  }'
```

## Ejemplos con HTTPie

### Listar Venues
```bash
http GET http://localhost:8080/venues
```

### Obtener Evento por ID
```bash
http GET http://localhost:8080/events/1
```