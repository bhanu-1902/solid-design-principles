package creational.factorymethod.conforming;

import java.util.List;

public class Demo {
    public static void run() {
        List<NotificationCreator> channels = List.of(
                new EmailNotificationCreator(),
                new SMSNotificationCreator(),
                new PushNotificationCreator()
        );

        for (NotificationCreator creator : channels) {
            creator.notify("Your order shipped");
        }

        System.out.println();
        System.out.println("Adding PushNotificationCreator required a new file and one line");
        System.out.println("in this list -- NotificationCreator.notify() and every existing");
        System.out.println("creator were never touched.");
    }

    public static void main(String[] args) {
        run();
    }
}
