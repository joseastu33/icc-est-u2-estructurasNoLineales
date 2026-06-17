package structures.node.trees;


import java.util.ArrayDeque;

import structures.node.Node;
import structures.trees.IntTree;


public class App {
    public static void main(String[] args) throws Exception {

        runIntTree();
    }

    private static void runIntTree() {
        IntTree arbolNumeros = new IntTree(); 
        /// CONSTRUYO el Árbol
        Node<Integer> nodo1 = new Node<Integer>();
        Node<Integer> nodo2 = new Node<Integer>();
        arbolNumeros.insert(nodo1);
        arbolNumeros.insert(nodo2); //se manipula facil los nodos

        Node<Integer> root = arbolNumeros.getRoot();
        // Node<Integer> root = arbolNumeros.getRoot();

        // root.setLeft(node2);
        // root.setRight(node3);

        // node2.setLeft(node4);
        // node4.setRight(node5);

        //// ERROR GENERA CLICLOS
        // node5.setLeft(root);

        arbolNumeros.insert(10);
        arbolNumeros.insert(5);
        arbolNumeros.insert(3);
        arbolNumeros.insert(8); /// INORDER 3, 5, 8, 10, 15, 20
        arbolNumeros.insert(20); /// POSTORDER 3 8 5 15 20 10
        arbolNumeros.insert(15); // ANCHURA O NIVELES: 10 5 20 3 8 15

        System.out.println("pre Order");

        arbolNumeros.preOrder();
        System.out.println("Pos Order");
        arbolNumeros.posOrder();
    }
}

// Clase que representa un árbol binario de enteros
public class IntTree {

    private Node<Integer> root;

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

    public void insert(Node<Integer> value) { // 10
        root = insertRecursivo(root, value);
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
        ArrayDeque<Integer> colaNodos = new ArrayDeque<>();
        colaNodos.add(root);

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
        alturaRecursivo(root);
    }
    public int alturaRecursivo(){
        if(root == null){
            return 0;
        }
        ArrayDeque<Node<Integer>> colaNodos = new ArrayDeque<>();
        colaNodos.add(root);
        int alturaArbol = 0;
        while(!colaNodos.isEmpty()){
            int nodosNivel = cola.size();
            for(int i = 0; i < nodosNivel; i++){
                Node<Integer> nodoActual = colaNodos.poll(); 
                if(actual.getLeft() != null)
                colaNodos.offer(actual.getLeft());

                if(actual.getRight() != null)
                colaNodos.offer(actual.getRight());
            }
        }
        altura += 1;
    return altura;
    }
}
    // inorder
    // niveles
    // altura    
