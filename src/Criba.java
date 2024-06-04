import java.util.Scanner;

public class Criba {
    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Vector vacío
        }

        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        for (int i = 2, j = 0; i <= max; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        teclado.close();

        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 1; i <= dato; i++) {
            if ((i - 1) % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }

        int[] primos = generarPrimos(dato);

        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < primos.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(primos[i] + "\t");
        }
    }
}