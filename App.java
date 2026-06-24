import java.util.Set;

import collections.set.Sets;
import models.Contacto;
import models.Persona;
import structures.trees.BinaryTree;
import structures.trees.IntTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;
import structures.trees.Ejercicio3;
import structures.trees.Ejercicio4;
public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Arbol original");
        System.out.println("Imprimiendo arbol:");
        Ejercicio1 ej1 = new Ejercicio1();
        int[] numeros = {50, 30, 70, 20, 40, 60, 80};
        ej1.insert(numeros);

        BinaryTree<Integer> arbolBinarioMain = new BinaryTree<>();

        for(int n : numeros){
            arbolBinarioMain.insert(n);
        }
        System.out.println("Arbol invertido");
        System.out.println("Imprimiendo arbol");
        Ejercicio2 ej2 = new Ejercicio2();

        ej2.invertRecursively(arbolBinarioMain.getRoot());
        ej2.printTree(arbolBinarioMain.getRoot(), 0);

        //ejercicio 3
        System.out.println("EJERCICIO DE LISTAR NIVELES");
        //Ejercicio3 ej3 = new Ejercicio3();
        //ej3.listLevels(arbolBinarioMain.getRoot());
        ej2.printTree(arbolBinarioMain.getRoot(), 0);
        
        //ejercicio 4
        System.out.println("EJERCICIO CALCULO PROFUNDIDAD MAXIMA");
        Ejercicio4 ej4 = new Ejercicio4();
        ej4.maxDepth(arbolBinarioMain.getRoot());
        ej2.printTree(arbolBinarioMain.getRoot(), 0);
        
        //runIntTree();

        runSets();
    }

    private static void runIntTree() {
        IntTree arbolNumeros = new IntTree(); /// CLASE ARBOL

        // Node<Integer> node3 = new Node<>(30);
        // Node<Integer> node4 = new Node<>(40);
        // Node<Integer> node5 = new Node<>(50);

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
    //person tiene 2 atributos nombre y edad, getters y setters, constructores y to string
    // en app instancia el binary tree de tipo persona 
    //ose BinaryTree person = new Binary Tree("Alice", 30)
    public static void runPersonTree(){
        BinaryTree<Persona> personTree = new BinaryTree<>(); //SI SE las personas no se sabe como se compararán las personas (por edad o nombre)
        personTree.insert(new Persona("Alice", 30));
        personTree.insert(new Persona("Bob", 25));
        personTree.insert(new Persona("Diego", 35));
        personTree.insert(new Persona("Rafael", 35));
        personTree.insert(new Persona("Ana", 35));
        
        //orders
        personTree.preOrder();
        personTree.inOrder();
        personTree.posOrder();
    }

    public static void runSets(){
        Sets sets = new Sets();

        //Primera implementacion: HashSet
        Set<String> hashSet = sets.construirHashSet();
        System.out.println(hashSet);
        System.out.println("Tamaño: " + hashSet.size());
        System.out.println(hashSet.contains("F"));
        //HashSet posee METODO toString

        //Segunda implementacion: LinkedHashSet
        Set<String> linkedHashSet = sets.construirLinkedHashSet();
        System.out.println(linkedHashSet);
        System.out.println("Tamaño: " + linkedHashSet.size());
        System.out.println(linkedHashSet.contains("B"));

        //entre ambas no hay diferencia, hacen lo mismo
        //pero si imprimimos varias veces en hashSet
        //va a imprimir en diferente orden [B, A, C, D]

        //este se diferencia de LinkedHashSet porque
        //porque LinkedHashSet establece un orden de SIEMPRE
        //sin cambiar para todos los elementos
        Set<String> treeHashSet = sets.construirLinkedHashSet();
        System.out.println(treeHashSet); //compara solo el primer caracter
        System.out.println("Tamaño: " + treeHashSet.size());
        System.out.println(treeHashSet.contains("B"));
        //compara unicamente el primer caracter, si tengo 1Ggggggee compara el valor del 1 que en 
        //en ASCII es menor que el valor del A

        //si los caracteres son iguales se pasa al siguiente caracter
        // 1 -->
        // G
        // g
        // g
        // g
        // g
        // g
        // e
        // e
        System.out.println("TreSet");
        Set<Contacto> trrSet = sets.construirTreeSetConComparador();
        System.out.println(trrSet); //compara solo el primer caracter
        System.out.println(trrSet.size());

        System.out.println("TreSet con COMPARACION");
        Set<Contacto> trrCompSet = sets.construirTreeSetConComparador();
        System.out.println(trrCompSet);
        System.out.println(trrCompSet.size());

        //ingresaron los 6 hashCode, cada uno posee un HASHCODE DIFERENTE
        //como tienen HASHCODE diferente, se agregan todos porque
        //porque si bien son lo mismo tienen direcciones diferentes
    }
}
