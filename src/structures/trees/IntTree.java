package structures.trees;


import java.util.ArrayDeque;

import structures.node.Node;


// Clase que representa un árbol binario de enteros
public class IntTree {

    private Node<Integer> root;
    private int peso;

    /// no se pasa root como parámetro, porque al inicializar no puedo mandar un root
    public IntTree() { //queda vacío el constructor
        this.root = null;
    }
    //isEmpty revisa si tiene al menos un nodo (si esta lleno)
    //como el árbol se accede mediante su raíz, si no existe raíz no existen hijos
    public boolean isEmpty() {
        return root == null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> node) {
        root = node; //usar un nodo como raíz (para subÁrboles)
    }
    //se convierte a nodo porque un nodo posee tanto valor como cápsula de ese nodo
    //si tengo un valor del nodo, lo guardo en una capsula
    public void setRoot(Integer value) {
        Node<Integer> node = new Node<Integer>(value); //tengo un valor y ese valor convertirlo en nodo
        root = node;
    }

    public void insert(Integer value) { // 10
        Node<Integer> node = new Node<Integer>(value); // |10| 
        root = insertRecursivo(root, node); // |10| -- simplemente lo inserta (AUN NO ES recursivo)
    }
    //el peso cambia si inserto un nodo, por eso voy al metodo de insert
    public void insert(Node<Integer> value) { // 10
        root = insertRecursivo(root, value);
        peso++;
    }

    public int getPeso(){
        return peso;
    }

    // recursivo para insertar valores ARBOL BINARIO
    private Node<Integer> insertRecursivo(Node<Integer> actual, Node<Integer> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        // validar si es mayoy o nenor y decidir si lo ingerso a la der o izq
        if (actual.getValue() > nodeInsertar.getValue()) {
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        System.out.print(actual + " "); //visitar = imprimir
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual + " ");

    }

    public void inOrder(){
        inOrderRecursivo(root);
    }

    public void inOrderRecursivo(Node<Integer> actual){
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
    public void nivelesRecursivo(Node<Integer> actual){
        //como la amplitud requiere niveles
        //se aplica una cola, porque la cola tiene principio FIFO
        if(root == null){
            return;
        } 
        ArrayDeque<Node<Integer>> colaNodos = new ArrayDeque<>();
        colaNodos.offer(root);

        while(!colaNodos.isEmpty()){
            Node<Integer> actualN = colaNodos.poll();
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
        ArrayDeque<Node<Integer>> colaNodos = new ArrayDeque<>();
        colaNodos.add(root);
        int alturaArbol = 0;

        while(!colaNodos.isEmpty()){
            int nodosNivel = colaNodos.size();
            for(int i = 0; i < nodosNivel; i++){
                Node<Integer> nodoActual = colaNodos.poll(); 
                if(nodoActual.getLeft() != null)
                colaNodos.offer(nodoActual.getLeft());

                if(nodoActual.getRight() != null)
                colaNodos.offer(nodoActual.getRight());
            }
        }
        alturaArbol += 1;
    return alturaArbol;
    }


    private int weightRecursivo(Node<Integer> actual){
        if(actual == null){
            return 0;
        }
        int leftWeight = weightRecursivo(actual.getLeft());
        int righWeight = weightRecursivo(actual.getRight());
        return (leftWeight + righWeight + 1); 
    }
    //la complejidad espacial aumentó al crear la variable
}
/*
private static void runIntComparativaPesos() {
        IntTree tree = new IntTree();
        Random random = new Random();

        final int TOTAL_NODOS = 50_000;
        final int MIN = 1;
        final int MAX = 50_000;

        // Insertar 50 000 números aleatorios entre 1 y 50 000
        for (int i = 0; i < TOTAL_NODOS; i++) {
            int value = random.nextInt(MAX - MIN + 1) + MIN;
            tree.insert(value);
        }

        // Medir peso con variable acumulada
        long inicioPesoVariable = System.nanoTime();

        int pesoVariable = tree.getPeso();

        long finPesoVariable = System.nanoTime();

        double tiempoPesoVariableMs = (finPesoVariable - inicioPesoVariable) / 1_000_000.0;

        // Medir peso recursivo
        long inicioPesoRecursivo = System.nanoTime();

        int pesoRecursivo = tree.peso();

        long finPesoRecursivo = System.nanoTime();

        double tiempoPesoRecursivoMs = (finPesoRecursivo - inicioPesoRecursivo) / 1_000_000.0;

        // Resultados
        System.out.println("Cantidad de nodos insertados: " + TOTAL_NODOS);
        System.out.println("Peso usando variable: " + pesoVariable);
        System.out.println("Peso usando recursion: " + pesoRecursivo);

        System.out.println();

        System.out.println("Tiempo getPeso(): "
                + tiempoPesoVariableMs + " ms");

        System.out.println("Tiempo pesoRecursivo(): "
                + tiempoPesoRecursivoMs + " ms");
    }








*/
    
