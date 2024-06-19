package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import conta.util.Functions;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaController accounts = new ContaController();
        int option, number, agency, type, birthdate;
        String owner;
        double balance, limit, value;



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
            try {
                option = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("\nDigite valores inteiros!");
                sc.nextLine();
                option=0;
            }


            if (option == 9) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                Functions.sobre();
                sc.close();
                System.exit(0);
            }

            switch (option) {
                case 1 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
                    System.out.println("Insira o numero da agencia: ");
                    agency = sc.nextInt();
                    System.out.println("Insira o nome do titular: ");
                    sc.skip("\\R?");
                    owner = sc.nextLine();
                    do {
                        System.out.println("Informe o tipo da conta: (1 - CC ou 2 - CP) ");
                        type = sc.nextInt();
                        if (type < 1 || type > 2) System.out.println("Tipo de conta invalido!");
                    }while (type < 1 || type > 2);

                    System.out.println("Informe o saldo da conta: ");
                    balance = sc.nextDouble();

                    switch (type){
                        case 1 -> {
                            System.out.println("Informe o limite de crédito: ");
                            limit = sc.nextDouble();
                            accounts.register(new ContaCorrente(Functions.generateNumber(),agency,type,owner,balance,limit));
                        }
                        case 2-> {
                            System.out.println("Informe o aniversário da conta: ");
                            birthdate = sc.nextInt();
                            accounts.register(new ContaPoupanca(Functions.generateNumber(),agency,type,owner,balance,birthdate));
                        }

                    }

                    Functions.keyPress();
                }

                case 2 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
                    accounts.listAll();
                    Functions.keyPress();
                }
                case 3 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
                    System.out.println("Informe o numero da conta: ");
                    number = sc.nextInt();
                    accounts.findByNumber(number);
                    Functions.keyPress();
                }
                case 4 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
                    System.out.println("Informe o numero da conta: ");
                    number = sc.nextInt();

                    var account = Functions.searchByNumber(number, accounts.getAccounts());

                    if (account != null) {
                        type = account.getType();
                        System.out.println("Insira o numero da agencia: ");
                        agency = sc.nextInt();
                        System.out.println("Insira o nome do titular: ");
                        sc.skip("\\R?");
                        owner = sc.nextLine();
                        System.out.println("Informe o saldo da conta: ");
                        balance = sc.nextDouble();

                        switch (type) {
                            case 1 -> {
                                System.out.println("Informe o limite de crédito: ");
                                limit = sc.nextDouble();
                                accounts.update(new ContaCorrente(number, agency, type, owner, balance, limit));
                            }
                            case 2 -> {
                                System.out.println("Informe o aniversário da conta: ");
                                birthdate = sc.nextInt();
                                accounts.update(new ContaPoupanca(number, agency, type, owner, balance, birthdate));
                            }

                        }
                    }

                    Functions.keyPress();
                }
                case 5 -> {
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
                    System.out.println("Informe o numero da conta: ");
                    number = sc.nextInt();
                    accounts.delete(number);
                    Functions.keyPress();
                }
                case 6 -> {
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
                    System.out.println("Informe o numero da conta: ");
                    number = sc.nextInt();

                    do {
                        System.out.println("Informe o valor do saque: ");
                        value = sc.nextDouble();
                    }while (value <= 0);
                    accounts.withdraw(number,value);
                    Functions.keyPress();
                }
                case 7 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
                    System.out.println("Informe o numero da conta: ");
                    number = sc.nextInt();
                    do {
                        System.out.println("Informe o valor do deposito: ");
                        value = sc.nextDouble();
                    }while (value <= 0);

                    accounts.deposit(number,value);
                    Functions.keyPress();
                }
                case 8 ->{
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
                    System.out.println("Informe o numero da conta origem: ");
                    number = sc.nextInt();
                    System.out.println("Informe o numero da conta destino: ");
                    int destinationNumber = sc.nextInt();
                    sc.skip("\\R?");

                    do {
                        System.out.println("Informe o valor da transferencia: ");
                        value = sc.nextDouble();
                    }while (value <= 0);
                    accounts.transfer(number,destinationNumber,value);
                    Functions.keyPress();

                }
                default ->{
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    Functions.keyPress();
                }
            }
        }
    }


}
