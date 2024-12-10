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


## 🏋️‍♂️ Planes de Entrenamiento
Lógica: Crear, actualizar, leer y eliminar planes asignados entre clientes y entrenadores.

* 1️⃣ Crear un Plan de Entrenamiento
  * POST /planes-entrenamiento
  * Descripción: Crea un nuevo plan de entrenamiento.
  * Parámetros:json{
  "id_entrenador": 1,
  "id_cliente": 2,
  "nombre": "Plan de Fuerza",
  "descripcion": "Plan para mejorar fuerza.",
  "fecha_inicio": "2023-12-10",
  "fecha_final": "2024-06-10"
    }
  * Respuesta: Código 201 Created.
  * Excepciones: 400 Bad Request: Si alguno de los campos de la solicitud no es válido. 404 Not Found: Si el ID del entrenador o cliente no existe. 500 Internal Server Error: Error interno con la base de datos.
    
* 2️⃣ Obtener todos los Planes de Entrenamiento
  * GET /planes-entrenamiento
  * Descripción: Lista todos los planes de entrenamiento existentes.
  * Respuesta: Código 200 OK.
  * Excepciones: 500 Internal Server Error: Para errores en la base de datos.

* 3️⃣ Obtener Plan por ID
  * GET /planes-entrenamiento/{id}
  * Descripción: Recupera información de un plan específico por su ID.
  * Respuesta: Código 200 OK.
  * Excepciones: 404 Not Found: Si el plan con ese ID no existe. 500 Internal Server Error: Para errores en la base de datos.

* 4️⃣ Actualizar Plan de Entrenamiento
  * PUT /planes-entrenamiento/{id}
  * Descripción: Actualiza los detalles de un plan existente.
  * Respuesta: Código 200 OK.
  * Excepciones: 400 Bad Request: Si los campos enviados en la solicitud son inválidos. 404 Not Found: Si el plan no existe. 500 Internal Server Error: Error interno con la base de datos.

* 5️⃣ Eliminar Plan de Entrenamiento
  * DELETE /planes-entrenamiento/{id}
  * Descripción: Elimina un plan de entrenamiento.
  * Respuesta: Código 204 No Content.
  * Excepciones: 404 Not Found: Si el plan no existe. 500 Internal Server Error: Error interno con la base de datos.

## 🏃‍♀️ Sesiones de Entrenamiento
Lógica: Gestionar sesiones de entrenamiento relacionadas con un plan de entrenamiento.

* 1️⃣ Crear una Sesión de Entrenamiento
  * POST /sesiones-entrenamiento
  * Descripción: Crea una nueva sesión asociada a un plan de entrenamiento.
  * Parámetros: json {
     "id_planEntrenamiento": 1,
     "fecha": "2023-12-10",
     "duracion": 60,
     "descripcion": "Sesión de ejercicios para fuerza."
   }
  * Respuesta: Código 201 Created.
  * Excepciones: 400 Bad Request: Si los datos proporcionados no son válidos. 404 Not Found: Si el ID del plan de entrenamiento no existe. 500 Internal Server Error: Para errores en la base de datos.

* 2️⃣ Obtener todas las Sesiones
   * GET /sesiones-entrenamiento
   * Descripción: Lista todas las sesiones existentes.
   * Respuesta: Código 200 OK.
   * Excepciones: 500 Internal Server Error: Error interno con la base de datos.

* 3️⃣ Obtener una Sesión Específica por ID
  * GET /sesiones-entrenamiento/{id}
  * Descripción: Recupera información de una sesión específica.
  * Respuesta: Código 200 OK.
  * Excepciones: 404 Not Found: Si la sesión no existe. 500 Internal Server Error: Para errores en la base de datos.

* 4️⃣ Actualizar una Sesión
  * PUT /sesiones-entrenamiento/{id}
  * Descripción: Actualiza una sesión existente.
  * Respuesta: Código 200 OK.
  * Excepciones: 400 Bad Request: Datos inválidos en la solicitud. 404 Not Found: Si la sesión no existe. 500 Internal Server Error: Para errores en la base de datos.

