/*
Nome:Gabriel Sales De Lima
RA:00227249

1.Desenvolva um programa que solicite ao usuário para informar a quantidade de números
que irá cadastrar, após solicite para informar os mesmos. Nesse aplicativo deverá ter um menu
para selecionar o tipo de pesquisa que deseja fazer, linear ou binária. Para efetuar a pesquisa
solicite qual número a ser pesquisado, coloque-os em ordem crescente e faça a pesquisa seleciona e
exiba para o usuário o resultado. package Pesquisa_Linar_Binaria;
*/

package Pesquisa_Linear_Binaria.Exercicio01;

    import java.util.Arrays;
import javax.swing.JOptionPane;
    
public class Exercicio01 {

public class PesquisaNumeros {
    private static int[] numeros;

    public static void main(String[] args) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números a serem cadastrados:"));
        numeros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ":"));
        }
        Arrays.sort(numeros);
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:"
                    + "\n1 - Pesquisa linear"
                    + "\n2 - Pesquisa binária\n0 - Sair"));
            switch (opcao) {
                case 1:
                    pesquisaLinear();
                    break;
                case 2:
                    pesquisaBinaria();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "O programa foi encerrado. Obrigado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void pesquisaLinear() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado:"));
        int posicao = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                posicao = i;
                break;
            }
        }
        if (posicao != -1) {
            JOptionPane.showMessageDialog(null, "O número " + numero + " foi encontrado na posição " + posicao + ".");
        } else {
            JOptionPane.showMessageDialog(null, "O número " + numero + " não foi encontrado.");
        }
    }

    private static void pesquisaBinaria() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado:"));
        int posicao = Arrays.binarySearch(numeros, numero);
        if (posicao >= 0) {
            JOptionPane.showMessageDialog(null, "O número " + numero + " foi encontrado na posição " + posicao + ".");
        } else {
            JOptionPane.showMessageDialog(null, "O número " + numero + " não foi encontrado.");
        }
    }
}
    
}