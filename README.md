

Prueba tecnica Mercado Libre

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN

Para realizar la prueba tecnica completa esta dividida en dos proyectos


- prueba mercadolibre : Algoritmo que detecta si una secuencia de adn es muntante o no.
- restservicemeli     : Servicio web que se utiliza para consultar si una secuencia es Mutante o no y Adicionalmente las estadisticas.

NOTA: Se realizaron dos proyecto para hacer le reto tecnico mas modular.

- prueba mercadolibre

Este proyecto abarca el algoritmo que se realiza sobre el arreglo de cadena
para detectar si la secuencia es un mutante o no.

se debe tomar en cuenta el archivo de .properties que se encuentra en la ruta:

prueba mercadolibre/src/main/resources/mutans.properties

En el mismo se puede observar las siguientes propiedades:

- number.of.words = AAAA,TTTT,CCCC,GGGG
  Se utiliza para detectar las cadena que se deben buscar en la secuencia de adn

- number.of.occurrences = 2
  Se utiliza para la cantidad de ocurrencias permitidas para detectar si una
  secuencia de Adn es mutante

**IMPORTANTE**: Este proyecto para uso local debe compilarse e instalar con el comando
mvn clean install package

- Tecnologias Usadas: Se trabajo con java 8, maven, junit, jacoco para las pruebas de covertura,
se trabajo con los principios SOLID

- Ruta del Reporte de Pruebas de Cobertura
prueba mercadolibre\target\site\jacoco\index.html


- restservicemeli
Este proyecto es el servicio web el cual se utiliza para consultar si una secuencia de cadena
es mutante o no, adicionalmente se validan las estaditas a traves del recurso stats.

se debe tomar en cuenta el archivo de .properties que se encuentra en la ruta:

restservicemeli/src/main/resources/application.properties

En el mismo se puede observar las siguientes propiedades:

- server.port=8085
	Se utiliza para indicar el puerto por el cual desplegara el servidor de tomcat enbebido.

- #spring.data.mongodb.uri= mongodb://localhost:27017/dna_races?maxPoolSize=10&waitQueueMultiple=10
    La misma se utiliza para trabajar de manera local debido a que la base de datos mongodb se encuentra
	en la nube de MongoDB Atlas esta propiedad se encuentra comentada.
	
- spring.data.mongodb.uri=mongodb+srv://eduardo:0123456789@cluster1988.pnlim.mongodb.net/dna_races?maxPoolSize=10&waitQueueMultiple=10	
  La misma se utiliza para trabajar de manera remota en la nube de MongoDB Atlas.
	

- IMPORTANTE: Este proyecto para uso local debe compilarse e instalar con el comando
mvn clean install package 

- Tecnologias Usadas: El proyecto esta hecho con maven, spring boot, java 8, spring data mongodb, Base de datos NoSql MongoDB, lombok,
Junit, Mockito, jacoco, swagger se aplico el patron modelo, vista, controlador, se utilizo principios SOLID, inyección de dependencias 
a través de las anotaciones de spring.


- IMPORTANTE: Este proyecto para uso local debe compilarse e instalar con el comando
mvn clean install package

- Tecnologias Usadas: Se trabajo con java 8, maven, junit, jacoco para las pruebas de covertura,
se trabajo con los principios SOLID

Ruta del Reporte de Pruebas de Cobertura
restservicemeli\target\site\jacoco\index.html


LOCALMENTE:
- Para ver la documentacion de la api con swagger-ui
  - http://localhost:8085/swagger-ui.html


- Endpoints de los servicios de Spring Boot 
  - http://localhost:8085/v1/meli/mutant/
  - http://localhost:8085/v1/meli/stats/
  
- Para levantar localmente el servicio realizado en springboot
  Se ejecuta el siguiente comando en la consola de windows o linux:
  - java -jar test-1.0.0-SNAPSHOT.jar


REMOTAMENTE:

- Para ver la documentacion de la api con swagger-ui en heroku
  - https://meli-test-boot.herokuapp.com/swagger-ui.html


- endpoints de los servicios de Spring Boot en heroku
  - https://meli-test-boot.herokuapp.com/v1/meli/mutant/
  - https://meli-test-boot.herokuapp.com/v1/meli/stats/


- IMPORTANTE: Se debe tener en cuenta que se tiene que tener configurado el acceso al servidor de base de datos
  mongodb para probarlo localmente o remotamente, esta url se encuentra en el archivo application.properties
