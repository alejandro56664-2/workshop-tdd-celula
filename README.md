# workshop-tdd-celula
Repositorio base para taller de TDD en Java con un ejemplo cercano al trabajo diario en la célula.

## Contenido
- Introducción
- Historia de usuario

## Introducción

Este repo contiene los recursos para la realización de un ejercicio básico de desarrollo usando TDD de una HU similar a las que se desarrollan en el equipo "Vikingos". Se propone una historia de usuario ficticia y se propone realizar la implementación usando la técnica de _Mob programming_.
En la implementación no se presta mucha atención a las herramientas como tal, si no mas bien, para ayudar a los integrantes del equipo a enfrentarse a la solución de un reto tipico del día a día en la célula.

## Historia de usuario

A continuación se plantea la Historia de usuario:

>*Yo* como *Desarrollador de Productos digitales* quiero:
>Un servicio REST para validar la identidad de un usuario a partir de los datos de su documento de identidad (tipo y id) una foto de su rostro y
>una fotografía del documento identidad usando un servicio de terceros. Las imágenes serán guardadas en un bucket de s3 por el consumidor.

### Notas
- El procesamiento de las imágenes se realiza a través de un servicio de terceros tipo REST. 
- Hay un parámetro del path diferente por cada tipo de identificación.
- El servicio de terceros solo soporta 1 TPS  y tiene una alta latencia.

###  Criterios

- Las imágenes se deben recibir codificadas en base64.
- Por el momento solo se reciben dos imágenes, pero puede ser más en el futuro.
- Debe recibir un id generado por el consumidor del servicio, en caso de que no venga se debe generar un UUID. Este servicio será orquestado por otros más, por lo tanto se requiere mantener una trazabilidad de negocio.
- Debe recibir el tipo de cédula y el número de identificación.
- Solo hay dos tipos de identificación soportados: CC y CE

### Información adicional de contexto de negocio:
- Se realizará publicidad por medios digitales por lo que se esperan picos de demanda en momentos indeterminados.
- Si falla el servicio de backend no se puede perder la intención del usuario de validación.

### Información adicional de contexto de técnico:
Ejemplo consumo Servicio backend de terceros:
- Método: POST
- Path: ```https://host:port/api/validate/{cc|ce}```
- Body:
```
{
  "id": "string",
  "idType": "string",
  "images": {
    "face": "base64",
    "documentCard": "base64"
   }
}
```
- Respuesta satisfactoria:
```
{
  "response": {
    "score": "0.89" //valor entre 0 y 1
  }
}
```
- Respuesta error: 
```
{
  "error": {
    "code": "1",
    "description": "La calidad de las imagenes no permiten hacer hacer la validación",
  }
}
```

### Contexto del ejercicio

Para la realización de este ejercicio, ya se encuentran construidos:

- Modelos
- La arquitectura de la función (por capas)
- Mocks listos

Se propone implementar el ```Service``` principal de la función lambda:

### Requisitos

- El servicio debe usar un cliente de s3 que recibe la key del archivo y devuelve el binario (ya está disponible a través de un mock).
- El servicio debe usar un clientws que invoca el servicio de terceros (ya está disponible a través de un mock).
- Debe cargar el umbral del score desde el parameter store.
- Debe construir el request para el servicio de terceros trayendo las imágenes del s3 y convertirlas en base64.
- Si la respuesta del servicio contiene un error, debe lanzar una excepción (la excepción ya esta creada).
- Si la respuesta es correcta, debe comparar el umbral con el score obtenido. Si es mayor, responder que el usuario ha sido validado. Si la respuesta es menor, responder que el usuario es invalido.

