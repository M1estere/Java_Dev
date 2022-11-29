public class Inheritance {
    public static void main(String[] args) {
        Animal cat = new Cat();
        System.out.println(cat.speak());

        Circle1 circle1 = new Circle1();
        System.out.println(circle1.draw());

        X x = new Y();
        System.out.println(x.fun());
    }
}

class Pet {
    public String Name;

    public Pet(String name) {
        Name = name;
    }

    public void say() {
        System.out.println("Saying");
    }
    public void walk() {
        System.out.println("Walking");
    }
    public void move() {
        System.out.println("Moving");
    }
}

class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void say() {
        System.out.println("Bark");
    }

    @Override
    public void walk() {
        System.out.println("Dog is walking");
    }
}

class GameChar {
    public String CharName;

    public GameChar(String charName) {
        CharName = charName;
    }

    public void attack() { }
    public void horseride() { }
    public void run() { }
}

class Cowboy extends GameChar {
    public Cowboy(String charName) {
        super(charName);
    }

    @Override
    public void attack() { }

    @Override
    public void horseride() { }
}

abstract class Animal {
    public abstract String speak();
}

class Cat extends Animal {
    @Override
    public String speak() {
        return "Meow";
    }
}

abstract class Figure1 {
    public abstract String draw();
}

class Circle1 extends Figure1 {
    @Override
    public String draw() {
        return "draw_circle";
    }
}

abstract class Animal1 {
    public abstract String speak();
}

class Cat1 extends Animal1 {
    public String speak() {
        return "Miy";
    }
}

class Dog1 extends Animal1 {
    public String speak() {
        return "Gav";
    }
}

class X {
    int fun() {
        return 1;
    }
}

class Y extends X {
    int fun() {
        return 1;
    }
}