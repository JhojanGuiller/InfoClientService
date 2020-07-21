# MICROSERVICE CLIENT
Este microservicio muestra los clientes de un banco.

## INSTALACION
Descargar docker de https://www.docker.com/get-started

Abrir una consola de comandos y ejecutar el siguiente comando para descargar una imagen Mongo
- docker pull mongo

Clonar este repositorio en una carpeta local

En la consola de comando ingresar a la carpeta donde se descargo este repositorio
- cd <ruta>/InfoClientService
- docker-compose up --build -d

Verificar si los container se levantaron con exito
- docker ps

## ESTRUCTURA DEL PRODUCTO
{
  "idCliente": Integer,
  "nombre": String,
  "apellido": String,
  "dni": String,
  "tipoCliente": String
}

## RUTAS
El container del microservicio esta corriendo en el puerto 8085

Las rutas son las siguientes:

- Obtener todos los clientes [Metodo GET]
  - http://localhost:8085/clients

- Obtener un cliente por id [Metodo GET]
  - http://localhost:8085/clients/<id>

- Agregar un cliente nuevo [Metodo POST]
  - http://localhost:8085/clients/addClient

- Actualizar un cliente [Metodo PUT]
  - http://localhost:8085/clients/updateClient/<id>

- Eliminar un cliente [Metodo DELETE]
  - http://localhost:8085/clients/deleteClient/<id>
