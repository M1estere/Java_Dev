public class Figures {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 1);
        Rectangle rectangle = new Rectangle(10, 10, 1, 1);
        System.out.println(circle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle);
        System.out.println();
        System.out.println(rectangle);
    }
}

interface Moveable {
    public void move(float dx, float dy);
    public void resize(float koeff);
}

abstract class Figure {
    public float X, Y;

    public abstract float getArea();
    public abstract float getPerimeter();

    public Figure(float x, float y) {
        X = x;
        Y = y;
    }
}

class Rectangle extends Figure implements Moveable {
    private float height;
    private float width;

    public Rectangle(float x, float y, float height, float width) {
        super(x, y);

        this.height = height;
        this.width = width;
    }

    @Override
    public float getArea() {
        return height * width;
    }

    @Override
    public float getPerimeter() {
        return (height * 2) + (width * 2);
    }

    @Override
    public void move(float dx, float dy) {
        X += dx;
        Y += dy;
    }

    @Override
    public void resize(float koeff) {
        height *= koeff;
        width *= koeff;
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle\nCenter: (%.1f, %.1f)\nHeight: %.1f\nWidth: %.1f",
                X + (width / 2), Y + (height / 2), height, width
        );
    }
}

class Circle extends Figure implements Moveable {
    private float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);

        this.radius = radius;
    }

    @Override
    public float getPerimeter() {
        return (float)(2 * Math.PI * radius);
    }

    @Override
    public float getArea() {
        return (float)(Math.PI * Math.pow(radius, 2));
    }

    @Override
    public void move(float dx, float dy) {
        X += dx;
        Y += dy;
    }

    @Override
    public void resize(float koeff) {
        radius *= koeff;
    }

    public String toString() {
        return String.format(
                "Circle\nCenter: (%.1f, %.1f)\nRadius: %.1f",
                X, Y, radius
        );
    }
}