public class OOP {
    public static final String MY_CONST = "Hello";

    public static void main(String[] args) {
        String s1 = "Java";
        System.out.println(new StringBuffer(s1).reverse());

        MarkBook m = new MarkBook(new int[] {5, 2, 3, 5});
        m.print();
    }
}

class Person1 {
    public String name;
    public int age;
}

class Employee1 extends Person1 {
    public String company;

    void work() { }
    void relax() { }
}

abstract class Animal2 {
    public abstract String eat();
}

class Dog2 extends Animal2 {
    @Override
    public String eat() {
        return "Bone";
    }
}

interface Drawable {
    public void draw();
}

class MyClass3 implements Drawable {
    public boolean drawing = false;

    @Override
    public void draw() { }

    public void start() { }
    public void stop() { }
}

class MarkBook {
    int[] marks;
    double averageGrade;

    public MarkBook(int[] marks) {
        this.marks = marks;

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        averageGrade = (double)(sum) / marks.length;

        if (marks.length == 0) averageGrade = 0;
    }

    public void print() {
        if (marks.length == 0) {
            System.out.println("No data");
        } else {
            for (int mark : marks) {
                System.out.print(mark + " ");
            }
            System.out.println();
        }
        System.out.println("Average: " + averageGrade);
    }
}

class Shape1 {
    public double area() {
        return 0;
    }
}

class Rectangle1 extends Shape1 {
    private double length;
    private double width;

    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() { return length; }
    public double getWidth() { return width; }

    @Override
    public double area() {
        return length * width;
    }
}

interface Shape3 {
    public double getArea();
}

