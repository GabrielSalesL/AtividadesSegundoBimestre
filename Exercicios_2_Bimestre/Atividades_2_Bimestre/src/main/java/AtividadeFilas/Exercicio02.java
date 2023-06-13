/*
Nome:Gabriel Sales De Lima
RA:00227249

2.Um banco necessita de uma sistema para controlar a fila de pagamentos no caixa.
Para o atendimento é obedecido a lei de prioridade, onde a cada 2 clientes prioritários,
um cliente normal é atendido. Desenvolva um algoritmo para controlar a fila de
atendimento, para isso deverá ser criado 2 filas, uma de atendimento prioritário e outra
de atendimento normal. Na fila será cadastrado os seguintes dados do cliente:
Cliente
- int senha;
- String nome;
- int anoNascimento;
Deverá ser determinado pela a idade qual fila será inserido o cliente, acima de 65 anos
fila prioritária, os demais na fila normal. Crie um menu com uma opção para adicionar o
cliente, e outra para chamar o cliente. Lembre-se deverá seguir a regra de ao ser
atendido 2 clientes prioritários será atendido um cliente normal. 
*/
package AtividadeFilas;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Exercicio02 {
    private static LinkedList<Cliente> filaPrioritaria = new LinkedList<>();
    private static LinkedList<Cliente> filaNormal = new LinkedList<>();
    private static int atendimentosPrioritarios = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção: "
                    + "\n1 - Adicionar cliente "
                    + "\n2 - Chamar cliente "
                    + "\n0 - Sair"));
            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    chamarCliente();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void adicionarCliente() {
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente:"));
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        int senha = (int) (Math.random() * 1000);
        Cliente novoCliente = new Cliente(senha, nome, idade);
        if (idade >= 65) {
            filaPrioritaria.add(novoCliente);
        } else {
            filaNormal.add(novoCliente);
        }
        JOptionPane.showMessageDialog(null, "Cliente " + novoCliente.getNome() + " adicionado à fila.");
    }

    private static void chamarCliente() {
        if (!filaPrioritaria.isEmpty()) {
            Cliente proximoCliente = filaPrioritaria.removeFirst();
            atenderCliente(proximoCliente);
        } else if (!filaNormal.isEmpty() && atendimentosPrioritarios % 2 == 0) {
            Cliente proximoCliente = filaNormal.removeFirst();
            atenderCliente(proximoCliente);
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes na fila.");
        }
    }

    private static void atenderCliente(Cliente cliente) {
        JOptionPane.showMessageDialog(null, "Atendendo o cliente " + cliente.getNome() + " (senha " + cliente.getSenha() + ").");
        if (cliente.getIdade() >= 65) {
            atendimentosPrioritarios++;
        }
    }
}

class Cliente {
    private int senha;
    private String nome;
    private int idade;

    public Cliente(int senha, String nome, int idade) {
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}