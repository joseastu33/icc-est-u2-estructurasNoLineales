package structures.trees;
import structures.node.Node;

public class Ejercicio4 {
    
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        //profundidad de cada lado
        int profundidadIzquierda = maxDepth(root.getLeft());
        int profundidadDerecha = maxDepth(root.getRight());

        //se ocupa la idea de la profundidad de ejercicios anteriores
        return Math.max(profundidadIzquierda, profundidadDerecha) + 1;
    }
}
