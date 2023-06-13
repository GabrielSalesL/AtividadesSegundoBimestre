/*
Nome:Gabriel Sales De Lima
RA:00227249

3 - Desenvolva um método que mostre a sequência Fibonacci de um número. 
Sequencia Fibonacci: 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 
987, 1597, 2584, ...

*/

package AtividadesRecursividade;


import java.util.Scanner;

public class Exercicio03 {


    
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        
        System.out.println("Sequência Fibonacci de " + numero + ":");
        for (int i = 0; i <= numero; i++) {
            System.out.print(calcularFibonacci(i) + " ");
        }
    }
    
    public static int calcularFibonacci(int numero) {
        if (numero == 0) {
            return 0;
        } else if (numero == 1) {
            return 1;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}

 