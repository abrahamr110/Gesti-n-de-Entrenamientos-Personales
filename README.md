# 💪🏻 FitTrack 💪🏻
### 💡 Idea del proyecto
La idea del proyecto FitTrack es crear una plataforma de gestión de entrenamientos personalizados, diseñada para entrenadores y clientes. La aplicación permitirá a los entrenadores diseñar y asignar planes de entrenamiento adaptados a las necesidades de sus clientes, programar sesiones de ejercicio específicas y realizar un seguimiento detallado del progreso de cada cliente a lo largo del tiempo.

Los clientes, por su parte, podrán acceder a sus planes, registrar sus resultados de entrenamiento y recibir retroalimentación de sus entrenadores. El objetivo es proporcionar una herramienta digital eficiente que facilite la organización de los entrenamientos, mejore el monitoreo del progreso y fomente una experiencia más personalizada y motivadora para los usuarios.

Con FitTrack, los entrenadores podrán optimizar su tiempo y ofrecer un servicio más efectivo y personalizado, mientras que los clientes tendrán un mayor control sobre su desarrollo físico y su rendimiento.

### 📰 Características principales
* Gestión de usuarios: Registro de entrenadores y clientes.
* Creación de planes de entrenamiento: Los entrenadores pueden diseñar y asignar planes personalizados a los clientes.
* Programación de sesiones: Gestión de sesiones específicas dentro de cada plan de entrenamiento.
* Seguimiento del progreso: Registro de métricas como peso usado, repeticiones, calorías quemadas, y observaciones de cada sesión.

### 📃 Tecnologías utilizadas 
* Lenguaje: Java 17+
* Framework: Spring Boot (Spring Data JPA, Spring Web, Spring Security)
* Base de datos: MySQL (o cualquier base de datos compatible con JPA)

### 📝 Estructura de las tablas 
* Usuarios
  * La tabla Usuarios es fundamental para el sistema, ya que almacena los datos personales y de acceso de las personas que interactúan con la aplicación. En ella se diferencian dos tipos principales de usuarios: entrenadores y clientes. Los entrenadores son responsables de diseñar y asignar planes de entrenamiento personalizados, mientras que los clientes son quienes los ejecutan. La tabla también permite gestionar la seguridad de los datos mediante contraseñas cifradas y facilita la organización de los usuarios por roles. Adicionalmente, almacena información de registro, como la fecha de creación de cada usuario.

* Planes de Entrenamiento
  * La tabla Planes_Entrenamiento sirve como un contenedor para los programas personalizados diseñados por los entrenadores. Cada plan incluye detalles como los objetivos del cliente, las actividades planeadas, y la duración estimada del programa. Este recurso es clave para estructurar las actividades de los clientes, permitiendo tanto a entrenadores como a clientes llevar un seguimiento claro del proceso de entrenamiento. Además, la relación entre los planes y los usuarios permite asignar entrenadores y clientes a cada plan de manera organizada.

* Sesiones de Entrenamiento
  * La tabla Sesiones_Entrenamiento desglosa los planes en actividades más manejables. Cada sesión corresponde a una instancia específica de entrenamiento dentro de un plan. Aquí se registran detalles como la fecha programada, la duración y los ejercicios planificados. Esto permite a los entrenadores personalizar el entrenamiento de cada cliente día a día y facilita que los clientes conozcan exactamente qué actividades deben realizar en cada sesión. Además, esta tabla establece una relación directa con los planes de entrenamiento, garantizando que cada sesión esté vinculada a un objetivo más amplio.

* Progresos
  * La tabla Progresos es clave para realizar un seguimiento detallado del rendimiento de los clientes durante sus entrenamientos. En ella se registran métricas esenciales como el peso levantado, las repeticiones realizadas, las calorías quemadas y observaciones adicionales del entrenador o cliente. Este historial detallado permite a entrenadores y clientes evaluar los resultados a lo largo del tiempo, identificar áreas de mejora, y ajustar los planes de entrenamiento en función de los avances o necesidades específicas. Su relación con las sesiones garantiza que cada registro esté vinculado a una actividad específica.

### ✍🏻 Justificación del proyecto 
El proyecto FitTrack nace para cubrir la necesidad de una herramienta digital que facilite la gestión de entrenamientos personalizados. Entrenadores y clientes enfrentan dificultades al usar métodos manuales o herramientas dispersas para planificar el progreso físico. FitTrack ofrece una solución integral que permite organizar planes, programar sesiones y realizar un seguimiento detallado del rendimiento. Con su enfoque práctico, la aplicación mejora la interacción entre entrenadores y clientes, optimizando la experiencia y promoviendo el bienestar físico.

### 🔗  Endpoints
A continuación, se describe la lista de endpoints a implementar en la aplicación FitTrack, organizados por la funcionalidad de las entidades:

## 📊 Usuarios
Lógica: Gestionar usuarios de la plataforma (entrenadores y clientes).

* 1️⃣ Crear Usuario
  * POST /usuarios
   * Descripción: Crea un nuevo usuario (entrenador o cliente).
    * Parámetros:
json
{
  "nombre": "John Doe",
  "correo": "john.doe@mail.com",
  "contraseña": "secure123",
  "tipo_usuario": "entrenador"
}
  * Respuesta: Código 201 Created
  * Excepciones: 400 Bad Request: Si los campos requeridos están vacíos o mal formados. 409 Conflict: Si el correo ya existe en la base de datos. 500 Internal Server Error: Para errores en la base de datos.

* 2️⃣ Obtener todos los Usuarios
  * GET /usuarios
  * Descripción: Recupera una lista de todos los usuarios.
  * Parámetros Opcionales: tipo_usuario.
  * Respuesta: Código 200 OK.
  * Excepciones : 500 Internal Server Error: Error interno del servidor si algo sale mal con la consulta a la base de datos.

* 3️⃣ Obtener un Usuario Específico por ID
  * GET /usuarios/{id}
  * Descripción: Obtiene la información de un usuario por su ID.
  * Respuesta: Código 200 OK.
  * Excepciones: 404 Not Found: Si el usuario con ese ID no existe en la base de datos. 500 Internal Server Error: Para errores en la base de datos.

* 4️⃣ Actualizar Usuario
  * PUT /usuarios/{id}
  * Descripción: Actualiza la información de un usuario existente.
  * Parámetros: nombre, correo, contraseña, tipo_usuario.
  * Respuesta: Código 200 OK.
  * Excepciones: 400 Bad Request: Si los campos enviados en la solicitud son inválidos. 404 Not Found: Si el usuario con ese ID no existe. 500 Internal Server Error: Para errores en la base de datos.

* 5️⃣ Eliminar Usuario
  * DELETE /usuarios/{id}
  * Descripción: Elimina un usuario por su ID.
  * Respuesta: Código 204 No Content.
  * Excepciones: 404 Not Found: Si el usuario con ese ID no existe. 500 Internal Server Error: Para errores en la base de datos.
