
class Animal {
    String name;
    int age;
    String type;

  
    Animal(String n, int a, String t) {
        name = n;
        age = a;
        type = t;
    }
}

class Herbivore extends Animal {
    Herbivore(String name, int age, String type) {
        super(name,age,type);
    }
   
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Type: " + type);
    }
}


class Carnivore extends Animal {
    Carnivore(String name, int age, String type) {
        super(name,age,type);
    }
      
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Type: " + type);
    }
}

public class inher {
    public static void main(String[] args) {
        Herbivore h = new Herbivore("Deer", 21, "Herbivore");
        Carnivore c = new Carnivore("Tiger", 24, "Carnivore");

        h.displayDetails();
        System.out.println(); 
        c.displayDetails();
    }
}



