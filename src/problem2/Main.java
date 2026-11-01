package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        HelpDesk helpDesk= new HelpDesk();
        int choice;
        do {
            System.out.println("\n--- Help Desk ---");
            System.out.println("1. Add employee");
            System.out.println("2. Add ticket");
            System.out.println("3. Complete ticket");
            System.out.println("4. Show statistics");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice= sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Full name: ");
                    String fullName= sc.nextLine();

                    System.out.print("Point level: ");
                    int pointLevel= sc.nextInt();
                    sc.nextLine();

                    System.out.println("Available categories:");
                    for (Category category : Category.values()) {
                        System.out.println(category);
                    }

                    System.out.print("Number of assigned categories: ");
                    int number= sc.nextInt();
                    sc.nextLine();

                    List<Category> categories= new ArrayList<>();

                    for (int i= 0; i < number; i++) {
                        System.out.print("Category name: ");
                        String categoryName= sc.nextLine();
                        categories.add(Category.valueOf(categoryName));
                    }

                    Employee employee= new Employee(
                            fullName, pointLevel, categories);

                    helpDesk.addEmployee(employee);
                    System.out.println("Employee added.");
                    break;
                }

                case 2: {
                    System.out.print("Ticket ID: ");
                    int id= sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ticket name: ");
                    String name= sc.nextLine();

                    System.out.println("Available categories:");
                    for (Category category : Category.values()) {
                        System.out.println(category);
                    }

                    System.out.print("Category name: ");
                    Category category= Category.valueOf(sc.nextLine());

                    System.out.print("Points: ");
                    int point= sc.nextInt();
                    sc.nextLine();

                    Ticket ticket= new Ticket(id, name, category, point);
                    helpDesk.addTicket(ticket);

                    System.out.println("Ticket added.");
                    break;
                }

                case 3: {
                    System.out.print("Employee full name: ");
                    String fullName= sc.nextLine();

                    System.out.print("Ticket ID: ");
                    int id= sc.nextInt();
                    sc.nextLine();

                    int waitingBefore= helpDesk.getWaitingTicketCount();

                    helpDesk.completeTicket(fullName, id);

                    if (helpDesk.getWaitingTicketCount() < waitingBefore) {
                        System.out.println("Ticket completed.");
                    } else {
                        System.out.println("Ticket could not be completed.");
                    }

                    break;
                }

                case 4: {
                    System.out.println("WaitingTicketCount:"
                                    + helpDesk.getWaitingTicketCount());

                    System.out.println("CompletedTicketsTotalPoint:"
                                    + helpDesk.getCompletedTicketsTotalPoint());

                    System.out.println("TicketsTotalPointByCategory:");

                    for (CategoryNode node :
                            helpDesk.getTicketsTotalPointByCategory()) {
                        System.out.println(
                                node.category + ":" + node.totalPoint);
                    }

                    System.out.println("TicketsTotalPointByEmployee:");

                    for (EmployeeNode node:helpDesk.getTicketsTotalPointByEmployee()) {
                        System.out.println(
                                node.employee.getFullName()
                                        + ":" + node.totalPoint);
                    }
                    break;
                }

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        sc.close();
    }
}