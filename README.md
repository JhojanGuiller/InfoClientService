# MICROSERVICE CLIENT
Este microservicio muestra los clientes de un banco.

# INSTALACION
Este microservicio es parte de una infraestructura de microservicios y requiere la ejecucion de otro app para su funcionamiento

Primero se debe descargar los siguiente repositorios
1. https://github.com/JhojanGuiller/BankApiGateway
2. https://github.com/JhojanGuiller/ConfigServer
3. https://github.com/JhojanGuiller/EurekaBankService
4. Actual repositorio

Ejecutarlos en el mismo orden que se descarga

## EJECUTAR LISTA DE CLIENTE PRECARGADOS
- Asegurarse que el servicio mongodb este corriendo
- Ejecutar el mongo bash
- Ingresar el siguiente comando
 - load("<ruta>/InfoClientService/Document_InfoClient.js")

## ESTRUCTURA DEL PRODUCTO
{
  "idCliente": Integer,
  "nombre": String,
  "apellido": String,
  "dni": String,
  "tipoCliente": String
}

## RUTAS
Revisar el repositorio https://github.com/JhojanGuiller/BankApiGateway
