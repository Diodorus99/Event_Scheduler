// EventScheduler.java
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;
    
    public EventScheduler() {
        this.events = new ArrayList<>() ;
        this.scanner = new Scanner(System.in) ;
    }
    
    public void run() {
        boolean running = true;
        while (running) {
            // Display menu options
            System.out.println("\n=== Event Scheduler ===");
            System.out.println("1. Add Event");
            System.out.println("2. Display All Events");
            System.out.println("3. Show Time Until Event");
            System.out.println("4. Convert Event Time to Different Timezone");
            System.out.println("5. Find Upcoming Events");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addEvent() ;
                    //add event
                    
                    break;
                case 2:
                    //display all events
                    displayAllEvents() ;
                    break;
                case 3:
                    //show time until event
                    showTimeUntilEvent() ;
                    break;
                case 4:
                    // convert event time
                    convertEventTime() ;
                    break;
                case 5:
                    // find upcoming events
                    findUpcomingEvents() ;
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the Event Scheduler. Goodbye!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    
    private void addEvent() {
        // Step 10: Implement method to get event details from user and create a new Event
        System.out.print("Event name: ");
        String name = scanner.nextLine();

        System.out.print("Event date & time (dd/MM/yyyy HH:mm): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
        ZonedDateTime dateTime = localDateTime.atZone(ZoneId.systemDefault());

        System.out.print("Duration in minutes: ");
        long minutes = Long.parseLong(scanner.nextLine());
        Duration duration = Duration.ofMinutes(minutes);

        Event newEvent = new Event(name, dateTime, duration);
        events.add(newEvent);
    }
    
    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        System.out.println("All events:") ;
        for (Event i: events) {
            if (i!=null) {
                System.out.println(i) ;
            }
        }
    }
    
    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific event
        System.out.println("Events with respective index:") ;
        int index = 0 ;
        for (Event j: events) {
            index++ ;
            if (j != null) {
                System.out.println(index+" - "+j.getName()) ;
            }
        }
        System.out.println("Pick event by index") ;
        int inputIndex = Integer.parseInt(scanner.nextLine()) ;
        int count = 1 ;
        for (Event k: events) {
            if (count==inputIndex) {
                System.out.println(k.timeUntilEvent()) ;
            }
            count++ ;
        }
    }
    
    private void convertEventTime() {
        // Step 13: Implement method to convert event time to a different timezone
        System.out.println("Events with respective index:") ;
        int index = 0 ;
        for (Event j: events) {
            index++ ;
            if (j != null) {
                System.out.println(index+" - "+j.getName()) ;
            }
        }
        System.out.println("Pick event by index") ;
        int inputIndex = Integer.parseInt(scanner.nextLine()) ;
        System.out.print("Enter timezone (e.g. UTC, America/New_York): ");
        String zoneId = scanner.nextLine();

        Event selected = events.get(inputIndex - 1);
        ZonedDateTime converted = selected.convertToTimezone(zoneId);

        System.out.println("Converted time: " + converted);
    }
    
    private void findUpcomingEvents() {
        // Step 14: Implement method to find events within a specific number of days
        System.out.println("Provide an interval of days") ;
        int days = Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Events within "+days+"days from now:") ;
        for (Event l: events) {
            Duration diff = Duration.between(ZonedDateTime.now(), l.getDateTime());
            if (!diff.isNegative() && diff.toDays() <= days) {
                System.out.println(l);
            }
        }
    }
    
    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
    //scanner.close() ;
}
