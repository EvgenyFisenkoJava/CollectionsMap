package pro.sky.course2.java.collectionsmap;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int index;

    public Employee(int index, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
