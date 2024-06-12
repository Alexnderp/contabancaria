package conta.model;

import conta.util.Cores;

public class Conta {
    private int number;
    private int agency;
    private int type;
    private String owner;
    private double balance;

    public Conta(int number, int agency, int type, String owner, double balance) {
        this.number = number;
        this.agency = agency;
        this.type = type;
        this.owner = owner;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double value) {

        if(this.getBalance() < value) {
            System.out.println("\n Saldo Insuficiente!");
            return false;
        }

        this.setBalance(this.getBalance() - value);
        return true;
    }

    public void deposit(float value) {

        this.setBalance(this.getBalance() + value);

    }

    public void view() {

        String type = "";

        switch(this.type) {
            case 1:
                type = "Conta Corrente";
                break;
            case 2:
                type = "Conta Poupança";
                break;
        }

        System.out.printf("""
                \n\n%s%s***********************************************************
                Dados da Conta:
                ***********************************************************
                Numero da Conta: %d
                Agência: %d
                Tipo da Conta: %s
                Titular: %s
                Saldo: %.2f
                """, Cores.ANSI_BLACK_BACKGROUND,Cores.TEXT_YELLOW,this.number, this.agency, type, this.owner, this.balance);

    }
}
