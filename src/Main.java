package first_block.src;


import static java.lang.Math.*;


public class Main {
    public static void main(String[] args) {
        // task 1
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

//        // task 2
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        // task 3
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        // task 4
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        // task 5
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        // task 6
        System.out.println(howManyItems(22, 1.4f, 2f));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2f, 2f));

        // task 7
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        // task 8
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        // task 9
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        // task 10
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));




    }

    // task 1
    public static float convert(int x) {
        return x * 3.785f;
    }

    // task 2
    public static int fitCalc(int calories, int intensity) {
        return calories * intensity;
    }

    // task 3
    public static int containers(int con1, int con2, int con3) {
        return con1*20 + con2*50 + con3*100;
    }

    //task 4
    public static java.lang.String triangleType(int X, int Y, int Z) {
        if (X + Y > Z && X + Z > Y && Y + Z > X) {
            if (X == Y && X == Z) {
                return "isosceles";
            } else if (X == Y || Y == Z || X == Z) {
                return "equilateral";
            } else if (pow(max(X, max(Y, Z)), 2) == pow(min(X, min(Y, Z)), 2) + pow(max(min(X, Y), min(max(X,Y),Z)), 2)){
                return "different-sided";
            } else {return "triangle";}
        } else {
            return "not a triangle";
        }
    }

    // task 5
    public static int ternaryEvaluation(int a, int b) {
        return (a>b) ? a: b;
    }

    // task 6
    public static int howManyItems(int S, float x, float y) {
        return (int) (S/(2*(x+y)));
    }

    // task 7
    public static int factorial(int x) {
        int result = 1;

        for (int i = 1; i<=x; i++) {
            result *= i;
        }
        return result;

    }

    // task 8
    public  static int gcd(int x, int y) {
        int result = 1;
        int i;
        for (i = 1; i <= Math.min(x, y); i++) {
            if (x%i == 0 && y%i == 0) {
                result = i;
            }
        }
        return result;
    }

    // task 9
    public static  int ticketSaler(int ticket_count , int ticket_price) {
        float commission = 0.72f;
        return (int) (ticket_count * ticket_price * commission) ;
    }

//    // task 10
    public static int tables(int studs, int tables) {
        int s = studs - 2 * tables;
        int result = (int) Math.ceil((double) Math.max(0, s) / 2);
        return result;
    }
}