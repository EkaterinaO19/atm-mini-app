package org.example;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ATMOperationsInterface op = new ATMOperationsImpl();

        int atmnumber = 12345;
        int atmpin = 123;

        Scanner in = new Scanner(System.in);
        System.out.println("Вас приветствует банк 'Мой банк'!");
        System.out.println("Введите номер банкомата: ");
        int atmNumber = in.nextInt();
        System.out.println("Введите пин-код банкомата: ");
        int atmPin = in.nextInt();

        if((atmnumber==atmNumber)&&(atmpin == atmPin)){
            while (true) {
                System.out.println("1.Посмотреть баланс\n2.Снять средства\n3.Пополнить баланс\n4.Посмотртеь выписку\n5.Выход");
                System.out.println("Введите номер операции: ");
                int choice = in.nextInt();
                if (choice == 1) {
                    op.viewBalance();
                } else if(choice == 2) {
                    System.out.println("Введите сумму списания: ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if(choice == 3) {
                    System.out.println("Введите сумму пополнения: ");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);
                }else if(choice == 4) {
                    op.viewStatement();
                }else if(choice == 5) {
                    System.out.println("Заберите карту. Спасибо!");
                    System.exit(0);
                } else {
                    System.out.println("Пожалуйста, введите корректный код операции");
                }
            }
        } else {
            System.out.println("Неверный номер и/или пин-код банкомата");
            System.exit(0);
        }
    }
}