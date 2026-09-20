# Automatización de Pruebas

Proyecto desarrollado para implementar un proceso de automatización de pruebas utilizando Java, Maven, Git y GitHub Actions.

El proyecto utiliza un flujo de trabajo basado en ramas, permitiendo desarrollar nuevas funcionalidades de forma separada antes de integrarlas a la rama `develop`.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit
- Git
- GitHub
- GitHub Actions

## Estrategia de pruebas

Para verificar el correcto funcionamiento del proyecto se implementaron distintos niveles de pruebas automatizadas.

### Pruebas unitarias

Las pruebas unitarias permiten validar de manera individual las funcionalidades principales de la aplicación.

Para ejecutarlas:

```bash
mvn test
```

### Pruebas de integración

Las pruebas de integración permiten comprobar el funcionamiento del proyecto dentro del proceso completo de construcción.

Para ejecutarlas:

```bash
mvn verify
```

### Pruebas de aceptación

Se implementaron pruebas de aceptación para verificar que el comportamiento de la aplicación cumpla con los resultados esperados.

Para ejecutar específicamente las pruebas de aceptación:

```bash
mvn test -Dtest=CalculadoraAcceptanceTest
```

## Integración continua

Se configuró un pipeline de integración continua mediante GitHub Actions.

El pipeline se ejecuta automáticamente al realizar un `push` o `pull request` sobre las ramas `develop` y `main`.

El flujo implementado es:

1. Compilar proyecto.
2. Ejecutar pruebas unitarias.
3. Ejecutar pruebas de integración.
4. Ejecutar pruebas de aceptación.
5. Realizar despliegue en ambiente de prueba.

La configuración del pipeline se encuentra en:

```text
.github/workflows/ci.yml
```

## Despliegue en ambiente de prueba

Después de superar correctamente las pruebas automatizadas, el pipeline genera el artefacto `.jar` mediante Maven.

El artefacto es desplegado en el directorio:

```text
deployment/staging/
```

Antes del despliegue se mantiene una copia del artefacto estable para permitir su recuperación en caso de falla.

## Rollback

El proyecto incluye un mecanismo de rollback mediante:

```text
scripts/rollback.sh
```

En caso de producirse una falla durante el proceso de despliegue, el script elimina la versión problemática y restaura la versión estable almacenada previamente.

El funcionamiento del rollback fue probado eliminando el artefacto del ambiente de staging y ejecutando manualmente el script, comprobando posteriormente que el archivo `.jar` fue restaurado correctamente.

## Flujo de ramas

Para el desarrollo se utilizó un flujo basado en ramas.

Se trabajó principalmente con:

- `main`: versión principal del proyecto.
- `develop`: integración de funcionalidades.
- `feature/*`: desarrollo de nuevas funcionalidades.

Las funcionalidades fueron desarrolladas en ramas independientes y posteriormente integradas a `develop`.

## Ejecución del proyecto

Para compilar el proyecto:

```bash
mvn clean compile
```

Para ejecutar todas las pruebas y generar el artefacto:

```bash
mvn clean package
```

Al finalizar correctamente se genera el archivo `.jar` dentro del directorio:

```text
target/
```

## Evidencias

Durante el desarrollo se verificó:

- Ejecución exitosa del build.
- Ejecución exitosa de pruebas unitarias.
- Ejecución exitosa de pruebas de integración.
- Ejecución exitosa de pruebas de aceptación.
- Despliegue automático en ambiente de prueba.
- Ejecución y verificación del mecanismo de rollback.