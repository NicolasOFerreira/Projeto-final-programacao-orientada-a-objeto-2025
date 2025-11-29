import dao.DAO;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;
import model.Pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DAO<Cliente> clienteDAO = new DAO<>(Cliente.class);
        DAO<Veiculo> veiculoDAO = new DAO<>(Veiculo.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== SISTEMA LOCADORA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Veículo");
            System.out.println("4 - Listar Veículos");
            System.out.println("5 - Demonstrar Polimorfismo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    clienteDAO.inserir(new Cliente(nome, cpf));
                    System.out.println("Cliente cadastrado.");
                    break;

                case 2:
                    System.out.println("=== Clientes ===");
                    clienteDAO.listar().forEach(c ->
                            System.out.println(c.getId() + " - " + c.getNome()));
                    break;

                case 3:
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    veiculoDAO.inserir(new Veiculo(modelo, placa));
                    System.out.println("Veículo cadastrado.");
                    break;

                case 4:
                    System.out.println("=== Veículos ===");
                    veiculoDAO.listar().forEach(v ->
                            System.out.println(v.getId() + " - " + v.getModelo()));
                    break;

                case 5:
                    Pessoa p1 = new Cliente("Eduardo", "763");
                    Pessoa p2 = new Funcionario("Rafaela", "251", 3000);
                    System.out.println("Tipo p1: " + p1.getTipo());
                    System.out.println("Tipo p2: " + p2.getTipo());
                    break;

                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}