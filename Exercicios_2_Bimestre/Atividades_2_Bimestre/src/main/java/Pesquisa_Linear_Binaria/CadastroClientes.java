
package Pesquisa_Linear_Binaria;

import Pesquisa_Linear_Binaria.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente:"));
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
        String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento do cliente:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }
    public String listarClientesOrdenados() {
    StringBuilder sb = new StringBuilder();
    sb.append("Clientes ordenados pelo código:\n");

    List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
    Collections.sort(clientesOrdenados, Comparator.comparingInt(Cliente::getCodigo));

    for (Cliente cliente : clientesOrdenados) {
        sb.append("Código: ").append(cliente.getCodigo()).append("\n");
        sb.append("Nome: ").append(cliente.getNome()).append("\n");
        sb.append("Data de Nascimento: ").append(cliente.getDataNascimento()).append("\n");
        sb.append("CPF: ").append(cliente.getCpf()).append("\n\n");
    }

    return sb.toString();
}

    public void ordenarClientesPorCodigo() {
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getCodigo));
        JOptionPane.showMessageDialog(null, "Clientes ordenados pelo código!");
    }

    public void pesquisarCliente() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente a ser pesquisado:"));

        int indice = pesquisaBinaria(codigo);
        if (indice != -1) {
            Cliente cliente = clientes.get(indice);
            String mensagem = "Cliente encontrado:\n\n" +
                    "Código: " + cliente.getCodigo() + "\n" +
                    "Nome: " + cliente.getNome() + "\n" +
                    "Data de Nascimento: " + cliente.getDataNascimento() + "\n" +
                    "CPF: " + cliente.getCpf();
            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }

    private int pesquisaBinaria(int codigo) {
        int inicio = 0;
        int fim = clientes.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Cliente cliente = clientes.get(meio);

            if (cliente.getCodigo() == codigo) {
                return meio;
            } else if (cliente.getCodigo() > codigo) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }
}


