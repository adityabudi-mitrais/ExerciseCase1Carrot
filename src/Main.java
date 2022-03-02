import model.User;
import model.TransactionHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    static List<User> users = new ArrayList<>();
    static List<TransactionHistory> transactionHistories = new ArrayList<>();

    public static void main(String[] args) {

        initiateUsers();
        showListUsers();

        System.out.println("-----");

        sendPoint(1, 2, 10);
        sendPoint(1, 2, 100);

        System.out.println("-----");

        showTransactionHistories();

        System.out.println("-----");

        showListUsers();
    }

    private static void initiateUsers() {
        users.add(new User(1, "Adit", 50));
        users.add(new User(2, "Augi", 50));
    }

    public static void showListUsers() {
        System.out.println("Current users data: ");
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    public static void sendPoint(int idSender, int idReceiver, int pointGiven) {
        int indexSender = -1, indexReceiver = -1;
        boolean idValid = false;

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == idSender) {
                indexSender = i;
            }
            if(users.get(i).getId() == idReceiver) {
                indexReceiver = i;
            }
            if(indexSender>=0 && indexReceiver>=0) {
                idValid = true;
                break;
            }
        }

        //validate id
        if(!idValid) {
            System.out.println("ERROR sendPoint(): Sender and/or receiver id not found");
            return;
        }

        //validate points
        if(users.get(indexSender).getPoint()-pointGiven <0) {
            System.out.println("ERROR sendPoint(): Insufficient sender point/s from id " + idSender);
            return;
        }

        users.get(indexSender).setPoint(users.get(indexSender).getPoint()-pointGiven);
        users.get(indexReceiver).setPoint(users.get(indexReceiver).getPoint()+pointGiven);


        transactionHistories.add(new TransactionHistory(
                new Date(),
                users.get(indexSender).getName(),
                users.get(indexReceiver).getName(),
                pointGiven
                )
        );

        System.out.println(pointGiven + " point/s given from " + users.get(indexSender).getName() + " to " + users.get(indexReceiver).getName());
    }

    public static void showTransactionHistories() {
        System.out.println("Transaction history: ");
        for (TransactionHistory history: transactionHistories) {
            System.out.println(history.toString());
        }
    }
}
