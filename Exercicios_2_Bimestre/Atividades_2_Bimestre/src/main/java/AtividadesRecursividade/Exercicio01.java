/*
Nome:Gabriel Sales De Lima
RA:00227249

1. Desenvolva um método que faça a soma de 0 a 50 
*/


package AtividadesRecursividade;

import javax.swing.JOptionPane;

public class Exercicio01 {

public static void main(String[] args) {
    int soma = somaDeZeroACinquenta();
    JOptionPane.showMessageDialog(null, soma);
}
    public static int somaDeZeroACinquenta() {
    int soma = 0;
    for (int i = 0; i <= 50; i++) {
            soma += i;
    }
    return soma;
}
}
