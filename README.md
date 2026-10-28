# Implementación de un servicio de gestión de inventario

Debes implementar un servicio de gestión de inventario que utilice las capacidades del marco de trabajo seleccionado. El servicio debe permitir la creación, lectura, actualización y eliminación de productos en el inventario. Además, debe manejar las variables de entorno, generar registros de rastros y conectarse con una base de datos utilizando un Mapeador Relacional de Objetos (ORM). El servicio estará expuesto a través de un enrutamiento de solicitudes.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Experiencia en Frameworks |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del entorno y enrutamiento de solicitudes

**Objetivo:** Configurar el entorno de desarrollo y establecer el enrutamiento básico de solicitudes para el servicio de gestión de inventario.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Configurar el entorno de desarrollo con las herramientas necesarias.
- Establecer el enrutamiento básico de solicitudes para las operaciones CRUD del servicio de gestión de inventario.

**Entregable:** Entorno de desarrollo configurado y enrutamiento básico de solicitudes establecido.

<details>
<summary>Pistas de conocimiento</summary>

- Configuración del entorno de desarrollo con las herramientas necesarias.
- Establecimiento del enrutamiento básico de solicitudes para las operaciones CRUD.

</details>

### Fase 2: Manejo de variables de entorno y generación de registros de rastros

**Objetivo:** Implementar el manejo de variables de entorno y la generación de registros de rastros en el servicio de gestión de inventario.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Implementar el manejo de variables de entorno en el servicio.
- Generar registros de rastros para las operaciones realizadas en el servicio.

**Entregable:** Servicio con manejo de variables de entorno y generación de registros de rastros implementado.

<details>
<summary>Pistas de conocimiento</summary>

- Manejo de variables de entorno en el servicio.
- Generación de registros de rastros para las operaciones realizadas.

</details>

### Fase 3: Conexión con base de datos y operaciones CRUD

**Objetivo:** Conectar el servicio con una base de datos y implementar las operaciones CRUD utilizando un Mapeador Relacional de Objetos (ORM).

**Tiempo estimado:** 5 días

**Instrucciones:**

- Conectar el servicio con una base de datos.
- Implementar las operaciones CRUD utilizando un Mapeador Relacional de Objetos (ORM).

**Entregable:** Servicio conectado con base de datos y operaciones CRUD implementadas utilizando un ORM.

<details>
<summary>Pistas de conocimiento</summary>

- Conexión del servicio con una base de datos.
- Implementación de las operaciones CRUD utilizando un ORM.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un Mapeador Relacional de Objetos (ORM) y para qué se utiliza?
- **paraQueSirve**: ¿Para qué sirve el manejo de variables de entorno en un servicio?
- **comoSeUsa**: ¿Cómo se utiliza un ORM para realizar operaciones CRUD en una base de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al conectar un servicio con una base de datos y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de un marco de trabajo para desarrollar un servicio de gestión de inventario?

## Criterios de Evaluacion

- Configuración del entorno de desarrollo y establecimiento del enrutamiento básico de solicitudes.
- Manejo de variables de entorno y generación de registros de rastros en el servicio.
- Conexión del servicio con una base de datos y implementación de las operaciones CRUD utilizando un ORM.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
