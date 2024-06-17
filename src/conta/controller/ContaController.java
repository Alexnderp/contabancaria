package conta.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;


public class ContaController implements ContaRepository {
    private ArrayList<Conta> accounts = new ArrayList<>();

    public ArrayList<Conta> getAccounts() {
        return accounts;
    }

    @Override
    public void searchByNumber(int number) {

    }

    @Override
    public void listAll() {
        accounts.forEach(Conta::view);
    }

    @Override
    public void register(Conta account) {
        accounts.add(account);

    }

    @Override
    public void update(Conta account) {

    }

    @Override
    public void delete(int number) {

    }

    @Override
    public void withdraw(int number, float value) {

    }

    @Override
    public void deposit(int number, float value) {

    }

    @Override
    public void transfer(int originNumber, int destinationNumber, float value) {

    }
}
