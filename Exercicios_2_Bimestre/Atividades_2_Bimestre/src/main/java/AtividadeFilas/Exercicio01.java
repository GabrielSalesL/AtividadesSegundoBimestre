/*
Nome:Gabriel Sales De Lima
RA:00227249

1.Uma clínica precisa de um sistema para organizar a fila de pacientes, para cada dia
é disponibilizado 20 senhas para consulta. Eles necessitam de um sistema onde é
informado o nome do paciente em ordem de chegada e uma opção para chamar o
próximo paciente. Desenvolva um algoritmo de Fila, contendo um menu com as
opções: 1 - Adicionar paciente, 2 - Chamar próximo paciente. A opção 1 deverá exibir
um campo para informar o nome do paciente assim que ele chega no consultório, e a
opção 2, ao selecionar deverá exibir o nome do próximo paciente na fila. 
*/
package AtividadeFilas;

import javax.swing.JOptionPane;

public class Exercicio01 {
    private static String[] pacientes = new String[20];
    private static int fimFila = 0;
    private static int inicioFila = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Adicionar novo paciente\n"
                    + "2 - Chamar próximo paciente\n"
                    + "0 - Sair"));
            switch (opcao) {
                case 1:
                    if (fimFila < pacientes.length) {
                        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
                        pacientes[fimFila] = nome;
                        fimFila++;
                        JOptionPane.showMessageDialog(null, "Paciente " + nome + " colocado na fila");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila Cheia!!");
                    }
                    break;
                case 2:
                    if (inicioFila < fimFila) {
                        String proximoPaciente = pacientes[inicioFila];
                        inicioFila++;
                        JOptionPane.showMessageDialog(null, "Próximo paciente da fila: " + proximoPaciente);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há pacientes na fila.");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "O programa foi encerrado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }
}