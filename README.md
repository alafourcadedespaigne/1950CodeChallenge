# 1950 Sotware Engineering Chanllenge

## Solución al problema Marble Collection

La solución se encuentra publicada de manera  **publica**  en Github en el siguiente link [Marble Solution](https://github.com/alafourcadedespaigne/1950CodeChallenge).


### Detalles de la solución

La **solución** se encarga de resolver el problema planteado en el Code Challenge. Para ello se apoya en las bondades de Java en su versión 8+ Tales como: **Stream, Comparable, Comparator**.
Los **método más significativos** son los siguientes:

**static boolean isPalindromeIgnoringCapitalizationAndPunctuation(String text)**  Este método haciendo uso de expresiones regulares dado una cadena , retorna verdadero o falso si dicha cadena es palíndrome, ignorando la capitalización y los signos de puntuación.

**static List<Marbles> orderedListOfMarbles(List<Marbles> exampleList)**  Este método haciendo uso de custom Comparator dado un listado de **Marbles** retorna una lista del mismo tipo pero ordenada por colores en el siguiente orden: **Red, Orange, Yellow, Green, Blue, Indigo, Violet (ROYGBIV).**

### Información Extra

La complejidad del algoritmo es O(n).

Para el despliegue de la solución podemos hacer uso de una estrategia A/B Deployment o Blue Green, la cual nos va a permitir tener dos ambientes de producción paralelos (Blue & Green) en el cual se despliegan las nuevas versiones del aplicativo en este caso el algoritmo de manera alternativa. Esto nos dará la ventaja de facilitar la realización de un rollback a la versión anterior, en caso de que exista una falla en la nueva versión, simplemente ruteando al ambiente previo.

El Algoritmo puede ser desplegado en Amazon Web Services **(AWS)** , haciendo uso de serverless . Esto me da muchas ventajas ya que no me tendría que preocupar por nada relacionado con la infraestructura necesaria para hacer público mi algoritmo sino que el mismo AWS se encarga.
Para el caso de este algoritmo la solución sería BaaS , osea , Backend como servicio; donde me apoyaré en los servicios de **Api Gateway**  y **AWS lambda** de la nube de Amazon para construir finalmente un Api REST sin servidor.

La relacion entre los componentes que dan vida al API Rest que mostrará mi algoritmo sería la siguiente.

- AWS Lambda: Es donde se implementará el código de nuestro algoritmo. Debido a que las lambdas en AWS se manejan bajo el esquema FaaS o Función como Servicio, entonces crearemos una lambda para cada función. Por tal motivos dividimos nuestra aplicación en varias funciones granulares (**isPalindromeIgnoringCapitalizationAndPunctuation, orderedListOfMarbles, etc...** )
- Api Gateway: Es el componente que usaremos para vincular una solicitud a una función implementada. Entonces, cuando llega esa solicitud en particular, se invoca la función. Esto lo manejamos de esta manera porque las lambdas están basadas en eventos y un evento puede ser una peticion HTTP a nuestra API REST

Para la automatización y el despliegue podemos hacer uso de las GitHub Actions, ya que nuestro código esta alojado en Github. Las GitHub Actions, ofrecen capacidades nativas directamente en el flujo de GitHub y podemos automatizar que una vez realizado un push a nuestra rama master en Github se dispare una acción que posibilite mediante la integración de Github con **CodeDeploy** automatizar el despliegue de nuestra lambda(s) en la nube de amazon.

En el caso de que el orden de los datos sea de millones de registros a procesar , no es recomendable utilizar la memoria para ello por lo que lo más conveniente seria alguna herramienta de procesamiento de grandes cantidades de datos (Big Data Tools), en este caso podemos trabajar con Apache Spark ya que está especialmente diseñado para el procesamiento de grandes volumenes de datos.