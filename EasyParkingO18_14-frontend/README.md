
# Mision TIC  2022 - Base proyecto ciclo 3

![UIS](logo.png)

# Componenentes
1. **Backend**: [Repositorio del backend](https://gitlab.com/tutor11/misionticproyectobaseciclo3) 
2. **Frontend**: Este repositorio

### Mundo del problema

Los tripulantes del proyecto Misión TIC 2022 se encuentran en el proceso de aprendizaje sobre el desarrollo de software, en este proceso los tripulantes utilizaran Jira, Gitlab y Spring Boot como medios para adquirir los conocimientos del ciclo 3. El área de tutores plantea la necesidad de desarrollar un prototipo del proyecto a realizar por los tripulantes con el fin de que estos puedan visualizar los procesos de desarrollo de software y tengan un ejemplo al momento de implementar sus propios proyectos para el ciclo 3

### Objetivo general

Desarrollar una aplicación web para la demostración de un prototipo funcional a los tripulantes de Misión TIC 2022 mediante la arquitectura cliente-servidor y el marco de trabajo Scrum

### Objectivos espesificos
1. Diseñar el plan de gestión del proyecto mediante Jira con el fin de gestionar las tares necesarias para el desarollo del proyecto
2. Implementar el software mediante el marco de trabajo Spring Boot con el fin de desplegar un prototipo funcional 

### Requerimientos funcionales

---

<table>
  <tr>
    <th>Nombre</th>
    <td>Creación de usuario</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir al usuario registrarse usando nombre de usuario y contraseña.
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia poder crear una usando mediante un usuario y contraseña</li>
        </ul>
    </td>
  </tr>
</table>

---

<table>
  <tr>
    <th>Nombre</th>
    <td>Autenticación y autorización</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir iniciar sesion a un usuario mediante nombre de usuario y contraseña, cuando el sistema haya probado la indetidad del usuario este autorizara el uso y consumo de los recursos del sistema.
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia poder iniciar sesion mediante un usuario y contraseña</li>
        </ul>
    </td>
  </tr>
</table>

----

<table>
  <tr>
    <th>Nombre</th>
    <td>Creación de productos</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir al usuario la creación de productos mediante nombre y precio del mismo
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia poder crear un producto</li>
        </ul>
    </td>
  </tr>
</table>

----

<table>
  <tr>
    <th>Nombre</th>
    <td>Consulta de productos</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir al usuario la consulta de <strong>sus</strong> productos
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia consultar los productos que he registrado</li>
        </ul>
    </td>
  </tr>
</table>

----

<table>
  <tr>
    <th>Nombre</th>
    <td>Actualización de productos</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir al usuario actualizar la información de sus productos
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia poder actualizar un producto existente</li>
        </ul>
    </td>
  </tr>
</table>

----

<table>
  <tr>
    <th>Nombre</th>
    <td>Eliminación de productos</td>
  </tr>
  <tr>
    <th>Prioridad</th>
    <td>Alta</td>
  </tr>
  <tr>
    <th>Descripción</th>
    <td>
        <p>
    El sistema debe permitir al usuario eliminar sus productos
    </p>
    </td>
  </tr>
  <tr>
    <th>Historias de usuario</th>
    <td>
        <ul>
        <li>Yo como usuario deberia poder eliminar productos</li>
        </ul>
    </td>
  </tr>
</table>

----

### Requerimientos no funcionales

1. Los estilos de las interfacez deben estar basadas en Boostrap 5
2. Debe ser reconocible los logos del proyecto Misión TIC 2022
3. Las contraseña almacenadas deben estar cifradas
### Modelo de datos planteado

![Base de datos](modelo.png)

### Gestión del marco de trabajo Scrum en Jira

##### Epicas

![Epicas](epics.png)

##### Sprints

![Sprints](sprints.png)

##### Historias de usuario

![Historias de usuario sprints 1 y 2](story1.png)

![Historias de usuario sprints 3 y 4](story2.png)

### Demo
Prueba la [Demo](https://misionticproyectobaseciclo3-frontend-ingdeiver.vercel.app/login.html).

![Demo](demo.png)

