public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;
    
    public EventScheduler() {
        events = new ArrayList<>() ;
        scanner = new Scanner(System.in) ;
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
                    events.addEvent() ;
                    //add event
                    
                    break;
                case 2:
                    //display all events
                    events.displayAllEvents() ;
                    break;
                case 3:
                    //show time until event
                    events.showTimeUntilEvent() ;
                    break;
                case 4:
                    // convert event time
                    events.convertEventTime() ;
                    break;
                case 5:
                    // find upcoming events
                    events.FindUpcomingEvents() ;
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the Event Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    
    private void addEvent() {
        // Step 10: Implement method to get event details from user and create a new Event
        System.out.println("What is the name of the event?") ;
        String name = scanner.nextLine() ;
        System.out.println("When is the event?(format: dd/MM/yyyy)") ;
        ZonedDateTime dateTime = dateTime.parse(scanner.nextLine() , "dd/MM/yyyy") ;
        Event newEvent = new Event(name , dateTime) ;
        events.add(newEvent) ;
    }
    
    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        System.out.println("All events:") ;
        for (Event i: events) {
            if (i!=null) {
                System.out.println(i) ;
            }
        }
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
    }
    
    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific event
        System.out.println("Events with respective index:") ;
        int index = 0 ;
        for (Event j: events) {
            index++ ;
            if (j != null) {
                System.out.println(index+" - "j.getName()) ;
            }
        }
        System.out.println("Pick event by index") ;
        int inputIndex = Integer.parseInt(scanner.nextLine()) ;
        int count = 1 ;
        for (Event k: events) {
            if (count==inputIndex) {
                System.out.println(k.timeRemaining();) ;
            }
            count++ ;
        }
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
    }
    
    private void convertEventTime() {
        // Step 13: Implement method to convert event time to a different timezone
        System.out.println("Events with respective index:") ;
        int index = 0 ;
        for (Event j: events) {
            index++ ;
            if (j != null) {
                System.out.println(index+" - "j.getName()) ;
            }
        }
        System.out.println("Pick event by index") ;
        int inputIndex = Integer.parseInt(scanner.nextLine()) ;
        System.out.println("What is the new timezone?(format z)") ;
        ZonedDateTime timezoneId = dateTime.parse(scanner.nextLine(),"z") ;
        int count = 1 ;
        for (Event k: events) {
            if (count==inputIndex) { 
                System.out.println(givenDateTime.timeDifferentTimeZone(timezoneId)) ;
            }
        count ++ ;
        }
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone
    }
    
    private void findUpcomingEvents() {
        // Step 14: Implement method to find events within a specific number of days
        System.out.println("Provide an interval of days") ;
        int days = Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Events within "+days+"days from now:") ;
        for (Event l: events) {
            if (Duration.between(ZonedDateTime.now() , l.dateTime)<=days) { 
                System.out.println(l) ;
            }
        }
    }
    
    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
    scanner.close() ;
}
