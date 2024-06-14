package conta.model;

public class ContaCorrente extends Conta {

    private double limit;

    public ContaCorrente(int number, int agency, int type, String owner, double balance, double limit) {
        super(number, agency, type, owner, balance);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean withdraw(double value) {

        if(this.getBalance()+this.getLimit() < value) {
            System.out.println("\n Saldo Insuficiente!");
            return false;
        }

        this.setBalance(this.getBalance() - value);
        return true;
    }

    @Override
    public void view() {
        super.view();
        System.out.println("Limite de Crédito: " + this.limit);
    }


}
