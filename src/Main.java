

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final PessoaService pessoaService = new PessoaService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            mostrarMenu();
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    listarPessoas();
                    break;
                case 3:
                    alterarPessoa();
                    break;
                case 4:
                    excluirPessoa();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Cadastro de Pessoas");
        System.out.println("1. Adicionar Pessoa");
        System.out.println("2. Listar Pessoas");
        System.out.println("3. Alterar Pessoa");
        System.out.println("4. Excluir Pessoa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarPessoa() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        pessoaService.adicionarPessoa(nome, idade);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    private static void listarPessoas() {
        List<cadastro.Pessoa> pessoas = pessoaService.listarPessoas();
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (cadastro.Pessoa pessoa : pessoas) {
                System.out.println();
            }
        }
    }

    private static void alterarPessoa() {
        System.out.print("Digite o ID da pessoa a ser alterada: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a nova idade: ");
        int novaIdade = Integer.parseInt(scanner.nextLine());
        boolean sucesso = pessoaService.alterarPessoa(id, novoNome, novaIdade);
        if (sucesso) {
            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }

    private static void excluirPessoa() {
        System.out.print("Digite o ID da pessoa a ser excluída: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean sucesso = pessoaService.excluirPessoa(id);
        if (sucesso) {
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }
}
