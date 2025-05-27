import java.time.LocalDate;
import java.util.*;

class Reminder {
    LocalDate date;
    String message;

    Reminder(LocalDate date, String message) {
        this.date = date;
        this.message = message;
    }

    public String toString() {
        return "📅 " + date + ": " + message;
    }
}

public class DateReminderApp {
    static Scanner sc = new Scanner(System.in);
    static List<Reminder> reminders = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Date Reminder App ---");
            System.out.println("1. Add Reminder");
            System.out.println("2. View All Reminders");
            System.out.println("3. View Today's Reminders");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addReminder();
                case 2 -> viewAllReminders();
                case 3 -> viewTodayReminders();
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void addReminder() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.next());
        sc.nextLine(); // consume newline
        System.out.print("Enter reminder message: ");
        String message = sc.nextLine();
        reminders.add(new Reminder(date, message));
        System.out.println("Reminder added.");
    }

    static void viewAllReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No reminders found.");
            return;
        }
        System.out.println("--- All Reminders ---");
        for (Reminder r : reminders) {
            System.out.println(r);
        }
    }

    static void viewTodayReminders() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        System.out.println("--- Reminders for Today ---");
        for (Reminder r : reminders) {
            if (r.date.equals(today)) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No reminders for today.");
    }
}