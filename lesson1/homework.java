package lesson1;

public class homework {
    public static void main(String[] args) {
       System.out.println(GetFactorial(3));
    }

    public static int GetTriangleNumber(int bound) 
    {
        return bound * (bound + 1) / 2;
    }

    public static int GetFactorial(int number)
    {
        if(number <= 1)
            return 1;
        return number * GetFactorial(number - 1);
    }
}
