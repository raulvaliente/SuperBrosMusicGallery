SuperBrosMusicGallery — Proyecto FP Dual NTT Data

Aplicación web para la gestión de tiendas de música y su catálogo de CDs.

Desarrollada con **Angular 21** en el frontend y **Spring Boot** en el backend, con base de datos H2 en memoria.

---

## Requisitos previos

Asegúrate de tener instalado lo siguiente antes de ejecutar el proyecto:

| Herramienta | Versión mínima | Comprobación |
|---|---|---|
| Java | 21 | `java -version` |
| Maven | 3.x | `mvn -version` |
| Node.js | 18 | `node --version` |
| Angular CLI | 21 | `ng version` |

Si no tienes Angular CLI instalado:

```bash
npm install -g @angular/cli
```

---

## Estructura del proyecto

```
SuperBrosMusicGallery/
├── backend/        ← Spring Boot (API REST + H2)
├── frontend/       ← Angular 21
└── README.md
```

---

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/raulvaliente/SuperBrosMusicGallery.git
cd SuperBrosMusicGallery
```

### 2. Arrancar el backend

```bash
cd backend
./mvnw spring-boot:run
```

> En Windows usa `mvnw.cmd spring-boot:run` si `./mvnw` no funciona.

El backend estará disponible en `http://localhost:8080`.

Los datos de ejemplo se cargan automáticamente al arrancar.

### 3. Arrancar el frontend

Abre una **nueva terminal** (sin cerrar la del backend):

```bash
cd frontend
npm install
ng serve
```

La aplicación estará disponible en `http://localhost:4200`.

---

## Base de datos

Se utiliza **H2 en memoria**. Los datos se cargan automáticamente desde `backend/src/main/resources/data.sql` al arrancar.

Para acceder a la consola de H2:

1. Con el backend corriendo, abre `http://localhost:8080/h2-console`
2. Introduce los siguientes datos de conexión:
   - **JDBC URL:** `jdbc:h2:mem:musicstoredb`
   - **User Name:** `sa`
   - **Password:** (déjalo vacío)
3. Haz clic en **Connect**

> Los datos se pierden al parar el backend. Al volver a arrancar se cargan de nuevo automáticamente.

---

## Endpoints de la API

Con el backend corriendo puedes probar los endpoints directamente en el navegador:

### Tiendas

| Método | URL | Descripción |
|---|---|---|
| GET | `/api/tiendas` | Lista todas las tiendas |
| GET | `/api/tiendas/{id}` | Detalle de una tienda |
| GET | `/api/tiendas/{id}/cds` | CDs de una tienda |
| POST | `/api/tiendas` | Crear nueva tienda |

### CDs

| Método | URL | Descripción |
|---|---|---|
| GET | `/api/cds` | Lista todos los CDs |
| GET | `/api/cds/{id}` | Detalle de un CD |
| POST | `/api/cds` | Crear nuevo CD |

---

## Tecnologías utilizadas

**Backend**
- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- H2 Database
- Lombok
- Maven

**Frontend**
- Angular 21
- Componentes Standalone
- Signals
- Formularios Reactivos
- Observables / HttpClient
- Lazy Loading

---

## Problemas encontrados durante el desarrollo

- Las instrucciones iniciales generadas usaban el tema "Biblioteca" (Autor/Libro) en lugar del tema real del proyecto (Tienda/CD). Fue necesario adaptar todos los packages, nombres de clases y archivos SQL.
- El package generado por Spring Initializr quedó como `com.musicgallery.musicgallery` al coincidir Group y Artifact, lo que generó confusión inicial. Se mantuvo así para no perder tiempo.
- Spring Boot intenta cargar el `data.sql` antes de que Hibernate cree las tablas. Se solucionó añadiendo `defer-datasource-initialization: true` en el `application.yml`.
- La dependencia "Rest Repositories" expone automáticamente los repositorios sin controladores, interfiriendo con la API propia. Se eliminó del proyecto.

---

## Autores

Proyecto desarrollado para el reto Final de FP Dual en NTT Data.
