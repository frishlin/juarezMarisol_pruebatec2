# Gestión de Turnos/citas                           
HAB - Prueba técnica 2


### Descripción
Aplicación Web que permite agregar, listar y filtrar turnos o citas para una entidad gubernamental. Los turnos están asociados con ciudadanos, trámites y estado del turno (que puede ser "En espera" o "Ya atendido"), el cual posterioirmente puede ser modificado.

### Funcionalidades principales:
+ **Agregar un nuevo turno/cita**. Registra un turno solicitando número de turno, estado del turno, el ciudadano asignado al turno, el trámite que va a realizar y la fecha del turno.
+ **Listar Turnos**. Muestra, en forma de tabla, una lista de turnos registrados, que contiene la información del trámite, el estado del turno y el ciudadano asignado.
+ **Filtrar Turnos**. Permite filtrar los turnos según su estado. 

### Tecnologías utilizadas:
+ Backend: Java 8+ | Servkets | JPA (Eclipselink)
+ Frontend: JSP | Bootstrap
+ Apache Tomcat 9
+ Servlets
+ MySQL
+ Maven

### Análisis

**Reglas para agregar nuevos turnos:**
+ Cada turno pertenece a un Ciudadano
+ Un ciudadano puede tener varios turnos para diferentes fechas o incluso para el mismo día, pero con trámites diferentes.

**Restricciones para agregar nuevos turnos:**
+ El turno debe registrar: número del turno, fecha del turno, descripción del trámite y ciudadano asignado.
  
**Reglas para listar turnos:**
+ Los turnos deben visualizarse con su respectivo ciudadano asignado, según la fecha brindada por el usuario.
+ Se sugiere que la información se presente en forma de tabla para facilitar la visualización.

**Restricciones para listar turnos:**
+ EL usuario debe proporcionar una fecha para poder listar los turnos.

**Reglas para Filtrar turnos:**
+ El usuario debe poder filtrar los turnos según su estado.
  + "En espera": son los turnos que aun no han sido atendidos.
  + "Ya atendido": son los turnos que ya han sido atendidos.

**Lista de supuestos**
+ Se asume que para facilitar la navegación del usuario, se deba tener un selector en el fronted, para que el usuario pueda elegir el estado para filtrar, en este caso, lo hará a través de un dopdrown.
+ Además del número del turno y el ciudadano asignado, se asume que es necesario visualizar la fecha y la descripción del trámite.
+ Se asume que los datos mínimos requeridos que debe tener un ciudadano son: **nombre**, **apellido**, **teléfono** y algún **dato único** como pueden ser la **CURP**, para una identificación más confiable.
+ Se asume que los trámites y los ciudadanos son fijos, por tanto, serán seleccionables a través de un dropdown.
+ Se asume que al registrar un turno, el **estado inicial** sea **En espera**. Posteriormente el usuario podrá modificar este esatdo a **Ya atendido**.
+ Se asume que el formato de fecha para los turnos es YYYY-MM-DD (año-mes-día).
+ Se asume que los datos mínimos que debe tener un tipo de trámite son: **identificador** y **nombre**.
+ Se asume que los datos en los estados de los turnos, únicamente pueden ser: **En espera** y **Ya atendido**.
+ Se asume que habrá un límite de turnos por día, por tanto, se definirá un máximo de 10 turnos diarios.
+ Se asume que la descripción del trámite a realizar que se solicita en los datos para el registro del turno, puede omitirse para integrarlo dentro de los registros de una clase llamada TipoTurno y tomarla en este diseño como el nombre del trámite, para evitar redundancias.

### Diagrama UML
En base al análisis realizado, a continuación se muestra el diagrama UML que representa las clases y relaciones de este proyecto:

![DiagramaTurnero](https://github.com/user-attachments/assets/8a29b992-ee96-4a72-8694-afccb879d309)

### Diagrama Entidad-Relación
En base al análisis realizado, a continuación se muestra el diagrama E-R que representa la base de datos de este proyecto:



# Funcionamiento                          
En el proyecto se encuentra el archivo turnero.sql, correspondiente a la base de datos que cuenta con algunos datos para cargar.

Primero, se debe importar el archivo **turnero.sql** utilizando algún gestor de bases de datos, como phpMyAdmin. Es importante asegurarse de que los servicios de Apache y MySQL estén en funcionamiento antes de realizar la importación.

Una vez importado,el archivo y que los servicios de Apache y MySQL estén habilitados, se debe ejecutar el programa. El programafue desarrollado con el IDE Neatbeans en su versión 17, por lo cual se recomienda el uso de este entorno para evitar problemas de compatibilidad.

Se pueden crear, listar, eliminar y editar Ciudadanos, para hacer más grande la lista.

Para **Registrar un turno**, se debe hacer clic en el botón con este nombre, se deberá seleccionar una fecha, algún ciudadano de la lista y algún tipo de trámite, posteriormente se debe hacer clic en el botón **Registrar Turno** y la aplicación devolverá a la página principal.

Para **Listar turnos**, se  debe hacer clic en el botón con este nombre. Inicialmente se listan todos los registros pero se pueden filtrar de dos maneras:
+ Al elegir un **Estado de turno** y hacer clic en el botón **Filtrar turno**, se mostrarán únicamente los registros que cumplan con dicho estado.
+ Al elegir una **Fecha** y hacer clic en el botón **Filtrar turno**, se mostrarán los registros que coincidan con esa fecha, sin importar el estado del turno.

Al **Registrar un turno**, el sistema toma como predeterminado el estado **En espera**, posteriormente, al listar los turnos, y los estados **En espera** pueden ser cambiados a **Ya atendido** haciendo clic sobre el botón **Marcar como Atendido**.

*Cada día, únicamente se pueden reservar **10 turnos**, si se desea reservar más de 10 turnos para el mismo día, el sistema muestra un mensaje advirtiendo que se no se pueden agregar más turnos para ese día y se invita a elegir otra fecha.*

