package com.restbooker.model;


import java.util.Date;

public class BookingDatesClass {

    private Date checkin;
    private Date checkout;

    public BookingDatesClass(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public static class Builder {
        private Date checkin, checkout;

        public Builder setCheckin(Date checkin) {
            this.checkin = checkin;
            return this;
        }

        public Builder setCheckout(Date checkout) {
            this.checkout = checkout;
            return this;
        }

        public BookingDatesClass build() {
            return new BookingDatesClass(checkin, checkout);
        }
    }
}

