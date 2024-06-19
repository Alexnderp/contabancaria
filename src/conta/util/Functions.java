package conta.util;

import conta.model.Conta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por:");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        String line;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
             line = scanner.nextLine();
            if (!line.trim().equals("")) {
                try {
                    throw new IOException("Você pressionou uma tecla diferente de enter!");
                } catch (IOException e) {
                    System.out.println("Você pressionou uma tecla diferente de enter!");
                }
            }
        }while (!line.trim().equals(""));
    }

    public static int generateNumber(){
        return (int) (Math.random() * 99999) +1;
    }

    public static Conta searchByNumber(int number, ArrayList<Conta> accounts){
        Conta result = accounts.stream().filter(account -> account.getNumber() == number)
                .findAny()
                .orElse(null);
        return result;
    }
}
