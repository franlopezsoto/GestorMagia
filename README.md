# GestorMagia

Este proyecto es una aplicación de gestión de hechizos y magia, construida con **Spring Boot**, **JPA**, y **AspectJ**. La aplicación permite gestionar entidades de tipo `Hechizo`, con funcionalidades CRUD básicas (crear, leer, actualizar y eliminar), además de incluir aspectos transversales (logging y manejo de excepciones) y patrones de diseño para mejorar la modularidad y escalabilidad del código.

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas que incorpora **AspectJ** y patrones de diseño:

- **Aspectos (AspectJ)**: Aspectos transversales definidos en clases que manejan logging y manejo de excepciones. Se configuran con `@Aspect` para interceptar llamadas a métodos en los servicios y repositorios.
- **Patrones de Diseño**:
    - **Singleton**: Utilizado en los servicios para garantizar una única instancia en toda la aplicación.
    - **Factory**: Para la posible extensión a otros tipos de entidades mágicas.
    - **Proxy**: Implementado mediante AspectJ para añadir validaciones y logging sin modificar el código de las clases.
    - **Controladores**: Gestionan las solicitudes HTTP y responden al cliente.
    - **Servicios**: Contienen la lógica de negocio y se benefician de los aspectos transversales y de los patrones de diseño.
    - **Repositorio**: Define la capa de persistencia y opera con JPA.
    - **Modelo**: Contiene las entidades `Hechizo`, mapeadas a tablas de base de datos mediante anotaciones de JPA.

## Desarrollo del Programa

1. **Modelo de Datos**:
    - La clase `Hechizo` representa la entidad principal del programa. Esta clase está anotada con `@Entity` para mapearse a una tabla en la base de datos, y cuenta con los campos `id`, `nombre`, `descripcion`, y `nivelDeEnergia`.
    - Se usa el **Patrón Singleton** en la instancia del servicio y repositorio para optimizar recursos y asegurar consistencia en la manipulación de datos.

2. **Repositorio**:
    - `HechizoRepository` extiende `JpaRepository`, permitiendo realizar operaciones CRUD sin necesidad de implementar los métodos. Además, con **AspectJ** se implementan aspectos de manejo de excepciones en este nivel.

3. **Servicio**:
    - La clase `HechizoService` utiliza el **Patrón Proxy** implementado con AspectJ para añadir validaciones y logging de manera centralizada, permitiendo un código más limpio.
    - Para futuras expansiones, se puede implementar el **Patrón Factory** en `HechizoService` para gestionar otros tipos de entidades mágicas.

4. **Aspectos (AspectJ)**:
    - Se define un aspecto de logging (`LoggingAspect`) que registra las operaciones realizadas en el servicio, detallando qué métodos se invocan y sus parámetros.
    - Un aspecto de manejo de excepciones (`ExceptionAspect`) intercepta excepciones no controladas, las registra, y puede personalizar la respuesta.
    - Un aspecto de validación (`ValidationAspect`) verifica los datos de entrada para asegurar que cumplen con los criterios esperados antes de ejecutar la lógica de negocio.

## Complejidades del Proyecto

### 1. Gestión de Aspectos Transversales
   - **AspectJ** permite que funcionalidades como logging y manejo de excepciones se apliquen sin necesidad de modificar el código de cada clase, pero requiere una configuración cuidadosa para evitar interferencias en el flujo normal de la aplicación.
   - La aplicación debe monitorear las dependencias entre aspectos, y el orden de ejecución puede afectar el rendimiento si no se gestiona adecuadamente.

### 2. Integración de Patrones de Diseño
   - Los patrones de diseño facilitan la expansión y la mantenibilidad del proyecto. Implementar Proxy y Factory en particular ofrece flexibilidad y facilita agregar nuevas funcionalidades sin alterar el código existente.
   - La complejidad del uso de estos patrones radica en asegurar que el código permanece modular y que los patrones no introducen redundancias.

### 3. Pruebas de Aspectos y Funcionalidad
   - Probar aspectos con AspectJ puede ser complejo. Se recomienda realizar pruebas de integración que validen el correcto funcionamiento de los aspectos transversales en conjunto con la lógica de negocio.

## Instalación y Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/franlopezsoto/GestorMagia.git
