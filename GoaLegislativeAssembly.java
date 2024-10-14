import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class GoaLegislativeAssembly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Entity> entities = new ArrayList<>();
        
        while (true) {
            System.out.println("\nGoa Legislative Assembly Management System");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Add Committee");
            System.out.println("4. View Committees");
            System.out.println("5. Add Bill");
            System.out.println("6. View Bills");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Constituency: ");
                    String constituency = scanner.nextLine();
                    entities.add(new Member(memberName, constituency));
                    System.out.println("Member added successfully.");
                    break;
                case 2:
                    System.out.println("Members of the Assembly:");
                    for (Entity entity : entities) {
                        if (entity instanceof Member) {
                            System.out.println(entity);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Committee Name: ");
                    String committeeName = scanner.nextLine();
                    System.out.print("Enter Chairman: ");
                    String chairman = scanner.nextLine();
                    entities.add(new Committee(committeeName, chairman));
                    System.out.println("Committee added successfully.");
                    break;
                case 4:
                    System.out.println("Committees of the Assembly:");
                    for (Entity entity : entities) {
                        if (entity instanceof Committee) {
                            System.out.println(entity);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter Bill Title: ");
                    String billTitle = scanner.nextLine();
                    System.out.print("Enter Introduced By: ");
                    String introducedBy = scanner.nextLine();
                    entities.add(new Bill(billTitle, introducedBy));
                    System.out.println("Bill added successfully.");
                    break;
                case 6:
                    System.out.println("Bills in the Assembly:");
                    for (Entity entity : entities) {
                        if (entity instanceof Bill) {
                            System.out.println(entity);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

// Abstract class Entity (Abstraction)
abstract class Entity {
    private String name;
    
    public Entity(String name) {
        this.name = name;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract String getDetails();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}

// Member class extending Entity (Inheritance and Encapsulation)
class Member extends Entity {
    private String constituency;
    
    public Member(String name, String constituency) {
        super(name);
        this.constituency = constituency;
    }
    
    public String getConstituency() {
        return constituency;
    }
    
    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }
    
    @Override
    public String getDetails() {
        return "Member - Name: " + getName() + ", Constituency: " + constituency;
    }
}

// Committee class extending Entity (Inheritance and Encapsulation)
class Committee extends Entity {
    private String chairman;
    
    public Committee(String name, String chairman) {
        super(name);
        this.chairman = chairman;
    }
    
    public String getChairman() {
        return chairman;
    }
    
    public void setChairman(String chairman) {
        this.chairman = chairman;
    }
    
    @Override
    public String getDetails() {
        return "Committee - Name: " + getName() + ", Chairman: " + chairman;
    }
}

// Bill class extending Entity (Inheritance and Encapsulation)
class Bill extends Entity {
    private String introducedBy;
    
    public Bill(String title, String introducedBy) {
        super(title);
        this.introducedBy = introducedBy;
    }
    
    public String getIntroducedBy() {
        return introducedBy;
    }
    
    public void setIntroducedBy(String introducedBy) {
        this.introducedBy = introducedBy;
    }
    
    @Override
    public String getDetails() {
        return "Bill - Title: " + getName() + ", Introduced By: " + introducedBy;
    }
}

