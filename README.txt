Me presento soy Kenny Noy Gómez, Ingeniero Informatico, graduado de la Universidad Técnilogia de La Habana, Cuba. Tengo interes por este puesto ya que me considero con las habilidades necesarias para desempeñar las labores que requiere el mismo.

El paradigma que se siguió para la resolución de la prueba, esta basado en la produccion de microservicios en SpringBoot, es decir, se consideró el desarrollo del microservicio Prices, para la gestion de todo lo que englobe de cierta manera las peticiones, consultas, logica, etc., que gire en torno a la tabla mostrada por la actividad.

Teniendo esto en cuenta, y utilizando buenas practicas de diseño de software, se planteo la solucion inicial utilizando los principios de ApiFirst. Diseñando primeramente cuales son las necesidades y peticiones que se le harian al servicio, se diseño un RestController que contendria basicamente popular los datos mediante POST, consultar el problema principal mediante un GET con parametros, y una funcionalidad adicional extra para saber las entidades dependiendo de su price_List (no la pedian pero es algo extra).

Luego de diseñar los endpoints que se necesitan para darle solucion al problema, se pasa a maaquetar la conexion con la base de datos utilizando los patrones de diseño adecuados, se estructuro el proyecto por paquetes dependiendo de su funcion,
Paquete              funcion
PriceRestController  Almacenar controladores
PriceService         logica del negocio y validacion
Price                Modelo de mapeo de base de datos (Entidad)
PriceDTO             Mapeo para mostrar solamente lo que el usuario desea
PriceRepository      Conexion con la DB mediante el uso del SpringJPA

El conocimiento de las test, permitio su implementacion antes del desarrollo del proyecto, por lo que codificar en base a pruebas, atribuyó que el codigo que se desarrollara fuera menos riesgoso a fallar. Se construyeron pruebas Unitarias y de integracion para todos los endpoints.

Luego de concluir el diseño e implementacion del RestController,conteniendo los endpoints necesarios, se procedio a la implementacion de la logica que los respalda. 

Utilizado las drivedQuerys que brinda la libreria SpringJPA, se construyo una serie de consultas que satisfacian la recuperacion de datos de la base de datos. 

Se encontro el uso de DTO interesantes ya que enfatizaban el hecho de devolver parte de la entidad en cuestion.

En caso de que no se encientre un valor por que se entro mal un parametro, una simple validacion de HttpStatus.NOT_CONTENT se devolverá junto con la advertencia en texto de el error junto con una recomendacion.

Espero haber cumplido con todo lo exigido por el Test, les pongo mi contacto por si se tiene alguna duda:

+34 624 403766        :  Móvil
kennynoy98@gmail.com  :  Correo

Versiones:
OpenJDK20
Java 17.0.6
SpringBoot 3.0.5




