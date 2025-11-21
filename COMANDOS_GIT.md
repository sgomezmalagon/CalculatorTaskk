# Comandos para hacer Push a GitHub desde Android Studio

## Tu repositorio: https://github.com/sgomezmalagon/CalculatorTaskk

Abre la **Terminal de Android Studio** (View → Tool Windows → Terminal o Alt+F12) y ejecuta estos comandos:

---

## Paso 1: Cambiar el remoto a HTTPS
```bash
git remote set-url origin https://github.com/sgomezmalagon/CalculatorTaskk.git
```

## Paso 2: Verificar que el cambio se aplicó
```bash
git remote -v
```
Deberías ver:
```
origin  https://github.com/sgomezmalagon/CalculatorTaskk.git (fetch)
origin  https://github.com/sgomezmalagon/CalculatorTaskk.git (push)
```

## Paso 3: Verificar la rama actual
```bash
git branch
```

## Paso 4: Ver el estado del repositorio
```bash
git status
```

## Paso 5: Agregar todos los archivos (si es necesario)
```bash
git add .
```

## Paso 6: Hacer commit (si es necesario)
```bash
git commit -m "Initial commit - Calculadora Android"
```

## Paso 7: Hacer push al repositorio
```bash
git push -u origin main
```

**Si tu rama se llama `master` en lugar de `main`, usa:**
```bash
git push -u origin master
```

---

## Autenticación

Cuando Git te pida credenciales:
- **Username:** sgomezmalagon
- **Password:** Usa un **Personal Access Token** (NO tu contraseña de GitHub)

### Cómo crear un Personal Access Token:
1. Ve a: https://github.com/settings/tokens
2. Click en **Generate new token** → **Generate new token (classic)**
3. Nombre: "Android Studio"
4. Marca: **repo** (acceso completo a repositorios)
5. Click en **Generate token**
6. **COPIA EL TOKEN** (solo lo verás una vez)
7. Usa ese token como contraseña

---

## SOLUCIÓN AL ERROR "src refspec main does not match any"

Este error significa que no tienes una rama llamada `main`. Sigue estos pasos:

### Opción 1: Verificar qué rama tienes y hacer push
```bash
git branch
```

Si ves `master` en lugar de `main`, usa:
```bash
git push -u origin master
```

### Opción 2: Crear la rama main si no existe
```bash
git checkout -b main
git push -u origin main
```

### Opción 3: Si no hay commits todavía
```bash
git add .
git commit -m "Initial commit - Calculadora Android"
git branch -M main
git push -u origin main
```

---

## Resumen (Ejecuta en orden):
```bash
git remote set-url origin https://github.com/sgomezmalagon/CalculatorTaskk.git
git status
git add .
git commit -m "Initial commit - Calculadora Android"
git branch -M main
git push -u origin main
```

---

## Si algo sale mal:

### Ver qué remoto está configurado:
```bash
git remote -v
```

### Ver el historial de commits:
```bash
git log --oneline
```

### Forzar push (SOLO si es necesario):
```bash
git push -u origin main --force
```

