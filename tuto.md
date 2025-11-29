# ✈️ AeroGraph - Flight Route Optimizer

**AeroGraph** es un motor de búsqueda de rutas aéreas optimizadas de alto rendimiento. Utiliza una arquitectura orientada a grafos para calcular conexiones y una capa de caché distribuida para minimizar la latencia en búsquedas frecuentes.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green)
![Neo4j](https://img.shields.io/badge/Database-Neo4j-blue)
![Redis](https://img.shields.io/badge/Cache-Redis-red)
![Docker](https://img.shields.io/badge/Deployment-Docker-blue)

## 🚀 Características Principales

* **Algoritmo de Grafos:** Cálculo de rutas óptimas (Shortest Path) utilizando Neo4j.
* **Alto Rendimiento:** Implementación de caché con Redis para respuestas en milisegundos.
* **Persistencia Políglota:** Uso de bases de datos NoSQL específicas para cada caso de uso (Grafos + Key-Value).
* **Arquitectura Dockerizada:** Despliegue completo (App + BD + Caché) con un solo comando.
* **Frontend Integrado:** Interfaz web ligera para visualización de rutas.

## 🛠️ Stack Tecnológico

| Componente | Tecnología | Uso |
| :--- | :--- | :--- |
| **Backend** | Java 17 + Spring Boot 3 | API REST y Lógica de Negocio |
| **Base de Datos** | Neo4j | Modelado de Aeropuertos y Rutas (Grafos) |
| **Caché** | Redis | Almacenamiento temporal de búsquedas (Serialization) |
| **Infraestructura** | Docker Compose | Orquestación de contenedores |
| **Frontend** | HTML5 + JS (Fetch API) | Interfaz de usuario |

## ⚙️ Instalación y Ejecución

Prerrequisitos: Tener **Docker** instalado.

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/TU_USUARIO/aerograph.git](https://github.com/TU_USUARIO/aerograph.git)
    cd aerograph
    ```

2.  **Iniciar la aplicación:**
    ```bash
    docker-compose up
    ```
    *La aplicación estará disponible en: `http://localhost:8080/index.html`*

## 📡 Documentación de la API

### 1. Crear un Aeropuerto (Nodo)
`POST /api/vuelos/aeropuerto`
```json
{
  "iata": "MAD",
  "nombre": "Madrid Barajas"
}