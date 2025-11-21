# Comandos para subir el proyecto actualizado a GitHub

## Repositorio: https://github.com/sgomezmalagon/CalculatorTaskk

Abre la **Terminal de Android Studio** (View → Tool Windows → Terminal o Alt+F12) y ejecuta estos comandos:

---

## Paso 1: Verificar el estado actual
```bash
git status
```

## Paso 2: Agregar todos los cambios
```bash
git add .
```

## Paso 3: Hacer commit con los cambios actualizados
```bash
git commit -m "Actualización: Calculadora con fondo negro y botones morados"
```

## Paso 4: Verificar que el remoto esté configurado correctamente
```bash
git remote -v
```
Deberías ver:
```
origin  https://github.com/sgomezmalagon/CalculatorTaskk.git (fetch)
origin  https://github.com/sgomezmalagon/CalculatorTaskk.git (push)
```

## Paso 5: Hacer push al repositorio
```bash
git push -u origin main
```

**Si tu rama se llama `master` en lugar de `main`, usa:**
```bash
git push -u origin master
```

---

## Si Git te pide credenciales:
- **Username:** sgomezmalagon
- **Password:** Tu Personal Access Token de GitHub

---

## Resumen de cambios que se subirán:

✅ **Archivos creados:**
- MainActivity.java (Actividad principal)
- CalculatorEngine.java (Motor de cálculo)
- activity_main.xml (Layout con GridLayout)

✅ **Actualizaciones:**
- AndroidManifest.xml (MainActivity configurada)

✅ **Diseño actualizado:**
- Fondo negro (#000000)
- Todos los botones morados (#9C27B0)
- Display con texto blanco
- GridLayout funcional con rowSpan y columnSpan

✅ **Funcionalidades:**
- Operaciones básicas: +, -, *, /
- Números decimales
- Paréntesis para operaciones complejas
- Botón Clear
- Cálculo con algoritmo Shunting Yard

---

## Si ya habías hecho push anteriormente y necesitas actualizar:

```bash
git add .
git commit -m "Actualización: Fondo negro, botones morados y display sin fondo"
git pull origin main --rebase
git push origin main
```

---

## Comandos rápidos (Copia y pega en orden):

```bash
git add .
git commit -m "Calculadora completa: fondo negro, botones morados, funcional"
git push -u origin main
```

---

**Nota:** Si tienes problemas con el push, asegúrate de haber configurado el remoto con HTTPS como se indicó en COMANDOS_GIT.md

