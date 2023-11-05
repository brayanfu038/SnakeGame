<a name="readme-top"></a>

# SnakeGame

> El juego de Snake es una implementación en Java que sigue el popular concepto del juego "Snake". Está desarrollado en una ventana gráfica usando la librería Swing de Java.

>Características Principales
Mecánica del Juego: El jugador controla una serpiente que se mueve a través de un área de juego. La serpiente puede cambiar de dirección usando las teclas de dirección (arriba, abajo, izquierda, derecha).

>Objetivo: El objetivo es recolectar manzanas dispersas aleatoriamente en el tablero para hacer crecer a la serpiente y ganar puntos.

>Elementos del Juego
Serpiente (Snake): El jugador controla una serpiente que crece en longitud a medida que consume manzanas.

>Manzanas (Apples): Se generan de manera aleatoria en la pantalla. Cuando la serpiente come una manzana, su longitud aumenta y el jugador gana puntos.

>Obstáculos (Barriers): Hay obstáculos que la serpiente debe evitar chocar para no terminar el juego. Estos obstáculos están representados por imágenes de bombas..

## Built With

- java


## STRATEGIA

Puntuacion: se escogio la estrategia de que de que la puntuacion aumente en una unidad cada vez que la serpiente muerde.

Alimento: Se generan de manera aleatoria en la pantalla. Cuando la serpiente come una manzana, su longitud aumenta y el jugador gana puntos. Si la serpiente no consume una manzana en un tiempo de 5 segundos, la manzana se reubicará en otro lugar del tablero.

Barreras: Cada 8 segundos, aparecerán obstáculos en forma de bomba en el tablero. Si la cabeza de la serpiente toca alguna de estas bombas, el juego termina instantáneamente.

movement: El tamaño de la serpiente está predefinido en 5 unidades en la clase GAMEPANEL, mientras que la velocidad de movimiento de la serpiente está predefinida en 150 en la clase CAMINANTE. Estos valores se encuentran fijos y no se realizó la lectura de estos valores desde un archivo.
### Prerequisites


La puntuacion se va a guardar en el archivo "puntuacion.ser"  que esta ubicado en la carpeta resources 
![image](https://github.com/brayanfu038/SnakeGame/assets/126002005/89d8da05-0aee-4898-92cb-7a0d60778902)



