package lesson1;

import java.util.List;
import java.util.Scanner;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.ArrayList;

public class homework {
    public static void main(String[] args) {
       System.out.println(GetTriangleNumber(4));
       System.out.println(GetFactorial(3));

       for (Integer prime : GetPrimesTo(1000)) {
            System.out.printf("%d ", prime);
       }

       Calculator();
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

    // public static List<Integer> GetPhrimesTo(int n) {
    //     return IntStream.rangeClosed(2, n)
    //       .filter(x -> isPrime(x)).boxed()
    //       .collect(Collectors.toList());
    // }
    // private static boolean isPrime(int number) {
    //     return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
    //       .allMatch(n -> number % n != 0);
    // }

    public static List<Integer> GetPrimesTo(int number)
    {
        var primes = new ArrayList<>(Arrays.asList(1, 2, 3));
              
        for (int i = 4; i < number; i++) {
            int bound = (int)(Math.sqrt((double)i));
            boolean isPrime = true;
            for (Integer prime : primes) {
                if(prime != 1 && prime <= bound && i % prime == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
            {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void Calculator()
    {
        System.out.println("====== calculator ======");
        System.out.print("choose operation (+ - * /): ");

        Scanner sn = new Scanner(System.in);
        var operation = sn.next();
        try
        {
            System.out.print("insert first operand: ");
            var firstOperand = sn.nextDouble();

            System.out.print("insert second operand: ");
            var secondOperarnd = sn.nextDouble();

            double result = 0f;
            if(operation.equals("+"))
            {
                result = firstOperand + secondOperarnd;
            }
            else if(operation.equals("+"))
            {
                result = firstOperand - secondOperarnd;
            }
            else if(operation.equals("+"))
            {
                result = firstOperand * secondOperarnd;
            }
            else if(operation.equals("+"))
            {
                result = firstOperand / secondOperarnd;
            }
            else
            {
                throw new Exception("operation invalid. try again");
            }

            System.out.printf("%.2f %s %.2f = %.2f", firstOperand, operation, secondOperarnd, result);
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
         
    }
}
