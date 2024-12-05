# FitTrack
Este proyecto es una aplicación de backend desarrollada en Spring Boot, diseñada para gestionar planes de entrenamiento personalizados. Está dirigida a entrenadores personales y clientes que buscan organizar y realizar un seguimiento de sus sesiones de entrenamiento de manera eficiente.  

### Características principales 
* Gestión de usuarios: Registro de entrenadores y clientes.
* Creación de planes de entrenamiento: Los entrenadores pueden diseñar y asignar planes personalizados a los clientes.
* Programación de sesiones: Gestión de sesiones específicas dentro de cada plan de entrenamiento.
* Seguimiento del progreso: Registro de métricas como peso usado, repeticiones, calorías quemadas, y observaciones de cada sesión.

### Tecnologías utilizadas 
* Lenguaje: Java 17+
* Framework: Spring Boot (Spring Data JPA, Spring Web, Spring Security)
* Base de datos: MySQL (o cualquier base de datos compatible con JPA)

### Estructura de las tablas 
* Usuarios
  * Almacena información de los entrenadores y clientes.

* Planes de Entrenamiento
  * Contiene los planes diseñados por los entrenadores para sus clientes.

* Sesiones de Entrenamiento
  * Registra las sesiones programadas o realizadas dentro de los planes.

* Progresos
  * Lleva un historial detallado del rendimiento del cliente en sus entrenamientos.
