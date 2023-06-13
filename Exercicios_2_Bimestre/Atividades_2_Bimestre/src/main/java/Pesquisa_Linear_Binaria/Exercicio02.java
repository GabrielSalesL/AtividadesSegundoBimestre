/*
Nome:Gabriel Sales De Lima
RA:00227249

2.Crie um aplicativo de cadastro de clientes, deve-se armazenar o código, Nome, data de
nascimento e cpf. Faça com que o usuário informe esses dados, o aplicativo deverá ordenar os
clientes pelo código. Faça com que o aplicativo solicite ao usuário informar o código do cliente
efetue uma pesquisa binária para localizar o cliente e exibir na tela os seus dados.
*/

package Pesquisa_Linear_Binaria;

import javax.swing.JOptionPane;

public class Exercicio02 {
    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();

        boolean sair = false;
        while (!sair) {
            String opcao = JOptionPane.showInputDialog(null,
                    "1 - Cadastrar cliente\n" +
                    "2 - Ordenar clientes pelo código\n" +
                    "3 - Pesquisar cliente\n" +
                    "4 - Exibir clientes ordenados\n" +
                    "5 - Sair\n" +
                    "Escolha uma opção:");

            switch (opcao) {
                case "1":
                    cadastro.cadastrarCliente();
                    break;
                case "2":
                    cadastro.ordenarClientesPorCodigo();
                    break;
                case "3":
                    cadastro.pesquisarCliente();
                    break;
                case "4":
                    String clientesOrdenados = cadastro.listarClientesOrdenados();
                    JOptionPane.showMessageDialog(null, clientesOrdenados, "Clientes Ordenados", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5":
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
