
public class Main {

    public static void main(String[] args) {
        // you can test how your classes work here
        Dog dog = new Dog();
        dog.bark();
        dog.eat();

        Dog fido = new Dog("Fido");
        fido.bark();
        
        System.out.println("");
        
        Cat cat = new Cat();
        cat.purr();
        cat.eat();

        Cat garfield = new Cat("Garfield");
        garfield.purr();
        
        System.out.println("");
        
        NoiseCapable doge = new Dog();
        doge.makeNoise();

        NoiseCapable cato = new Cat("Garfield");
        cato.makeNoise();
        Cat c = (Cat) cato;
        c.purr();
    }

}
