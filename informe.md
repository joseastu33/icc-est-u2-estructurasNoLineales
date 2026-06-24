# Universidad Politécnica Salesiana 

## Estructura de datos
## Estudiante: Jose Astudillo

## Practica Estructuras No Lineales
### Fecha: 22/06/2026

## Ejercicio 1
### Imprimir un arbol de enteros

![alt text](image.png)

### Descripcion del ejercicio

Este ejercicio proporciona una forma particular de impresión de árboles basándose en sus niveles
la idea resulta en adicionar +1 a cada nivel (lo que ocurre cuando un nodo posee hijos respectivos)
el formato en el que se imprimirán los nodos resulta en una combinación de tabuladores (espacios)
para añadir estética al formato de impresion, validando el caso base.

## Salida en consola

![alt text](image-5.png)

## Ejercicio 2
### Invertir un árbol usando recursividad

![alt text](image-1.png)

### Descripcion del ejercicio

Considerando que invertir un arbol binario consiste en intercambiar sus ramas, para lograr esto la idea
principal resulta en guardar una de las dos ramas en un auxiliar (puede ser izquierda o derecha siempre y
cuando se guarde una sola). Sin esta idea las ramas se perderían y entonces existiría el mismo nodo en ambas.
Esto considerando que se utiliza recursividad para explorar cada una de las posibles subramas

## Salida en consola

![alt text](image-6.png)

## Ejercicio 3
### Listar niveles en listas enlazadas

![alt text](image.png)

### Descripcion del ejercicio

Dado la raiz de la cual pueden derivarse otras ramas, la implementacion de las colas
permite dar al metodo la caracteristica de tener los niveles ordenados al momento de guardar
la naturaleza del uso de una queue resulta en que, los demás elementos se van encolando detrás
quedando de esta forma nivel por nivel: es decir, primero se guarda en una cola(ya se ordenan), 
posteriormente se los implementa en una lista.

## Salida en consola

