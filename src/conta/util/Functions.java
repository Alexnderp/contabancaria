package conta.util;

import java.io.IOException;

public class Functions {
    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por:");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            char c = (char) System.in.read();
            if (Character.isLetterOrDigit(c)) {
                throw new IOException("Você pressionou uma tecla diferente de enter!");
            }
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }

    public static int generateNumber(){
        return (int) (Math.random() * 99999) +1;
    }
}
