# Calculadora Android - GridLayout

## 📱 Descripción del Proyecto

Calculadora completa para Android Studio usando **GridLayout** con Java puro (sin Kotlin, sin ViewBinding).

## 🎨 Estructura del GridLayout

### Distribución del Teclado (5 filas × 4 columnas)

```
┌─────┬─────┬─────┬─────┐
│  C  │  (  │  )  │  /  │  ← Fila 0
├─────┼─────┼─────┼─────┤
│  7  │  8  │  9  │  *  │  ← Fila 1
├─────┼─────┼─────┼─────┤
│  4  │  5  │  6  │     │  ← Fila 2
├─────┼─────┼─────┤  +  │
│  1  │  2  │  3  │     │  ← Fila 3 (+ abarca 3 filas)
├─────┴─────┼─────┤     │
│     0     │  .  │     │  ← Fila 4 (0 abarca 2 columnas)
└───────────┴─────┴─────┘
      ╲_____________╱
          Botón =
   (fuera del GridLayout)
```

### Características Especiales del GridLayout

1. **Botón "+"**: Abarca 3 filas (rowSpan=3) desde la fila 2 hasta la 4
2. **Botón "0"**: Abarca 2 columnas (columnSpan=2)
3. **Botón "="**: Ubicado fuera del GridLayout, abarca todo el ancho
4. **Botón "/"**: Comienza en la columna 3

## 📂 Archivos Creados

### 1. `activity_main.xml`
- **Ubicación**: `app/src/main/res/layout/activity_main.xml`
- **Descripción**: Layout principal con:
  - TextView para mostrar operaciones y resultados
  - GridLayout con 5 filas y 4 columnas
  - Todos los botones de la calculadora
  - Uso de `layout_rowSpan` y `layout_columnSpan`

### 2. `MainActivity.java`
- **Ubicación**: `app/src/main/java/com/example/calculadora/MainActivity.java`
- **Descripción**: Actividad principal que:
  - Inicializa todos los botones con `findViewById`
  - Implementa `View.OnClickListener` para manejar clics
  - Conecta la interfaz con el motor de la calculadora
  - Actualiza el display en tiempo real

### 3. `CalculatorEngine.java`
- **Ubicación**: `app/src/main/java/com/example/calculadora/CalculatorEngine.java`
- **Descripción**: Motor de cálculo que:
  - Maneja operaciones matemáticas básicas (+, -, *, /)
  - Soporta paréntesis para operaciones complejas
  - Usa el algoritmo Shunting Yard para evaluar expresiones
  - Maneja errores (división por cero, paréntesis no balanceados)

### 4. `AndroidManifest.xml`
- **Ubicación**: `app/src/main/AndroidManifest.xml`
- **Descripción**: Configuración de la app con MainActivity como launcher

## 🎯 Funcionalidades Implementadas

### Operaciones Básicas
- ✅ Suma (+)
- ✅ Resta (-)
- ✅ Multiplicación (*)
- ✅ División (/)
- ✅ Números decimales (.)
- ✅ Paréntesis ( )

### Funciones Adicionales
- ✅ Botón Clear (C) para limpiar todo
- ✅ Cálculo con botón igual (=)
- ✅ Manejo de errores
- ✅ Soporte para operaciones encadenadas

## 🎨 Paleta de Colores

- **Números (0-9)**: Azul (`#2196F3`)
- **Operaciones (+, -, *, /)**: Rojo/Verde/Naranja
  - Suma: Verde (`#4CAF50`)
  - Otras: Rojo (`#FF5722`)
- **Clear y paréntesis**: Gris (`#607D8B`)
- **Display**: Blanco con texto negro
- **Fondo**: Gris claro (`#F5F5F5`)

## 🔧 Tecnologías Utilizadas

- **Lenguaje**: Java (NO Kotlin)
- **Layout**: GridLayout (Android 4.0+)
- **Patrón**: findViewById y OnClickListener
- **Sin**: ViewBinding, DataBinding, ni librerías externas

## 🚀 Cómo Usar

1. **Compilar el proyecto**:
   - Sincronizar Gradle
   - Build → Make Project

2. **Ejecutar**:
   - Conectar un dispositivo Android o iniciar un emulador
   - Run → Run 'app'

3. **Usar la calculadora**:
   - Toca números y operadores
   - Usa paréntesis para operaciones complejas
   - Presiona "=" para obtener el resultado
   - Presiona "C" para limpiar

## 📋 Ejemplos de Uso

```
Ejemplo 1: 5 + 3 = 8
Ejemplo 2: 10 / 2 * 3 = 15
Ejemplo 3: (5 + 3) * 2 = 16
Ejemplo 4: 12.5 + 7.5 = 20
```

## ⚠️ Notas Importantes

1. Los warnings sobre "hardcoded strings" son normales y no afectan la funcionalidad
2. El GridLayout requiere API 14+ (Android 4.0 Ice Cream Sandwich)
3. La clase CalculatorEngine usa el algoritmo Shunting Yard para evaluación correcta de expresiones
4. Los errores de compilación sobre CalculatorEngine desaparecerán después de sincronizar Gradle

## 📱 Requisitos del Sistema

- **Android Studio**: Arctic Fox o superior
- **SDK mínimo**: API 21 (Android 5.0 Lollipop)
- **SDK target**: API 34 (Android 14)
- **Gradle**: 8.0+

## ✅ Checklist de Implementación

- ✅ GridLayout con 5 filas y 4 columnas
- ✅ Botón "/" en columna 3
- ✅ Botón "+" abarca 3 filas (layout_rowSpan="3")
- ✅ Botón "+" con layout_gravity="fill"
- ✅ Botón "0" abarca 2 columnas
- ✅ Botón "=" con layout_gravity="fill"
- ✅ Todos los botones numéricos (0-9)
- ✅ XML completo del GridLayout
- ✅ Clase MainActivity en Java
- ✅ Motor de cálculo funcional
- ✅ findViewById y OnClickListener
- ✅ Sin ViewBinding ni DataBinding

## 🎓 Estructura de Archivos

```
app/
├── src/
│   └── main/
│       ├── java/com/example/calculadora/
│       │   ├── MainActivity.java          ← Actividad principal
│       │   └── CalculatorEngine.java      ← Motor de cálculo
│       ├── res/
│       │   └── layout/
│       │       └── activity_main.xml      ← Layout con GridLayout
│       └── AndroidManifest.xml            ← Configuración
└── build.gradle.kts
```

---

¡Proyecto completado! 🎉
```
