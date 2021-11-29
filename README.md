# workshop-tdd-celula
Repositorio base para taller de TDD en Java con un ejemplo cercano al trabajo diario en la célula.
Hecho con :heart: por:
- Jheison Alejandro Morales @alejandro5666-adl
- Daniel Contreras @danielcontreras1982

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
>una foto del documento identidad. Las imágenes serán guardadas en un bucket de s3 por el consumidor.

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
- Path: ```https://host:port/api/validation/issue```
- Body:
```
{
  "id": "string",
  "idType": "string",
  "files": {
    "file1": "base64",
    "file2": "base64"
   }
}
```
- Respuesta satisfactoria:
```
{
  "content": {
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

El contrato que nuestro servicio expone a las mesas digitales es:

- Método: POST
- Path: _Por definir_
- Body:
```
{
  "idNumber": "string",
  "idType": "string",
  "images": [
    {
      "name": "name1", //Nombre del campo.
      "url": "https://demo.s3.useast2.amazon.com" //URL del archivo subido en s3.
    }
  ]
}
```
- Respuesta satisfactoria:
```
{
  "result": "success"
  "content": {
    "valid": true|false
  }
}
```
- Respuesta error: 
```
{
  "result": "failure"
  "error": {
    "code": "-1",
    "description": "La calidad de las imagenes no permiten hacer hacer la validación",
  }
}
```
- La arquitectura de la función (por capas)
- Mocks listos

Se propone implementar el ```Service``` principal de la función lambda:

### Requisitos

- El servicio debe usar un cliente de s3 que recibe la url del archivo y devuelve el binario (ya está disponible la interfaz ```IStorageService```).
- El servicio debe usar un clientws que invoca el servicio de terceros (ya está disponible la interfaz ```IThirdPartyClient```).
- Debe cargar el umbral del score desde el parameter store, a través del ```ConfigRetriever```.
- Debe construir el request para el servicio de terceros trayendo las imágenes del s3 y convertirlas en base64.
- Si la respuesta del servicio contiene un error, debe lanzar una excepción (la excepción ya esta creada ```MyFunctionException```).
- Si la respuesta es correcta, debe comparar el umbral con el score obtenido. Si es mayor, responder que el usuario ha sido validado. Si la respuesta es menor, responder que el usuario es invalido.

