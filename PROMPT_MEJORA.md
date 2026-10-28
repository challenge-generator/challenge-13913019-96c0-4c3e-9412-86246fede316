# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/inventory/application/ProductService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inventory/infrastructure/GlobalExceptionHandler.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setStockQuantity`: Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setCategory`: Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setCreatedAt`: Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.getId`: Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `Product.getStockQuantity`: Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setStockQuantity`: Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setCategory`: Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setCreatedAt`: Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getId`: Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getName`: Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getDescription`: Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getPrice`: Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getStockQuantity`: Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getCategory`: Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getCreatedAt`: Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java` — `Product.getUpdatedAt`: Se invoca `getUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.name`: Se invoca `name` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.description`: Se invoca `description` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.price`: Se invoca `price` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.stockQuantity`: Se invoca `stockQuantity` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.category`: Se invoca `category` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getId`: Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `StockUpdateRequest.quantityChange`: Se invoca `quantityChange` sobre `StockUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getName`: Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getDescription`: Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getPrice`: Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getStockQuantity`: Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getCategory`: Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getCreatedAt`: Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `Product.getUpdatedAt`: Se invoca `getUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setStockQuantity`: Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setCategory`: Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setCreatedAt`: Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getName`: Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getCategory`: Se invoca `getCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.isPresent`: Se invoca `isPresent` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.get`: Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.isEmpty`: Se invoca `isEmpty` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.size`: Se invoca `size` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getPrice`: Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.findByCategory`: Se invoca `findByCategory` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.stream`: Se invoca `stream` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.findLowStockProducts`: Se invoca `findLowStockProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `ProductService.updateStockQuantity`: Se invoca `updateStockQuantity` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/application/ProductServiceTest.java` — `Product.getStockQuantity`: Se invoca `getStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setStockQuantity`: Se invoca `setStockQuantity` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setCategory`: Se invoca `setCategory` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setCreatedAt`: Se invoca `setCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `Product.getCreatedAt`: Se invoca `getCreatedAt` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `ProductService.findByCategory`: Se invoca `findByCategory` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/infrastructure/ProductControllerTest.java` — `ProductService.findLowStockProducts`: Se invoca `findLowStockProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).

### Misión / candidato
Exponer un servicio de gestión de inventario que use las capacidades del marco de trabajo.

### Reto
- Tema: Experiencia en Frameworks
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un servicio de gestión de inventario
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del entorno y enrutamiento de solicitudes — objetivo: Configurar el entorno de desarrollo y establecer el enrutamiento básico de solicitudes para el servicio de gestión de inventario. — entregable (NO resolver): Entorno de desarrollo configurado y enrutamiento básico de solicitudes establecido.
- Fase 2: Manejo de variables de entorno y generación de registros de rastros — objetivo: Implementar el manejo de variables de entorno y la generación de registros de rastros en el servicio de gestión de inventario. — entregable (NO resolver): Servicio con manejo de variables de entorno y generación de registros de rastros implementado.
- Fase 3: Conexión con base de datos y operaciones CRUD — objetivo: Conectar el servicio con una base de datos y implementar las operaciones CRUD utilizando un Mapeador Relacional de Objetos (ORM). — entregable (NO resolver): Servicio conectado con base de datos y operaciones CRUD implementadas utilizando un ORM.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.inventory</groupId>
    <artifactId>inventory-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>inventory-service</name>
    <description>Servicio de gestión de inventario</description>

    <properties>
        <java.version>21</java.version>
        <springdoc-openapi-ui.version>2.6.0</springdoc-openapi-ui.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
            <version>2.2.224</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
            <version>42.7.3</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
            <version>1.18.32</version>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi-ui.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

//

// === ARCHIVO: src/main/java/com/inventory/application/Application.java ===
package com.inventory.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

//

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: inventory-service
  profiles:
    active: dev
  datasource:
    url: jdbc:h2:mem:inventorydb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true

server:
  port: 8080
  servlet:
    context-path: /api/inventory

logging:
  level:
    root: INFO
    com.inventory: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.web: DEBUG

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
    operationsSorter: method

