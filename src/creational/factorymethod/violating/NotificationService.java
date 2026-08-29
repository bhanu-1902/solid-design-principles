package creational.factorymethod.violating;

// Every new channel means adding another branch here -- this method is
// never "closed for modification" (violates OCP), and it's the one place
// in the codebase that has to know about every concrete Notification
// subclass that will ever exist.
public class NotificationService {
    public Notification createNotification(String type) {
        if (type.equals("email")) {
            return new EmailNotification();
        } else if (type.equals("sms")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
