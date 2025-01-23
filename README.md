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
+ Se asume que los trámites son fijos, por tanto, serán seleccionables a través de un dropdown.
+ Se asume que al registrar un turno, el **estado inicial** sea **En espera**. Posteriormente el usuario podrá modificar este esatdo a **Ya atendido**.
+ Se asume que el formato de fecha para los turnos es YYYY-MM-DD (año-mes-día).
+ Se asume que los datos mínimos que debe tener un tipo de trámite son: **identificador** y **nombre**.
+ Se asume que los datos en los estados de los turnos, únicamente pueden ser: **En espera** y **Ya atendido**.
+ Se asume que habrá un límite de turnos por día, por tanto, se definirá un máximo de 10 turnos diarios.
+ Se asume que la descripción del trámite a realizar que se solicita en los datos para el registro del turno, puede omitirse para integrarlo dentro de los registros de una clase llamada TipoTurno y tomarla en este diseño como el nombre del trámite, para evitar redundancias.

### Diagrama UML
En base al análisis realizado, a continuación se muestra el diagrama UML que representa las clases y relaciones de este proyecto:

![DiagramaTurnero](https://github.com/user-attachments/assets/bd986ce6-23ac-4ea1-a6e4-f4e369846639)



