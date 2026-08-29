package creational.factorymethod.conforming;

// New in this branch: a third channel added purely by writing a new file.
// NotificationCreator, EmailNotificationCreator, and SMSNotificationCreator
// are all completely unaware this class exists.
public class PushNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new PushNotification();
    }
}
