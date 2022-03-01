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

        sendPoint(1, 2, 10);
        showTransactionHistories();
        showListUsers();
    }

    private static void initiateUsers() {
        users.add(new User(1, "Adit", 50));
        users.add(new User(2, "Augi", 50));
    }

    public static void showListUsers() {
        System.out.println("List of users: ");
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    public static void sendPoint(int idSender, int idReceiver, int pointGiven) {
        int indexSender = -1, indexReceiver = -1;
        boolean valid = false;

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == idSender) {
                indexSender = i;
            }
            if(users.get(i).getId() == idReceiver) {
                indexReceiver = i;
            }
            if(indexSender>=0 && indexReceiver>=0) {
                valid = true;
                break;
            }
        }

        if(!valid) {
            System.out.println("Sender and/or receiver id not found");
            return;
        }

        users.get(indexSender).setPoint(users.get(indexSender).getPoint()-pointGiven);
        users.get(indexReceiver).setPoint(users.get(indexReceiver).getPoint()+pointGiven);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        transactionHistories.add(new TransactionHistory(
                currentDate,
                users.get(indexSender).getName(),
                users.get(indexReceiver).getName(),
                pointGiven
                )
        );
    }

    public static void showTransactionHistories() {
        System.out.println("List of history: ");
        for (TransactionHistory history: transactionHistories) {
            System.out.println(history.toString());
        }
    }
}