* 5️⃣ Eliminar una Sesión
  * DELETE /sesiones-entrenamiento/{id}
  * Descripción: Elimina una sesión de entrenamiento.
  * Respuesta: Código 204 No Content.
  * Excepciones: 404 Not Found: Si la sesión no existe. 500 Internal Server Error: Para errores en la base de datos.

## 📊 Progresos
Lógica: Gestionar y registrar el progreso de los clientes en sus sesiones de entrenamiento.

* 1️⃣ Crear Progreso
  * POST /progresos
  * Descripción: Registra un nuevo progreso para un cliente en una sesión de entrenamiento.
  * Parámetros: json{
     "id_sesion": 1,
     "id_cliente": 2,
     "peso_levantado": 50,
     "repeticiones": 10,
     "comentarios": "Buen rendimiento en el ejercicio."
   }
  * Respuesta: Código 201 Created: Progreso creado exitosamente.
  * Excepciones posibles: 400 Bad Request: Datos inválidos en el cuerpo de la solicitud. 404 Not Found: ID de sesión o cliente no existente.

* 2️⃣ Obtener Todos los Progresos
  * GET /progresos
  * Descripción: Recupera todos los registros de progreso de los clientes.
  * Respuesta: Código 200 OK: Lista de progresos devuelta con éxito.
  * Excepciones posibles: 500 Internal Server Error: Error en la consulta a la base de datos.

* 3️⃣ Obtener Progreso Específico
  * GET /progresos/{id}
  * Descripción: Recupera la información de un progreso específico por su ID.
  * Respuesta: Código 200 OK: Progreso devuelto con éxito.
  * Excepciones posibles: 404 Not Found: El progreso con el ID solicitado no existe. 500 Internal Server Error: Error interno en el servidor.

* 4️⃣ Actualizar Progreso
  *  PUT /progresos/{id}
  *  Descripción: Actualiza los datos de un registro de progreso existente.
  *  Parámetros: json
    {
      "peso_levantado": 55,
      "repeticiones": 12,
      "comentarios": "Incremento en el rendimiento"
    }
  * Respuesta: Código 200 OK: Progreso actualizado con éxito.
  * Excepciones posibles: 400 Bad Request: Datos inválidos en el cuerpo de la solicitud. 404 Not Found: El progreso con el ID solicitado no existe. 500 Internal Server Error: Error en la base de datos.

* 5️⃣ Eliminar Progreso
  * DELETE /progresos/{id}
  * Descripción: Elimina un registro de progreso por su ID.
  * Respuesta: Código 204 No Content: Progreso eliminado con éxito.
  * Excepciones posibles: 404 Not Found: El progreso con el ID solicitado no existe. 500 Internal Server Error: Error interno en la base de datos.
 
## ⚙️ Lógica de Negocio
La lógica de negocio de la aplicación FitTrack se centra en lo siguiente:
1. Gestión de Entrenadores y Clientes: Crear, listar, actualizar y eliminar usuarios.
2. Asignación de Planes: Los entrenadores podrán asignar planes a clientes.
3. Gestión de Sesiones: Las sesiones de entrenamiento estarán vinculadas a planes específicos para un seguimiento efectivo.
4. Seguimiento de Progresos: Crear y almacenar métricas de progreso de clientes en relación a sus sesiones de entrenamiento.

## 🛑 Excepciones y Códigos de Respuesta
Se implementarán las siguientes excepciones:
1. 404 Not Found:
   Si un recurso no existe en la base de datos.
2. 400 Bad Request:
   Si la solicitud está mal formada.
3. 401 Unauthorized:
   Si el usuario no tiene permisos para realizar la operación.
4. 500 Internal Server Error:
   Para errores internos del servidor.

## 🔒 Restricciones de Seguridad
Se implementarán las siguientes medidas de seguridad:
1. Autenticación y Autorización con JWT:
   Se protegerán los endpoints con tokens JWT.
2. Validación de Entradas:
   Se validarán los campos en las solicitudes para evitar errores y ataques de inyección.
3. CORS Configuration:
   Se configurará correctamente la política de CORS para limitar el acceso a solicitudes no permitidas.
