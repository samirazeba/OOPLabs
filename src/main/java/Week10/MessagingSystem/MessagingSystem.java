package Week10.MessagingSystem;

public class MessagingSystem {

    @CanSendMessage
    @RequiresPremission(1)
    public static void sendMessage(User user, String message) {
        System.out.println("Message sent by user: " + user.getUsername() + "\nMessage: " + message);
    }

    @CanSendMessage
    @RequiresPremission(2)
    public static void sendMessage(Admin admin, String message) {
        System.out.println("Message sent by admin: " + admin.getUsername() + "\nMessage: " + message);
    }

    public static void main(String[] args) {
        User regularUser = new User("Mirna");
        sendMessage(regularUser, "Hello\n");

        Admin admin = new Admin("Sadzida");
        sendMessage(admin, "Hello\n");

        User user = new User("Samira");
        sendMessage(user, "Restricted message.");

    }
}
