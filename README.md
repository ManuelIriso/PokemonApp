# Pokémon App

Pokémon App es una aplicación móvil desarrollada en **Java** para dispositivos Android. Permite a los usuarios capturar, gestionar y explorar Pokémon mediante una interfaz amigable e interactiva. Además, incluye funciones de configuración personalizadas, integración con la **PokéAPI**, y opciones de inicio de sesión y registro de usuarios.

## Características Principales

### 1. **Inicio de Sesión y Registro**
- Los usuarios pueden registrarse proporcionando un correo electrónico y una contraseña.
- Función de inicio de sesión con validación básica para asegurar que las credenciales sean correctas.
- Las credenciales se almacenan localmente utilizando `SharedPreferences`.

### 2. **Navegación Entre Pestañas**
La aplicación tiene tres pestañas principales, gestionadas mediante un `BottomNavigationView` y `Fragments`:
1. **Pokémon Capturados**: 
   - Muestra una lista de los Pokémon que el usuario ha capturado.
   - Cada Pokémon se muestra con su nombre, tipo, peso, altura y una imagen.
   - La lista utiliza un **RecyclerView** para una experiencia fluida.
   - Soporte para eliminar Pokémon (configurable en ajustes).

2. **Pokédex**: 
   - Muestra una lista de Pokémon obtenida en tiempo real de la **PokéAPI**.
   - Los usuarios pueden añadir Pokémon desde la Pokédex a su lista de capturados.
   - Datos dinámicos como nombre, tipo y sprites de Pokémon se obtienen directamente de la API.

3. **Ajustes**:
   - Habilitar o deshabilitar la eliminación de Pokémon capturados.
   - Cambiar el idioma entre español e inglés.
   - Cerrar sesión para volver a la pantalla de inicio de sesión.

### 3. **Integración con PokéAPI**
- Se utiliza Retrofit para realizar solicitudes HTTP a la [PokéAPI](https://pokeapi.co/).
- Los datos de la API, como nombres, tipos y sprites de Pokémon, se cargan dinámicamente en la Pokédex.

### 4. **Diseño y Estilo**
- La aplicación utiliza una paleta de colores inspirada en Pokémon:
  - Amarillo (`#FFCC00`): Vibrante y atractivo.
  - Rojo (`#FF0000`): Energético.
  - Azul (`#3B4CCA`): Relajante y temático.
- Diseño limpio y moderno con soporte para temas oscuros y claros.

---

## Requisitos del Sistema
- **Android Studio**: Versión 2024.2.1 (o superior).
- **SDK Mínimo**: Android 5.0 (API 21).
- **SDK Objetivo**: Android 13 (API 34).

---

## Tecnologías Utilizadas
- **Lenguaje**: Java.
- **Retrofit**: Para la integración con la PokéAPI.
- **Glide**: Para cargar imágenes (sprites de Pokémon).
- **RecyclerView**: Para listas eficientes y personalizables.
- **SharedPreferences**: Para almacenar configuraciones y credenciales de usuario.

---

## Instalación y Ejecución

### Paso 1: Clonar el Repositorio
Clona este repositorio en tu máquina local:
```bash
git clone https://github.com/tu-usuario/pokemon-app.git
