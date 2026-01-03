# Rick and Morty Batch con Elasticsearch

Proyecto full-stack que implementa un **proceso batch en Spring Boot** para consumir la API pública de Rick and Morty, **indexar todos los personajes en Elasticsearch** y exponerlos mediante un **backend REST**, el cual es consumido por un **frontend en JavaScript (Vanilla JS)**.

El objetivo del proyecto es demostrar integración de sistemas, batch processing y consulta de datos indexados.

---

## 🧠 Descripción general

El sistema funciona de la siguiente manera:

1. Un **proceso batch** consume la API de Rick and Morty (paginada).
2. Los personajes se transforman y se **indexan en Elasticsearch**.
3. El batch es **idempotente**: si el índice ya tiene datos, no se vuelve a ejecutar.
4. Un **backend REST** expone los personajes desde Elasticsearch.
5. Un **frontend simple en JavaScript** consume el backend y muestra la lista de personajes.

---

## 🏗️ Arquitectura


---

## ⚙️ Tecnologías utilizadas

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data Elasticsearch
- Maven

### Batch / Integración
- Batch Processing
- Consumo de API REST externa
- Manejo de paginación
- Idempotencia de procesos

### Persistencia / Búsqueda
- Elasticsearch 7.17
- Indexación de documentos

### Frontend
- HTML5
- JavaScript (Vanilla JS)
- Fetch API

### Infraestructura
- Docker
- WSL 2
- Docker Desktop

---

## ▶️ Cómo ejecutar el proyecto

### 1️⃣ Levantar Elasticsearch con Docker

```bash
docker run -d \
  --name elastic-rick \
  -p 9200:9200 \
  -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  elasticsearch:7.17.15



