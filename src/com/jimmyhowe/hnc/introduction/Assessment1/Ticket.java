package com.jimmyhowe.hnc.introduction.Assessment1;

/**
 * The Ticket Class
 * <p>
 * The ticket class encapsulates the Ticket information, and the data is
 * accessed via its accessors (setters and getters)
 * <p>
 * The ticket class in this case is static and means that the class can be
 * used without instantiation and accessed globally across the program without
 * the need to be passed by value
 */
class Ticket {

    private static String firstName, lastName, address;
    private static double studentDiscount, childDiscount, fee, studentTicketPrice, childTicketPrice;

    static String getFirstName() {
        return firstName;
    }

    static void setFirstName(String firstName) {
        Ticket.firstName = firstName;
    }

    static String getLastName() {
        return lastName;
    }

    static void setLastName(String lastName) {
        Ticket.lastName = lastName;
    }

    static String getAddress() {
        return address;
    }

    static void setAddress(String address) {
        Ticket.address = address;
    }

    static double getStudentDiscount() {

        return studentDiscount;
    }

    static void setStudentDiscount(double studentDiscount) {
        Ticket.studentDiscount = studentDiscount;
    }

    static double getChildDiscount() {
        return childDiscount;
    }

    static void setChildDiscount(double childDiscount) {
        Ticket.childDiscount = childDiscount;
    }

    static double getFee() {
        return fee;
    }

    static void setFee(double fee) {
        Ticket.fee = fee;
    }

    public static double getStudentTicketPrice() {
        return studentTicketPrice;
    }

    public static void setStudentTicketPrice(double studentTicketPrice) {
        Ticket.studentTicketPrice = studentTicketPrice;
    }

    public static double getChildTicketPrice() {
        return childTicketPrice;
    }

    public static void setChildTicketPrice(double childTicketPrice) {
        Ticket.childTicketPrice = childTicketPrice;
    }
}
