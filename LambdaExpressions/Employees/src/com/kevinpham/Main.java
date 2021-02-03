package com.kevinpham;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // Creating random employees
        Employee john = new Employee("John Doe", 30);
        Employee kevin = new Employee("Kevin Pham", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        // Adding employee to list
        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(kevin);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);


        Function<Employee, String> getLastName  = (Employee employee) -> {
            // Get the index after the space between FirstName and Lastname
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        // Get the second employee's last name
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee : employees) {
            if(random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }


        // Chaining java.util.function Functions
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase(); // Converts to Uppercase
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' ')); // Gets the first name
        Function chainedFunction = upperCase.andThen(firstName); // Performs operation
        System.out.println(chainedFunction.apply(employees.get(0))); // Use first employee entry as example


        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

//        // Print out employees based on condition
//        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
//
//
//        // IntPredicate Examples
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//
//        System.out.println(greaterThan15.test(10)); // Prints false since 10 > 15
//
//        int a = 20;
//        System.out.println(greaterThan15.test(a + 5)); // Prints true since (20 + 5) > 15
//
//        System.out.println(greaterThan15.and(lessThan100).test(50)); // Prints true since 15 < 50 < 100
//
//
//        // Each lambda expression is like a nested block. Equivalent to:
////        {
////            int i;
////
////            return i > 15;
////        }
////        {
////            int i;
////
////            return i < 100;
////        }
//
//
//        // Supplier Interface Examples
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.get());
//        }
//
//        employees.forEach(employee -> {
//            // Get the index after the space between FirstName and Lastname
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is: " + lastName);
//        });
    }


    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }


    /**
     * Print out name of employees based on age condition
     *
     * @param employees    the list of employees
     * @param ageText      the print output message
     * @param ageCondition the age condition for comparison
     */
    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        System.out.println("==================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}