package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

    public void findByNumber(int number);
    public void listAll();
    public void register(Conta account);
    public void update(Conta account);
    public void delete(int number);

    public void withdraw(int number, double value);
    public void deposit(int number, double value);
    public void transfer(int originNumber, int destinationNumber, double value);


}
