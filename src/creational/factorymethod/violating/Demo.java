package creational.factorymethod.violating;

public class Demo {
    public static void run() {
        NotificationService service = new NotificationService();
        service.createNotification("email").send("Your order shipped");
        service.createNotification("sms").send("Your OTP is 4821");

        System.out.println("Adding \"push\" support means editing");
        System.out.println("NotificationService.createNotification() itself --");
        try {
            service.createNotification("push").send("New message");
        } catch (IllegalArgumentException e) {
            System.out.println("  -> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        run();
    }
}
