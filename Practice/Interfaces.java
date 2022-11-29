public class Interfaces {
    public static void main(String[] args) {

    }
}

interface Vehicle {
    int maxVelocity = 0;

    void accelerate(int speed);
    void brake();
    void horn();
}

interface Message {
    int maxSize = 0;

    void send();
    void delete(int index);
    String read(int index);
}

interface Character {
    int maxDamage = 0;
    int maxArmor = 0;

    void attack(Character[] characters);
    void destroy();
}

interface Electrical {
    int maxVoltage = 0;
    int maxPower = 0;

    void on();
    void off();
}

interface Liveable {
    boolean isLive = true;

    String breathe();
    String reproduction();
    String feed(Liveable[] organisms);
}

interface Runnable {
    public void run();
}

class MyClass2 implements Runnable {
    public boolean running = false;

    public void start() { }
    public void stop() { }

    @Override
    public void run() { }
}

interface Numerical {
    public void set(Number number);
}

class MyInteger implements Numerical {
    public boolean big = false;

    public void clear() { }

    @Override
    public void set(Number number) { }
}

interface Unknowable {
    public boolean isNotKnown = true;
    public void set(Number number);
    public void delete();
}

class MyKnow implements Unknowable {
    public String name;
    public void print() { }

    @Override
    public void delete() { }

    @Override
    public void set(Number number) { }
}