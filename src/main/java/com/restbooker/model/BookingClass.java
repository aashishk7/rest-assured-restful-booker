package com.restbooker.model;

import java.awt.print.Book;

public class BookingClass {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesClass bookingdates;
    private String additionalneeds;

    public BookingClass(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesClass bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public int gettotalprice() {
        return totalprice;
    }

    public boolean isdepositpaid() {
        return depositpaid;
    }

    public BookingDatesClass getbookingdates() {
        return bookingdates;
    }

    public String getadditionalneeds() {
        return additionalneeds;
    }

    public static class Builder{
        private String firstname, lastname, additionalneeds;
        private int totalprice;
        private boolean depositpaid;
        private BookingDatesClass bookingdates;

        public Builder setfirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setlastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder settotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public Builder setdepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public Builder setbookingdates(BookingDatesClass bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }

        public Builder setadditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
            return this;
        }

        public BookingClass build() {
            return new BookingClass(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
        }
    }
}

