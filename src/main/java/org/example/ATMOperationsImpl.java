package org.example;
import java.util.HashMap;
import java.util.Map;
public class ATMOperationsImpl implements ATMOperationsInterface{
    ATM atm = new ATM();
    Map<Double, String> statement = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Ваш баланс: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount % 500 == 0) {
            if(withdrawAmount <= atm.getBalance()) {
                statement.put(withdrawAmount, "Сумма списана");
                System.out.println("Заберите деньги " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Пожалуйста, введите сумму кратную 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        statement.put(depositAmount, "Сумма внесена");
        System.out.println("Баланс успешно пополнен на сумму " + depositAmount);
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewStatement() {
        for (Map.Entry<Double, String> s:statement.entrySet()){
            System.out.println(s.getKey() +" " + s.getValue());
        }
    }
}
