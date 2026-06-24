package models;

public class Persona implements Comparable<Persona>{
    //cuando creo la clase que va a implementar otra clase hace implements
    //toda clase 
    private String name;
    private int age;

    public Persona() {
    }

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona [name=" + name + ", age=" + age + "]";
    }
    //metodo se OCUPA FRECUENTEMENTE
    @Override //OVERRIDEA porque compareTo()
    public int compareTo(Persona otra) {
        //devuelve un numero negativo si la persona que esta en la instancia es mayor que la persona que llega como argumento
        //return this.name.compareTo(otra.getName());
        int compAge =  Integer.compare(this.age, otra.getAge());  //nuevo metodo del Integer: compare
        //comparo edades, si la edad es mayor debe ir a la izquierda

        if(compAge != 0) return compAge; 
        //si llegan dos personas con la misma edad, comparo la edad
        return this.name.compareTo(otra.getName());
    }
    //toda clase a implementar en el arbol tiene que tener su criterio de comparacion compareTo
    //este metodo indica si se va a la derecha o a la izquierda
    //entre JUAN y BOB, Juan ES EL MAYOR, como es mayor va  la derecha



}

    
