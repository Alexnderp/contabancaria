package conta.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Functions;

import java.util.ArrayList;


public class ContaController implements ContaRepository {
    private ArrayList<Conta> accounts = new ArrayList<>();

    public ArrayList<Conta> getAccounts() {
        return accounts;
    }

    @Override
    public void findByNumber(int number) {
        Conta account = Functions.searchByNumber(number,accounts);
        if(account != null){
            account.view();
        } else {
            System.out.printf("\nA conta numero %d não foi encontrada!", number);
        }
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
        Conta result = Functions.searchByNumber(account.getNumber(),accounts);

        if (result != null){
            accounts.set(accounts.indexOf(result), account);
            System.out.printf("Conta numero %d foi atualizada com sucesso!", account.getNumber());
        } else {
            System.out.printf("Conta numero %d não foi encontrada!",account.getNumber());
        }

    }

    @Override
    public void delete(int number) {
        Conta account = Functions.searchByNumber(number,accounts);
        if(account != null){
            if (accounts.remove(account)){
                System.out.printf("A conta numero %d foi deletada com sucesso!", number);
            } else {
                System.out.printf("Conta numero %d não foi encontrada!",number);
            }
        }
    }

    @Override
    public void withdraw(int number, double value) {
        Conta account = Functions.searchByNumber(number,accounts);

        if (account != null){
            if (account.withdraw(value)){
                System.out.printf("Saque na conta numero %d foi efetuado com sucesso!", number);
            } else {
                System.out.printf("Conta numero %d não foi encontrada!",number);
            }
        }
    }

    @Override
    public void deposit(int number, double value) {
        Conta account = Functions.searchByNumber(number,accounts);

        if (account != null){
            account.deposit(value);
            System.out.printf("Saque na conta numero %d foi efetuado com sucesso!", number);
        } else {
                System.out.printf("Conta numero %d não foi encontrada!",number);
            }
        }

    @Override
    public void transfer(int originNumber, int destinationNumber, double value) {
        Conta originAccount = Functions.searchByNumber(originNumber, accounts);
        Conta destinationAccount = Functions.searchByNumber(destinationNumber, accounts);

        if (originAccount!=null && destinationAccount!=null){
            if (originAccount.withdraw(value)){
                destinationAccount.deposit(value);
                System.out.println("Transferencia efetuada com sucesso!");
            }
        }else {
            System.out.println("Conta origem e/ou destino não encontradas!");
        }

    }
}