// === ARCHIVO: src/main/java/com/inventory/domain/Product.java ===
package com.inventory.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * Entidad de dominio que representa un producto en el inventario.
 * Contiene los atributos esenciales de un producto y valida su estado.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private UUID id;

    @NotNull(message = "El nombre del producto no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull(message = "La descripción del producto no puede ser nula")
    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String description;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @Positive(message = "El precio debe ser un valor positivo")
    private BigDecimal price;

    @NotNull(message = "La cantidad en stock no puede ser nula")
    @Positive(message = "La cantidad en stock debe ser un valor positivo o cero")
    private Integer stockQuantity;

    @NotNull(message = "La categoría del producto no puede ser nula")
    @Size(min = 3, max = 50, message = "La categoría debe tener entre 3 y 50 caracteres")
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Actualiza la cantidad en stock del producto.
     * @param quantity Cantidad a agregar o restar del stock actual.
     * @throws IllegalArgumentException si la cantidad resultante es negativa.
     */
    public void updateStockQuantity(int quantity) {
        int newQuantity = this.stockQuantity + quantity;
        if (newQuantity < 0) {
            throw new IllegalArgumentException("No hay suficiente stock para realizar la operación");
        }
        this.stockQuantity = newQuantity;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Valida que el producto cumpla con todas las restricciones de negocio.
     * @throws IllegalStateException si alguna validación falla.
     */
    public void validate() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new IllegalStateException("El nombre del producto es obligatorio");
        }
        if (this.price == null || this.price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("El precio debe ser un valor positivo");
        }
        if (this.stockQuantity == null || this.stockQuantity < 0) {
            throw new IllegalStateException("La cantidad en stock no puede ser negativa");
        }
        if (this.category == null || this.category.trim().isEmpty()) {
            throw new IllegalStateException("La categoría del producto es obligatoria");
        }
    }
}

// === ARCHIVO: src/main/java/com/inventory/domain/ProductRepository.java ===
package com.inventory.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz del puerto para operaciones de persistencia del producto.
 * Define los contratos que la capa de infraestructura debe implementar
 * para interactuar con el almacenamiento de productos.
 */
public interface ProductRepository {
    /**
     * Guarda un producto en el repositorio.
     * @param product Producto a guardar.
     * @return Producto guardado con su ID generado.
     */
    Product save(Product product);

    /**
     * Busca un producto por su ID.
     * @param id ID del producto a buscar.
     * @return Optional con el producto si existe, vacío en caso contrario.
     */
    Optional<Product> findById(UUID id);

    /**
     * Busca todos los productos en el repositorio.
     * @return Lista de todos los productos.
     */
    List<Product> findAll();

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     */
    void deleteById(UUID id);

    /**
     * Busca productos por categoría.
     * @param category Categoría a buscar.
     * @return Lista de productos que pertenecen a la categoría.
     */
    List<Product> findByCategory(String category);

    /**
     * Busca productos con stock bajo.
     * @param threshold Umbral para considerar stock bajo.
     * @return Lista de productos con stock menor o igual al umbral.
     */
    List<Product> findLowStockProducts(int threshold);
}

