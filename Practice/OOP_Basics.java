import java.util.Arrays;

public class Main2 {
    static {
        System.out.println("Before starting main function: Test\n");
    }

    public static void main(String[] args) {
        int n = 5;
        Fraction[] a = new Fraction[n];

        for (int i = 1; i <= n; i++) {
            a[i - 1] = new Fraction(1, i);
        }

        System.out.printf("1. ");
        for (Fraction f: a) {
            f.print();
            System.out.print("; ");
        }

        System.out.printf("\n2. ");
        Time time = new Time(182);
        System.out.printf(time.toString());

        System.out.printf("\n3. ");
        GraphPoint p = new GraphPoint(500f, 300f);
        p.draw();

        System.out.printf("\n4. ");
        float[] x = {100f, 200f, 200f, 100f}, y = {100f, 100f, 200f, 200f};

        Polygon t = new Polygon(x, y);
        Polygon t2 = new Polygon(t);

        t2.rotate(45.0f);
        t.draw(); t2.draw();

        System.out.printf("5. ");
        GroundhogDate date = new GroundhogDate();
        System.out.printf(date.toString());

        System.out.printf("\n6. ");
        MyClass obj1 = new MyClass(), obj2 = new MyClass();
        obj1.f();
        obj2.f();
        obj1.f();

        System.out.printf("\n7. ");
        MyClass1 o1 = new MyClass1(), o2 = new MyClass1();
        System.out.println(MyClass1.countObj());

        System.out.printf("8. ");
        System.out.printf(Duplicator.str("Test"));

        System.out.printf("\n9. ");
        Time1 ti = new Time1(3661);
        System.out.printf(ti.toString());

        System.out.printf("10. ");
        Person per = new Person("Test", 3);
        System.out.println(per);
        per.setAge(5);
        per.setName("Vasya");
        System.out.println(per);
        System.out.println(per.work());
        Employee e = new Employee("1", 2, "3");
        System.out.println(e);
        System.out.println(e.work());
    }
}

class Fraction {
    private int ch;
    private int znam;

    public Fraction(int ch, int znam) {
        this.ch = ch;
        this.znam = znam;
    }

    public void print() {
        System.out.printf("%d/%d", ch, znam);
    }
}

class Time {
    int hour, min;

    public Time(int min) {
        hour = min / 60;

        this.min = ( min - (hour * 60) );
    }

    @Override
    public String toString() {
        return hour + ":" + min;
    }
}

class Point {
    float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

class GraphPoint extends Point {
    public GraphPoint(float x, float y) {
        super(x, y);
    }

    public void draw() {
        System.out.printf("Drawn at %d, %d!\n", (int)x, (int)y);
    }
}

class Polygon {
    float[] x, y;

    public Polygon(float[] x, float[] y) {
        this.x = x;
        this.y = y;
    }

    public Polygon(Polygon polygon) {
        this.x = polygon.x.clone();
        this.y = polygon.y.clone();
    }

    public void draw() {
        System.out.printf("Drawn!\n");
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));
        System.out.println("--------------------");
    }

    public void rotate(float deg) {
        System.out.printf("Rotated on %f degrees!\n", deg);

        for (int i = 0; i < x.length; i++) x[i] += deg;
        for (int i = 0; i < y.length; i++) y[i] += deg;
    }
}

class GroundhogDate {
    private int day;
    private String month;

    public GroundhogDate() {
        day = 2;
        month = "Feb";
    }

    @Override
    public String toString() {
        return month + " " + day;
    }
}

class MyClass {
    private static int count = 0;

    public void f() {
        count++;
        System.out.print(count + " ");
    }
}

class MyClass1 {
    private static int count = 0;

    public MyClass1() {
        count++;
    }

    public static int countObj() {
        return count;
    }
}

class Test {
    private Test() {

    }

    static void s() {

    }
}

class Duplicator {
    public static String str(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(string);
        stringBuilder.append(string);

        return stringBuilder.toString();
    }
}

class Time1 {
    int hour, min, sec;

    public Time1(int sec) {
        hour = sec / 3600;
        sec %= 3600;

        min = sec / 60;
        sec %= 60;

        this.sec = sec;
    }

    @Override
    public String toString() {
        return hour + ":" + min + ":" + sec;
    }
}

class Person {
    public int Age;
    public String Name;

    public Person(String name, int age) {
        Name = name;
        Age = age;
    }

    public void setAge(int newAge) {
        Age = newAge;
    }

    public void setName(String newName) {
        Name = newName;
    }

    public String work() {
        return "None";
    }

    @Override
    public String toString() {
        return String.format("(%s, %d)", Name, Age);
    }
}

class Employee extends Person {
    private String company;

    public Employee(String name, int age, String company) {
        super(name, age);

        this.company = company;
    }

    @Override
    public String work() {
        return "Manager";
    }

    @Override
    public String toString() {
        return String.format("(%s, %d, %s)", Name, Age, company);
    }
}