/*
Nome:Gabriel Sales De Lima
RA:00227249

2. Desenvolva um método que o usuário informe um número e calcule o fatorial desse numero
Fórmula fatorial: n! = n . (n - 1)!

*/

package AtividadesRecursividade;

import javax.swing.JOptionPane;

public class Exercicio02 {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número inteiro não negativo:");
        int numero = Integer.parseInt(input);
        
        long fatorial = calcularFatorial(numero);
        JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + fatorial);
    }
    
    public static long calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}


