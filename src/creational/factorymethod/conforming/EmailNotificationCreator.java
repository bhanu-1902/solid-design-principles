package creational.factorymethod.conforming;

public class EmailNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
