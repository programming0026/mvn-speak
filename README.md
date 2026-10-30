# Texto a voz con ElevenLabs

Convierte texto en voz natural usando la API de [ElevenLabs](https://elevenlabs.io/), guarda el resultado como MP3 y lo reproduce.

## Características

- Lista las voces disponibles en la cuenta.
- Síntesis de voz en *streaming* con el modelo `eleven_turbo_v2` (configurable).
- Guarda el audio en `output.mp3` y lo reproduce con JLayer.
- Cliente HTTP nativo de Java (`java.net.http`) y Gson para el JSON.
- La clave de la API se lee de una variable de entorno: nunca queda escrita en el código.

## Requisitos

- JDK 21 y Maven 3.9 o superior.
- Una cuenta de ElevenLabs y su clave de API.
- Salida de audio para la reproducción.

## Compilar y ejecutar

```bash
export ELEVENLABS_API_KEY="tu_clave"      # en PowerShell: $env:ELEVENLABS_API_KEY="tu_clave"
mvn compile exec:java
```

## Notas

- No subas tu clave de API a ningún repositorio.
- ElevenLabs es un servicio de pago con un plan gratuito limitado.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-speak-1.0.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
