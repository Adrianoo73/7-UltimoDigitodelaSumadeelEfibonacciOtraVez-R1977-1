import java.util.Scanner;

public class FibonacciPartialSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Leer entrada del usuario
        System.out.print("INGRESA EL PRIMER DIGITO: ");
        long m = scanner.nextLong(); // Leer valor de m
        System.out.print("INGRESA EL PRIMER DIGITO: ");
        long n = scanner.nextLong(); // Leer valor de n
        scanner.close(); // Cerrar el Scanner

        // Obtener el último dígito de la suma parcial de Fibonacci
        int lastDigit = getFibonacciPartialSumLastDigit(m, n);
        System.out.println("EL RESULTADO ES: " + lastDigit); // Imprimir el resultado
    }

    // Método para obtener el último dígito de la suma parcial de Fibonacci
    public static int getFibonacciPartialSumLastDigit(long m, long n) {
        // Reducir m+1 y n+2 usando el período Pisano mod 10 que es 60
        int reducedM = (int) ((m + 1) % 60);
        int reducedN = (int) ((n + 2) % 60);

        // Calcular Fibonacci mod 10 para los valores reducidos
        int fibNplus2 = calculateFibonacciMod(reducedN); // F(n+2) mod 10
        int fibMplus1 = calculateFibonacciMod(reducedM); // F(m+1) mod 10

        // Restar los dos resultados y ajustar el valor en [0, 9]
        int result = (fibNplus2 - fibMplus1 + 10) % 10;

        return result;
    }

    // Método para calcular Fibonacci(n) mod 10
    public static int calculateFibonacciMod(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (previous + current) % 10;
            previous = current;
            current = temp;
        }

        return current;
    }
}