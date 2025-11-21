# SOLUCIÓN: Error "cannot find symbol btnSubtract"

## 🔧 El Problema
El error indica que no puede encontrar `btnSubtract`, pero el botón SÍ está en el archivo XML.
Este es un problema común de sincronización en Android Studio.

## ✅ SOLUCIÓN - Sigue estos pasos:

### 1. **Limpiar y Reconstruir el Proyecto**
   En Android Studio:
   - Ve a: **Build** → **Clean Project**
   - Espera a que termine
   - Luego: **Build** → **Rebuild Project**

### 2. **Invalidar Caché (si el paso 1 no funciona)**
   - Ve a: **File** → **Invalidate Caches...**
   - Marca todas las opciones
   - Click en **Invalidate and Restart**

### 3. **Sincronizar Gradle**
   - Click en el ícono de elefante 🐘 en la barra superior
   - O: **File** → **Sync Project with Gradle Files**

### 4. **Verificar que el archivo R.java se regeneró**
   El error debería desaparecer después de estos pasos.

---

## 📱 Nueva Distribución del Teclado

```
┌─────┬─────┬─────┬─────┐
│  C  │  (  │  )  │  /  │  ← Fila 0
├─────┼─────┼─────┼─────┤
│  7  │  8  │  9  │  *  │  ← Fila 1
├─────┼─────┼─────┼─────┤
│  4  │  5  │  6  │  -  │  ← Fila 2 (botón resta agregado)
├─────┼─────┼─────┼─────┤
│  1  │  2  │  3  │     │  ← Fila 3
├─────┴─────┼─────┤  +  │  (+ abarca 2 filas)
│     0     │  .  │     │  ← Fila 4
└───────────┴─────┴─────┘
      ╲_____________╱
          Botón =
```

## ✅ Confirmación
El botón `btnSubtract` está correctamente definido en:
- **Archivo**: `activity_main.xml`
- **ID**: `@+id/btnSubtract`
- **Ubicación**: Fila 2, Columna 3
- **Texto**: "-"

---

## 🚀 Después de la Sincronización

Una vez que hayas hecho Clean Project y Rebuild Project, el error desaparecerá y podrás:
1. Compilar el proyecto sin errores
2. Ejecutar la aplicación
3. Probar todas las operaciones de la calculadora

---

## ⚠️ Nota
Los warnings sobre "hardcoded strings" son solo advertencias de buenas prácticas.
NO afectan la funcionalidad y pueden ignorarse por ahora.