// === ARCHIVO: src/main/java/com/inventory/application/ProductService.java ===
package com.inventory.application;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, BigDecimal price, 
                                  Integer stockQuantity, String category) {
        logger.info("Creando nuevo producto con nombre: {}", name);
        
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategory(category);
        product.setCreatedAt(java.time.LocalDateTime.now());
        product.setUpdatedAt(java.time.LocalDateTime.now());
        
        product.validate();
        Product savedProduct = productRepository.save(product);
        
        logger.info("Producto creado exitosamente con ID: {}", savedProduct.getId());
        return savedProduct;
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProductById(UUID id) {
        logger.debug("Buscando producto por ID: {}", id);
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        logger.debug("Obteniendo todos los productos");
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsByCategory(String category) {
        logger.debug("Buscando productos por categoría: {}", category);
        return productRepository.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Product> getLowStockProducts(int threshold) {
        logger.debug("Buscando productos con stock bajo, umbral: {}", threshold);
        return productRepository.findLowStockProducts(threshold);
    }

    public Product updateProduct(UUID id, String name, String description, 
                                  BigDecimal price, Integer stockQuantity, String category) {
        logger.info("Actualizando producto con ID: {}", id);
        
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Producto no encontrado para actualización: {}", id);
                return new ProductNotFoundException("Producto no encontrado con ID: " + id);
            });
        
        if (name != null && !name.isBlank()) {
            existingProduct.setName(name);
        }
        if (description != null) {
            existingProduct.setDescription(description);
        }
        if (price != null) {
            existingProduct.setPrice(price);
        }
        if (stockQuantity != null) {
            existingProduct.updateStockQuantity(stockQuantity);
        }
        if (category != null && !category.isBlank()) {
            existingProduct.setCategory(category);
        }
        
        existingProduct.setUpdatedAt(java.time.LocalDateTime.now());
        existingProduct.validate();
        
        Product updatedProduct = productRepository.save(existingProduct);
        logger.info("Producto actualizado exitosamente: {}", id);
        
        return updatedProduct;
    }

    public void deleteProduct(UUID id) {
        logger.info("Eliminando producto con ID: {}", id);
        
        if (!productRepository.findById(id).isPresent()) {
            logger.error("Producto no encontrado para eliminación: {}", id);
            throw new ProductNotFoundException("Producto no encontrado con ID: " + id);
        }
        
        productRepository.deleteById(id);
        logger.info("Producto eliminado exitosamente: {}", id);
    }

    public Product updateStock(UUID id, int quantityChange) {
        logger.info("Actualizando stock del producto ID: {}, cambio: {}", id, quantityChange);
        
        Product product = productRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Producto no encontrado para actualización de stock: {}", id);
                return new ProductNotFoundException("Producto no encontrado con ID: " + id);
            });
        
        int newQuantity = product.getStockQuantity() + quantityChange;
        if (newQuantity < 0) {
            logger.error("Stock no puede ser negativo para producto ID: {}", id);
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        product.updateStockQuantity(newQuantity);
        product.setUpdatedAt(java.time.LocalDateTime.now());
        
        Product updatedProduct = productRepository.save(product);
        logger.info("Stock actualizado para producto ID: {}, nuevo stock: {}", id, newQuantity);
        
        return updatedProduct;
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/com/inventory/infrastructure/ProductRepositoryAdapter.java ===
package com.inventory.infrastructure;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepositoryAdapter extends ProductRepository, JpaRepository<ProductEntity, UUID> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category")
    List<ProductEntity> findByCategory(@Param("category") String category);

    @Query("SELECT p FROM ProductEntity p WHERE p.stockQuantity < :threshold")
    List<ProductEntity> findLowStockProducts(int threshold);
}

@Entity
@Table(name = "products")
class ProductEntity {

    private static final Logger logger = LoggerFactory.getLogger(ProductEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setStockQuantity(entity.getStockQuantity());
        product.setCategory(entity.getCategory());
        product.setCreatedAt(entity.getCreatedAt());
        product.setUpdatedAt(entity.getUpdatedAt());
        return product;
    }

    public static ProductEntity fromDomain(Product product) {
        if (product == null) {
            return null;
        }
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setStockQuantity(product.getStockQuantity());
        entity.setCategory(product.getCategory());
        entity.setCreatedAt(product.getCreatedAt());
        entity.setUpdatedAt(product.getUpdatedAt());
        return entity;
    }
}

// === ARCHIVO: src/main/java/com/inventory/infrastructure/ProductController.java ===
package com.inventory.infrastructure;

