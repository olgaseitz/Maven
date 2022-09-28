package HW4;

public class TriangleFunction {
    public static boolean main(int args )
    {
        double a;

        a = triangleArea(5, 5, 5);
        System.out.println("Треугольник со сторонами 5,5,5 имеет площадь:" + a);

        a = triangleArea(2, 4, 5);
        System.out.println("Треугольник со сторонами 2,4,5 имеет площадь:" + a);

        a = triangleArea(10, 6, 0);
        System.out.println("Треугольник со сторонами 10,6,0 имеет площадь:" + a );

        return false;
    }

    public static double triangleArea( int a, int b, int c )
    {
        double s=(((a+b+c)/2)*((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c));
        return Math.sqrt(s);
    }
}
