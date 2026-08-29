package creational.factorymethod.conforming;

public class SMSNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new SMSNotification();
    }
}