import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        logger.info("Recibida petición para crear producto: {}", request.name());
        
        Product product = productService.createProduct(
            request.name(),
            request.description(),
            request.price(),
            request.stockQuantity(),
            request.category()
        );
        
        ProductResponse response = ProductResponse.fromDomain(product);
        logger.info("Producto creado exitosamente con ID: {}", product.getId());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        logger.debug("Recibida petición para obtener producto por ID: {}", id);
        
        return productService.getProductById(id)
            .map(product -> {
                ProductResponse response = ProductResponse.fromDomain(product);
                return ResponseEntity.ok(response);
            })
            .orElseGet(() -> {
                logger.warn("Producto no encontrado con ID: {}", id);
                return ResponseEntity.notFound().build();
            });
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        logger.debug("Recibida petición para obtener todos los productos");
        
        List<ProductResponse> products = productService.getAllProducts()
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String category) {
        logger.debug("Recibida petición para obtener productos por categoría: {}", category);
        
        List<ProductResponse> products = productService.getProductsByCategory(category)
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponse>> getLowStockProducts(
            @RequestParam(defaultValue = "10") int threshold) {
        logger.debug("Recibida petición para obtener productos con stock bajo, umbral: {}", threshold);
        
        List<ProductResponse> products = productService.getLowStockProducts(threshold)
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody ProductUpdateRequest request) {
        logger.info("Recibida petición para actualizar producto ID: {}", id);
        
        Product product = productService.updateProduct(
            id,
            request.name(),
            request.description(),
            request.price(),
            request.stockQuantity(),
            request.category()
        );
        
        ProductResponse response = ProductResponse.fromDomain(product);
        logger.info("Producto actualizado exitosamente ID: {}", id);
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        logger.info("Recibida petición para eliminar producto ID: {}", id);
        
        productService.deleteProduct(id);
        logger.info("Producto eliminado exitosamente ID: {}", id);
        
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductResponse> updateStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockUpdateRequest request) {
        logger.info("Recibida petición para actualizar stock del producto ID: {}, cambio: {}", 
                    id, request.quantityChange());
        
        Product product = productService.updateStock(id, request.quantityChange());
        ProductResponse response = ProductResponse.fromDomain(product);
        
        logger.info("Stock actualizado para producto ID: {}", id);
        return ResponseEntity.ok(response);
    }

    record ProductRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        String description,
        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser positivo")
        BigDecimal price,
        @NotNull(message = "La cantidad en stock es obligatoria")
        @Positive(message = "La cantidad en stock debe ser positiva")
        Integer stockQuantity,
        @NotBlank(message = "La categoría es obligatoria")
        String category
    ) {}

    record ProductUpdateRequest(
        String name,
        String description,
        @Positive(message = "El precio debe ser positivo")
        BigDecimal price,
        @Positive(message = "La cantidad en stock debe ser positiva")
        Integer stockQuantity,
        String category
    ) {}

    record StockUpdateRequest(
        @NotNull(message = "El cambio de cantidad es obligatorio")
        Integer quantityChange
    ) {}

    record ProductResponse(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        String category,
        String createdAt,
        String updatedAt
    ) {
        static ProductResponse fromDomain(Product product) {
            return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getCategory(),
                product.getCreatedAt() != null ? product.getCreatedAt().toString() : null,
                product.getUpdatedAt() != null ? product.getUpdatedAt().toString() : null
            );
        }
    }
}

// === ARCHIVO: src/main/java/com/inventory/infrastructure/GlobalExceptionHandler.java ===
package com.inventory.infrastructure;

