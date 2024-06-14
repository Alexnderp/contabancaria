package conta.model;

public class ContaPoupanca extends Conta{
    private int birthday;


    public ContaPoupanca(int number, int agency, int type, String owner, double balance, int birthday) {
        super(number, agency, type, owner, balance);
        this.birthday = birthday;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public void view() {
        super.view();
        System.out.println("Aniversário da conta: " + this.birthday);
    }
}
