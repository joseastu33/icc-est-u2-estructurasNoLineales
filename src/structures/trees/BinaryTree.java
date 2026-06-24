package structures.trees;
import java.util.ArrayDeque;

import structures.node.*;
public class BinaryTree <T extends Comparable<T>>{
    private Node<T> root;
    private int peso;

    /// no se pasa root como parámetro, porque al inicializar no puedo mandar un root
    public BinaryTree() { //queda vacío el constructor
        this.root = null;
    }
    //isEmpty revisa si tiene al menos un nodo (si esta lleno)
    //como el árbol se accede mediante su raíz, si no existe raíz no existen hijos
    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> node) {
        root = node; //usar un nodo como raíz (para subÁrboles)
    }
    //se convierte a nodo porque un nodo posee tanto valor como cápsula de ese nodo
    //si tengo un valor del nodo, lo guardo en una capsula
    public void setRoot(T value) {
        Node<T> node = new Node<T>(value); //tengo un valor y ese valor convertirlo en nodo
        root = node;
    }

    public void insert(T value) { // 10
        Node<T> node = new Node<T>(value); // |10| 
        root = insertRecursivo(root, node); // |10| -- simplemente lo inserta (AUN NO ES recursivo)
    }
    //el peso cambia si inserto un nodo, por eso voy al metodo de insert
    public void insert(Node<T> value) { // 10
        root = insertRecursivo(root, value);
        peso++;
    }

    public int getPeso(){
        return peso;
    }

    // recursivo para insertar valores ARBOL BINARIO
    private Node<T> insertRecursivo(Node<T> actual, Node<T> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        // validar si es mayoy o menor y decidir si lo ingerso a la der o izq
        //"Rafael" va a la izquierda o derecha
        //Rafael y Diego son iguales
        if (actual.getValue().compareTo(nodeInsertar.getValue()) > 0) { 
            //como es mayor a 0 el actual que el nodoInsertar
            //compareTo da 0 si los valores son iguales
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar)); //como no es mayor a
        }else{
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }
    //utilizo el compareTo (metodo de los strings, hago que toda clase que sea T tenga un metodo compare to)
    //public class BinaryTree <T extends Comparable<T>> la T tiene que 
    //para comparar comparable con cualquier tipo de objeto tiene que extender Comparable

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        System.out.print(actual + " "); //visitar = imprimir
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual + " ");

    }

    public void inOrder(){
        inOrderRecursivo(root);
    }

    public void inOrderRecursivo(Node<T> actual){
        if(actual == null){
            return;
        }
        inOrderRecursivo(actual.getLeft());
        System.out.print(actual + " ");
        inOrderRecursivo(actual.getRight());
    }
    public void niveles(){
        nivelesRecursivo(root);
    }
    public void nivelesRecursivo(Node<T> actual){
        //como la amplitud requiere niveles
        //se aplica una cola, porque la cola tiene principio FIFO
        if(root == null){
            return;
        } 
        ArrayDeque<Node<T>> colaNodos = new ArrayDeque<>();
        colaNodos.offer(root);

        while(!colaNodos.isEmpty()){
            Node<T> actualN = colaNodos.poll();
            System.out.println(actual + "");

            if(actual.getLeft() != null)
                colaNodos.offer(actual.getLeft());
            
            if(actual.getRight() != null)
                colaNodos.offer(actual.getRight());
            }
        }
    public void altura(){
        //para la altura se considera que la cola
        //ha guardado los niveles, entonces se recorren los niveles de la cola 
        //y se suma 1 por cada nivel
        alturaRecursivo();
    }
    public int alturaRecursivo(){
        if(root == null){
            return 0;
        }
        ArrayDeque<Node<T>> colaNodos = new ArrayDeque<>();
        colaNodos.add(root);
        int alturaArbol = 0;

        while(!colaNodos.isEmpty()){
            int nodosNivel = colaNodos.size();
            for(int i = 0; i < nodosNivel; i++){
                Node<T> nodoActual = colaNodos.poll(); 
                if(nodoActual.getLeft() != null)
                colaNodos.offer(nodoActual.getLeft());

                if(nodoActual.getRight() != null)
                colaNodos.offer(nodoActual.getRight());
            }
        }
        alturaArbol += 1;
    return alturaArbol;
    }


    private int weightRecursivo(Node<T> actual){
        if(actual == null){
            return 0;
        }
        int leftWeight = weightRecursivo(actual.getLeft());
        int righWeight = weightRecursivo(actual.getRight());
        return (leftWeight + righWeight + 1); 
    }
}

    
    //la complejidad espacial aumentó al crear la variable




