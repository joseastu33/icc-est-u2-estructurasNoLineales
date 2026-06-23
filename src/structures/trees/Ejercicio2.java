package structures.trees;
import structures.node.Node;
public class Ejercicio2 {
    
    //imprimir arbol
    public void printTree(Node<Integer> root, int nivel){
        if(root == null){
            return;
        }
        System.out.println("Arbol original");
        System.out.println("Imprimiendo el árbol:");

        printTree(root.getRight(), nivel+1);
        //
        for(int i = 0; i < nivel; i++) {
            System.out.println("\t");
        }

        System.out.println(root.getValue());
        printTree(root.getLeft(), nivel+1);
    }

    //invertir de forma recursiva
    public Node<Integer> invertRecursively(Node<Integer> root){
        if(root == null){
            return null;
        }
        //el recorrido para intercambiar los hijos es el postOrder 
        //el post order primero visita el derecho luego el izquierdo

        //primero hago el metodo, luego comienzo a llamar
        printTree(root, 0);

        Node<Integer> aux = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(aux); //la derecha no se pierne

        invertRecursively(root.getLeft());
        invertRecursively(root);
        invertRecursively(root.getRight());

        return root;
    }
}
