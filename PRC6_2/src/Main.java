interface Notifier {

    void send(String message);
}


interface Urgent {

}


public class Main {

    public static void main(String[] args) {

        Notifier email = msg ->
                System.out.println("[Email] " + msg);

        Notifier sms = msg ->
                System.out.println("[SMS] " + msg);

        Notifier urgentEmail = (Notifier & Urgent) (msg ->
                System.out.println("[Urgent Email] " + msg));

        Notifier urgentSMS = (Notifier & Urgent) (msg ->
                System.out.println("[Urgent SMS] " + msg));


        Notifier[] senders = {
            email,
            sms,
            urgentEmail,
            urgentSMS
        };


        String message = "Notification from Dwij Patel 25CE077";


        for (Notifier sender : senders) {

            sender.send(message);

            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}