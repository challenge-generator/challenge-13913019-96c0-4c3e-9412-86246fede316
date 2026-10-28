# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un servicio de gestión de inventario**.

| | |
|---|---|
| Tema | Experiencia en Frameworks |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 2 semanas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa 3.5.6
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-actuator n/a
- org.springframework.boot:spring-boot-starter-logging n/a
- com.h2database:h2 2.2.224
- org.postgresql:postgresql 42.7.3
- org.projectlombok:lombok 1.18.32
- org.springframework.boot:spring-boot-starter-test n/a
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.6.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del entorno y enrutamiento de solicitudes**: Entorno de desarrollo configurado y enrutamiento básico de solicitudes establecido.
- **Fase 2 — Manejo de variables de entorno y generación de registros de rastros**: Servicio con manejo de variables de entorno y generación de registros de rastros implementado.
- **Fase 3 — Conexión con base de datos y operaciones CRUD**: Servicio conectado con base de datos y operaciones CRUD implementadas utilizando un ORM.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (76)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/inventory/application/ProductService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inventory/infrastructure/GlobalExceptionHandler.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setStockQuantity`
      Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setCategory`
      Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setCreatedAt`
      Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.getId`
      Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `Product.getStockQuantity`
      Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setStockQuantity`
      Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setCategory`
      Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setCreatedAt`
      Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getId`
      Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getName`
      Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getDescription`
      Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getPrice`
      Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getStockQuantity`
      Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getCategory`
      Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getCreatedAt`
      Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getUpdatedAt`
      Se invoca `getUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.name`
      Se invoca `name` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.description`
      Se invoca `description` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.price`
      Se invoca `price` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.stockQuantity`
      Se invoca `stockQuantity` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.category`
      Se invoca `category` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getId`
      Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.quantityChange`
      Se invoca `quantityChange` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getName`
      Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getDescription`
      Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getPrice`
      Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getStockQuantity`
      Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getCategory`
      Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getCreatedAt`
      Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getUpdatedAt`
      Se invoca `getUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setStockQuantity`
      Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setCategory`
      Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setCreatedAt`
      Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getName`
      Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getCategory`
      Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.isPresent`
      Se invoca `isPresent` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.get`
      Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.isEmpty`
      Se invoca `isEmpty` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.size`
      Se invoca `size` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getPrice`
      Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.findByCategory`
      Se invoca `findByCategory` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.stream`
      Se invoca `stream` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.findLowStockProducts`
      Se invoca `findLowStockProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.updateStockQuantity`
      Se invoca `updateStockQuantity` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getStockQuantity`
      Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setStockQuantity`
      Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setCategory`
      Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setCreatedAt`
      Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.getCreatedAt`
      Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `ProductService.findByCategory`
      Se invoca `findByCategory` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `ProductService.findLowStockProducts`
      Se invoca `findLowStockProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (11)

- `pom.xml`
- `src/main/java/com/inventory/application/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/inventory/domain/Product.java`
- `src/main/java/com/inventory/domain/ProductRepository.java`
- `src/main/java/com/inventory/application/ProductService.java`
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java`
- `src/main/java/com/inventory/infrastructure/ProductController.java`
- `src/main/java/com/inventory/infrastructure/GlobalExceptionHandler.java`
- `src/test/java/com/inventory/application/ProductServiceTest.java`
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/inventory/application`
- `src/main/java/com/inventory/domain`
- `src/main/java/com/inventory/infrastructure`
- `src/main/resources`
- `src/test/java/com/inventory`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).
- Mision: Exponer un servicio de gestión de inventario que use las capacidades del marco de trabajo.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
