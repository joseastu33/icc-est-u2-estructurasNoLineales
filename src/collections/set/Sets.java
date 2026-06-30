package collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import models.Contacto;

public class Sets  {
    public Sets() {
        
    }
    public Set<String> construirLinkedHashSet(){
         Set<String> linkedHashSet = new LinkedHashSet<>(); //set de tipo HashSet
         linkedHashSet.add("A");
         linkedHashSet.add("B");
         linkedHashSet.add("C");
         linkedHashSet.add("D");
         linkedHashSet.add("A");
         //csolo por colocar de un LinkedHashSet y no un HashSet ya hace algo distinto


        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("D");
        linkedHashSet.add("E");
        linkedHashSet.add("F");
        linkedHashSet.add("1Ggggggeegeg");
        linkedHashSet.add("2G2gggggeegeg");
        linkedHashSet.add("3Gggggeegeg");
        linkedHashSet.add("4Ggggggeegeg");
        linkedHashSet.add("5Ggggggeegeg");
        linkedHashSet.add("5Ggggggeegeg");
        linkedHashSet.add("6Ggggggeegeg");
        linkedHashSet.add("G7gggggeegeg");
         return linkedHashSet;

    }
    public void construirTreeSet(){
        Set<String> tSet = new TreeSet<>(); //set de tipo HashSet
        tSet.add("A");
        tSet.add("B");
        tSet.add("C");
        tSet.add("D");
        tSet.add("A");
 
    }
    public Set<Contacto> construirTreeSetConComparador((c1, c2) -> { 
        return c1.getNombre().compareTo(c2.getNombre());})    
    {
        //Set<Contacto> trrSet = new TreeSet<>((c1, c2) -> { 
            //se puede mandar FUNCIONES también al CONSTRUCTOR
            //return c1.getNombre().compareTo(c2.getNombre());}); //Es una funcion comparador
            
            //es una FUNCION FLECHA
            //una FUNCION FLECHA no tiene TIPO DE RETORNO ni NOMBRE, solo RETORNA DIRECTAMENTE
            //ingresa el primer contacto y se COLOCA en la raiz
            //para compararr nombres se hace compareTo 
            //si existe otro Juan peroc on apellido   
            Set<Contacto> trrSet = new TreeSet<>();
            //implementar
        trrSet.add(new Contacto("Juan", "Perez", "123456789"));
        trrSet.add(new Contacto("Ana", "Gomez", "987654321"));
        trrSet.add(new Contacto("Pedro", "Lopez", "456789123"));
        trrSet.add(new Contacto("Maria", "Rodriguez", "789123456"));
        trrSet.add(new Contacto("Juan", "Perez", "123456789")); // Duplicado, no se agregará
        trrSet.add(new Contacto("Juan", "Lopez", "123456789")); // Duplicado, no se agregará

        return trrSet;
    }
    public Set<String> construirHashSet(){
        Set<String> hashSet = new HashSet<>(); //set de tipo HashSet
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add("A"); // esta ya no la añade porque observa que el hashcode de la anterior A ya está


        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("A");
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("F");
        hashSet.add("1Ggggggeegeg");
        hashSet.add("2G2gggggeegeg");
        hashSet.add("3Gggggeegeg");
        hashSet.add("4Ggggggeegeg");
        hashSet.add("5Ggggggeegeg");
        hashSet.add("5Ggggggeegeg");
        hashSet.add("6Ggggggeegeg");
        hashSet.add("G7gggggeegeg");
        
        return hashSet;
    }
    public Set<Contacto> construirHashSet(){
        Set<Contacto> hashSet = new HashSet<>(); //set de tipo HashSet
        Contacto c1 = new Contacto("Juan", "Perez", "123456789");
        Contacto c2 = new Contacto("Ana", "Gomez", "987654321");
        Contacto c3 = new Contacto("Pedro", "Lopez", "456789123");
        Contacto c4 = new Contacto("Maria", "Rodriguez", "789123456");
        Contacto c5 = new Contacto("Juan", "Perez", "123456789"); // Duplicado, no se agregará
        Contacto c6 = new Contacto("Juan", "Lopez", "123456789"); // Duplicado, no se agregará
        System.out.println("Contacto c1: " + c1.hashCode());
        System.out.println("Contacto c5: " + c5.hashCode());
        hashSet.add(c1);
        hashSet.add(c2);
        hashSet.add(c3);
        hashSet.add(c4);
        hashSet.add(c5);
        hashSet.add(c6);

        return hashSet;
        //usa la referencia de memoria y me da un HashCode

    }


}
