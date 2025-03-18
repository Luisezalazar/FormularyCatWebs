# BackEnd de Clínica JuntoSalud

### Proyecto hecho para [Hackacode 2025](https://hackacode.todocodeacademy.com/).

Para poder utilizar el proyecto completo es necesario el [Front](https://github.com/avacco/hackaton-frontend) preparado y funcionando.

## Inicio

Luego de clonar o descargar el proyecto se tiene que realizar lo siguiente :

1) Configurar el archivo "application.properties" para que realice las conexiones al servidor.
2) Establecer las variables de entorno dentro del framework para la conexión con la URL, nombre y contraseña del servidor.
3) Si se quiere usar la conexión https debe dejar las lineas de codigo ya colocadas:

        server.ssl.key-store=classpath:static/keystore.p12

        server.ssl.key-store-password=(Contraseña)

        server.ssl.keyStoreType=(codigo de llave)

        server.ssl.keyAlias=tomcat

        
4) Si se quiere usar la conexión localHost tiene que eliminar las 4 líneas de código SSL y colocar el puerto deseado



    