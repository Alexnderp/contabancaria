package conta;

import conta.model.Conta;
import conta.util.Cores;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
        c1.view();
        c1.withdraw(12000.0f);
        c1.view();
        c1.deposit(5000.0f);
        c1.view();


        int option;
        while (true){
            System.out.printf("""
                    %s%s*********************************************************
                    
                                        Generation Bank
                    
                    *********************************************************
                    
                                   1 - Criar conta
                                   2 - Listar Todas as Contas
                                   3 - Buscar Conta Por Número
                                   4 - Atualizar Dados da Conta
                                   5 - Apagar Conta
                                   6 - Sacar
                                   7 - Depositar
                                   8 - Transferir valores entre Contas
                                   9 - Sair
                    *********************************************************
                    Entre com a opção desejada:
                    %s
                    
                    """, Cores.TEXT_YELLOW, Cores.ANSI_BLACK_BACKGROUND, Cores.TEXT_RESET);

            option = sc.nextInt();

            if (option == 9) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                sobre();
                sc.close();
                System.exit(0);
            }

            switch (option) {
                case 1:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

                    break;
                case 2:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");

                    break;
                case 3:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");

                    break;
                case 4:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

                    break;
                case 5:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

                    break;
                case 6:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

                    break;
                case 7:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

                    break;
                case 8:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por:");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }
}
