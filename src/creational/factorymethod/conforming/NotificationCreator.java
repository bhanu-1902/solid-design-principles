package creational.factorymethod.conforming;

// The Factory Method itself: subclasses decide WHAT gets created, this
// class decides WHEN and HOW it gets used. notify() is closed for
// modification (OCP) -- new channels arrive as new subclasses, never as
// edits here -- and it depends only on the Notification abstraction, never
// on a concrete class (DIP), the same relationship
// dip.copy.conforming.Copy has to Reader/Writer rather than
// KeyboardReader/PrinterWriter.
public abstract class NotificationCreator {
    protected abstract Notification createNotification();

    public void notify(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
