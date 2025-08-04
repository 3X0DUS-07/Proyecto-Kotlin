
# Kotlin - Gestor de Información Personal (versión sin ciclos)

Aplicación de consola en Kotlin para registrar y analizar información personal de usuarios. Ideal para practicar fundamentos como variables, tipos de datos, operadores y manipulación de cadenas.

---

## Funcionalidades

- Registro manual de 3 usuarios.
- Entrada básica de edad, altura, peso y correo electrónico.
- Cálculo de IMC (Índice de Masa Corporal).
- Clasificación del IMC según categorías de salud.
- Verificación de mayoría de edad.
- Manipulación de cadenas:
  - Nombre en mayúsculas y minúsculas.
  - Extracción del dominio del email.
- Resumen personalizado por usuario.

---

## Cálculo del IMC

El IMC (Índice de Masa Corporal) se calcula con la fórmula:

```
IMC = peso / (altura * altura)
```

Donde:
- peso está en kilogramos (kg)
- altura está en metros (m)

### Clasificación del IMC

| IMC         | Clasificación  |
|-------------|----------------|
| < 18.5      | Bajo peso      |
| 18.5 – 24.9 | Peso normal    |
| 25 – 29.9   | Sobrepeso      |
| 30 o más    | Obesidad       |

---

## Ejemplo de ejecución

```
Registro del usuario 1:
Nombre completo: Juan Pérez
Edad: 25
Altura (m): 1.75
Peso (kg): 70
Email: juanp@example.com
Ciudad de residencia: Bogotá

=== Información de Usuarios ===

Usuario 1
=== Resumen del Usuario ===
Nombre: JUAN PÉREZ (juan pérez)
Edad: 25 años (Mayor de edad)
Altura: 1.75 m
Peso: 70.0 kg
IMC: 22.86 (Peso normal)
Email: juanp@example.com (Dominio: example.com)
Ciudad: Bogotá
```

---

## Estructura del proyecto

```
HelloWorld/
├── src/
│   └── main.kt
├── README.md
```

---

## Requisitos cumplidos

- Variables y tipos de datos
- Operadores aritméticos y relacionales
- Manipulación de cadenas
- Presentación clara en consola
- Proyecto estructurado sin uso de ciclos (`for`, `while`, `do-while`)

---

## Tecnologías utilizadas

- Kotlin 1.9+
- IntelliJ IDEA
- JVM

---

## Instrucciones para ejecutar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/3X0DUS-07/Proyecto-Kotlin.git
   ```
2. Abre el proyecto con IntelliJ IDEA o ejecuta `main.kt` desde consola con Kotlin instalado.
3. Sigue las instrucciones que aparecen en la terminal.

---

## Autor

Desarrollado por: Yohusseff Caffella  
Proyecto académico para práctica con Kotlin.
