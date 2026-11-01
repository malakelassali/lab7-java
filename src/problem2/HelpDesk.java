package problem2;

import java.util.ArrayList;
import java.util.List;

public class HelpDesk implements IHelpDesk {
    private List<IEmployee> employees;
    private List<ITicket> tickets;

    public HelpDesk() {
        employees= new ArrayList<>();
        tickets= new ArrayList<>();
    }

    @Override
    public void addEmployee(IEmployee employee) {
        for (IEmployee emp : employees) {
            if (emp.getFullName().equals(emp.getFullName())) {
                throw new IllegalArgumentException("An employee with this name already exists.");
            }
        }

        employees.add(employee);
    }

    @Override
    public void addTicket(ITicket ticket) {
        for (ITicket t:tickets) {
            if (ticket.getId() == t.getId()) {
                throw new IllegalArgumentException("A ticket with this ID already exists.");}
        }
        tickets.add(ticket);
    }

    @Override
    public void completeTicket(String employeeFullName, int ticketId) {
        IEmployee employee= null;
        ITicket ticket= null;

        for (IEmployee current : employees) {
            if (current.getFullName().equals(employeeFullName)) {
                employee= current;
                break;
            }
        }
        for (ITicket current : tickets) {
            if (current.getId() == ticketId) {
                ticket= current;
                break;
            }
        }

        if (employee == null || ticket == null) return;
        if (ticket.getIsCompleted()) return;
        if (!employee.getAssignedCategories().contains(ticket.getCategory())) return;
        if (employee.getPointLevel() < ticket.getPoint()) return;

        ticket.setAssignedEmployee(employee.getFullName());
        ticket.setIsCompleted(true);
    }

    @Override
    public int getWaitingTicketCount() {
        int count= 0;
        for (ITicket ticket : tickets) {
            if (!ticket.getIsCompleted()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getCompletedTicketsTotalPoint() {
        int total= 0;

        for (ITicket ticket : tickets) {
            if (ticket.getIsCompleted()) {
                total+= ticket.getPoint();
            }
        }
        return total;
    }

    @Override
    public List<CategoryNode> getTicketsTotalPointByCategory() {
        List<CategoryNode> result= new ArrayList<>();

        for (Category category : Category.values()) {
            int total= 0;
            for (ITicket ticket : tickets) {
                if (ticket.getCategory() == category) {
                    total+= ticket.getPoint();
                }
            }
            result.add(new CategoryNode(category, total));
        }
        return result;
    }

    @Override
    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
        List<EmployeeNode> result= new ArrayList<>();
        for (IEmployee employee : employees) {
            int total= 0;
            for (ITicket ticket : tickets) {
                if (ticket.getIsCompleted() &&
                        employee.getFullName().equals(ticket.getAssignedEmployee())) {
                    total+= ticket.getPoint();
                }
            }
            result.add(new EmployeeNode(employee, total));
        }
        return result;
    }
}