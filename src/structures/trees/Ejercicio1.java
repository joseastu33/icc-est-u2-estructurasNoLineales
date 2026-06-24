package structures.trees;
import structures.node.Node;

public class Ejercicio1 {
    
    public void insert(int[] numeros){
        //crear un arbol BST = instanciar BinaryTree
        //inserar los numeros en el arbol
        //imprimir el arbol
        //la impresión del arbol es el reto
        BinaryTree<Integer> arbolBinario = new BinaryTree<>();
        for(int n : numeros){
            arbolBinario.insert(n);
        }
        printTree(arbolBinario.getRoot(), 0);
    }

    public void printTree(Node<Integer> root, int nivel){
        if(root == null){
            return;
        }
        printTree(root.getRight(), nivel+1);
        //cada cantidad de nivel se le coloca el tabulado
        for(int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }

        System.out.println(root.getValue());
        printTree(root.getLeft(), nivel+1);
    }

}