import com.inventory.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        logger.warn("Validation error: {}", ex.getMessage());
        
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "Validation failed",
            "Los datos proporcionados no son válidos",
            request
        );
        response.put("fieldErrors", fieldErrors);
        
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        logger.error("Invalid argument: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "Invalid argument",
            ex.getMessage(),
            request
        );
        
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(
            ProductNotFoundException ex, WebRequest request) {
        logger.warn("Product not found: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.NOT_FOUND,
            "Product not found",
            ex.getMessage(),
            request
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientStockException(
            InsufficientStockException ex, WebRequest request) {
        logger.warn("Insufficient stock: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.CONFLICT,
            "Insufficient stock",
            ex.getMessage(),
            request
        );
        response.put("availableStock", ex.getAvailableStock());
        response.put("requestedStock", ex.getRequestedStock());
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(
            Exception ex, WebRequest request) {
        logger.error("Unexpected error: {}", ex.getMessage(), ex);
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Internal server error",
            "Ha ocurrido un error inesperado. Por favor, contacte al administrador.",
            request
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    private Map<String, Object> buildErrorResponse(
            HttpStatus status, String error, String message, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", status.value());
        response.put("error", error);
        response.put("message", message);
        response.put("path", request.getDescription(false).replace("uri=", ""));
        response.put("traceId", UUID.randomUUID().toString());
        return response;
    }
}

class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class InsufficientStockException extends RuntimeException {
    private final int availableStock;
    private final int requestedStock;

    public InsufficientStockException(String message, int availableStock, int requestedStock) {
        super(message);
        this.availableStock = availableStock;
        this.requestedStock = requestedStock;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public int getRequestedStock() {
        return requestedStock;
    }
}

// === ARCHIVO: src/test/java/com/inventory/application/ProductServiceTest.java ===
package com.inventory.application;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;
    private UUID testProductId;

    @BeforeEach
    void setUp() {
        testProductId = UUID.randomUUID();
        testProduct = new Product();
        testProduct.setId(testProductId);
        testProduct.setName("Test Product");
        testProduct.setDescription("Test Description");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStockQuantity(50);
        testProduct.setCategory("Electronics");
        testProduct.setCreatedAt(LocalDateTime.now());
        testProduct.setUpdatedAt(LocalDateTime.now());
    }

    @Test
    @DisplayName("Should create a new product successfully")
    void testCreateProduct_Success() {
        when(productRepository.save(any(Product.class))).thenReturn(testProduct);

        Product created = productService.createProduct(testProduct);

        assertNotNull(created);
        assertEquals("Test Product", created.getName());
        assertEquals("Electronics", created.getCategory());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should retrieve product by ID")
    void testGetProductById_Found() {
        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));

        Optional<Product> result = productService.getProductById(testProductId);

        assertTrue(result.isPresent());
        assertEquals(testProductId, result.get().getId());
        verify(productRepository, times(1)).findById(testProductId);
    }

    @Test
    @DisplayName("Should return empty when product not found")
    void testGetProductById_NotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<Product> result = productService.getProductById(nonExistentId);

        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findById(nonExistentId);
    }

    @Test
    @DisplayName("Should retrieve all products")
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(testProduct, createAnotherProduct());
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should update product successfully")
    void testUpdateProduct_Success() {
        Product updatedDetails = new Product();
        updatedDetails.setName("Updated Name");
        updatedDetails.setDescription("Updated Description");
        updatedDetails.setPrice(new BigDecimal("149.99"));
        updatedDetails.setStockQuantity(100);
        updatedDetails.setCategory("Updated Category");

        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product result = productService.updateProduct(testProductId, updatedDetails);

        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
        assertEquals(new BigDecimal("149.99"), result.getPrice());
        verify(productRepository, times(1)).findById(testProductId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should delete product by ID")
    void testDeleteProduct_Success() {
        doNothing().when(productRepository).deleteById(testProductId);

        productService.deleteProduct(testProductId);

        verify(productRepository, times(1)).deleteById(testProductId);
    }

    @Test
    @DisplayName("Should find products by category")
    void testFindByCategory() {
        List<Product> electronicsProducts = Arrays.asList(
            testProduct,
            createAnotherProduct()
        );
        when(productRepository.findByCategory("Electronics")).thenReturn(electronicsProducts);

        List<Product> result = productService.findByCategory("Electronics");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> "Electronics".equals(p.getCategory())));
        verify(productRepository, times(1)).findByCategory("Electronics");
    }

    @Test
    @DisplayName("Should find low stock products")
    void testFindLowStockProducts() {
        Product lowStockProduct = new Product();
        lowStockProduct.setId(UUID.randomUUID());
        lowStockProduct.setName("Low Stock Item");
        lowStockProduct.setStockQuantity(5);

        List<Product> lowStockProducts = Arrays.asList(lowStockProduct);
        when(productRepository.findLowStockProducts(10)).thenReturn(lowStockProducts);

        List<Product> result = productService.findLowStockProducts(10);

        assertEquals(1, result.size());
        assertTrue(result.stream().allMatch(p -> p.getStockQuantity() < 10));
        verify(productRepository, times(1)).findLowStockProducts(10);
    }

    @Test
    @DisplayName("Should update stock quantity")
    void testUpdateStockQuantity() {
        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product result = productService.updateStockQuantity(testProductId, 75);

        assertEquals(75, result.getStockQuantity());
        verify(productRepository, times(1)).findById(testProductId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should throw exception when updating stock of non-existent product")
    void testUpdateStockQuantity_ProductNotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, 
            () -> productService.updateStockQuantity(nonExistentId, 100));
    }

    private Product createAnotherProduct() {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName("Another Product");
        product.setDescription("Another Description");
        product.setPrice(new BigDecimal("199.99"));
        product.setStockQuantity(25);
        product.setCategory("Electronics");
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}

// === ARCHIVO: src/test/java/com/inventory/infrastructure/ProductControllerTest.java ===
package com.inventory.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private Product testProduct;
    private UUID testProductId;
    private String productJson;

    @BeforeEach
    void setUp() throws Exception {
        testProductId = UUID.randomUUID();
        testProduct = new Product();
        testProduct.setId(testProductId);
        testProduct.setName("Test Product");
        testProduct.setDescription("Test Description");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStockQuantity(50);
        testProduct.setCategory("Electronics");
        testProduct.setCreatedAt(LocalDateTime.now());
        testProduct.setUpdatedAt(LocalDateTime.now());
        
        productJson = objectMapper.writeValueAsString(testProduct);
    }

    @Test
    @DisplayName("Should create product and return 201 Created")
    void testCreateProduct_Returns201() throws Exception {
        when(productService.createProduct(any(Product.class))).thenReturn(testProduct);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(testProductId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"))
                .andExpect(jsonPath("$.category").value("Electronics"));

        verify(productService, times(1)).createProduct(any(Product.class));
    }

    @Test
    @DisplayName("Should return 400 when creating product with invalid data")
    void testCreateProduct_Returns400_ValidationError() throws Exception {
        Product invalidProduct = new Product();
        invalidProduct.setName(null);
        invalidProduct.setPrice(BigDecimal.valueOf(-10));
        
        String invalidJson = objectMapper.writeValueAsString(invalidProduct);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should retrieve product by ID")
    void testGetProductById_Returns200() throws Exception {
        when(productService.getProductById(testProductId)).thenReturn(Optional.of(testProduct));

        mockMvc.perform(get("/api/products/{id}", testProductId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testProductId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"));

        verify(productService, times(1)).getProductById(testProductId);
    }

    @Test
    @DisplayName("Should return 404 when product not found")
    void testGetProductById_Returns404() throws Exception {
        UUID nonExistentId = UUID.randomUUID();
        when(productService.getProductById(nonExistentId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/products/{id}", nonExistentId))
                .andExpect(status().isNotFound());

        verify(productService, times(1)).getProductById(nonExistentId);
    }

    @Test
    @DisplayName("Should retrieve all products")
    void testGetAllProducts_Returns200() throws Exception {
        List<Product> products = Arrays.asList(testProduct, createAnotherProduct());
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Test Product"))
                .andExpect(jsonPath("$[1].name").value("Another Product"));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    @DisplayName("Should return empty list when no products exist")
    void testGetAllProducts_ReturnsEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    @DisplayName("Should update product and return 200")
    void testUpdateProduct_Returns200() throws Exception {
        Product updatedProduct = new Product();
        updatedProduct.setId(testProductId);
        updatedProduct.setName("Updated Product");
        updatedProduct.setDescription("Updated Description");
        updatedProduct.setPrice(new BigDecimal("149.99"));
        updatedProduct.setStockQuantity(75);
        updatedProduct.setCategory("Updated Electronics");
        updatedProduct.setCreatedAt(testProduct.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        when(productService.updateProduct(eq(testProductId), any(Product.class)))
                .thenReturn(updatedProduct);

        String updatedJson = objectMapper.writeValueAsString(updatedProduct);

        mockMvc.perform(put("/api/products/{id}", testProductId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Product"))
                .andExpect(jsonPath("$.price").value(149.99));

        verify(productService, times(1)).updateProduct(eq(testProductId), any(Product.class));
    }

    @Test
    @DisplayName("Should return 404 when updating non-existent product")
    void testUpdateProduct_Returns404() throws Exception {
        UUID nonExistentId = UUID.randomUUID();
        when(productService.updateProduct(eq(nonExistentId), any(Product.class)))
                .thenThrow(new NoSuchElementException("Product not found"));

        mockMvc.perform(put("/api/products/{id}", nonExistentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should delete product and return 204")
    void testDeleteProduct_Returns204() throws Exception {
        doNothing().when(productService).deleteProduct(testProductId);

        mockMvc.perform(delete("/api/products/{id}", testProductId))
                .andExpect(status().isNoContent());

        verify(productService, times(1)).deleteProduct(testProductId);
    }

    @Test
    @DisplayName("Should search products by category")
    void testSearchByCategory_Returns200() throws Exception {
        List<Product> electronicsProducts = Arrays.asList(testProduct);
        when(productService.findByCategory("Electronics")).thenReturn(electronicsProducts);

        mockMvc.perform(get("/api/products/search")
                .param("category", "Electronics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].category").value("Electronics"));

        verify(productService, times(1)).findByCategory("Electronics");
    }

    @Test
    @DisplayName("Should get low stock products")
    void testGetLowStockProducts_Returns200() throws Exception {
        Product lowStockProduct = new Product();
        lowStockProduct.setId(UUID.randomUUID());
        lowStockProduct.setName("Low Stock Item");
        lowStockProduct.setStockQuantity(5);
        lowStockProduct.setCategory("Low Stock Category");

        List<Product> lowStockList = Arrays.asList(lowStockProduct);
        when(productService.findLowStockProducts(10)).thenReturn(lowStockList);

        mockMvc.perform(get("/api/products/low-stock")
                .param("threshold", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].stockQuantity").value(5));

        verify(productService, times(1)).findLowStockProducts(10);
    }

    private Product createAnotherProduct() {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName("Another Product");
        product.setDescription("Another Description");
        product.setPrice(new BigDecimal("199.99"));
        product.setStockQuantity(25);
        product.setCategory("Electronics");
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}
```
