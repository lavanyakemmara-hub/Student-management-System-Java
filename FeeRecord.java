package com.reva.sms.model;

import java.time.LocalDate;

public class FeeRecord implements FeePayable {
    private final int studentId;
    private double amountPaid;
    private final LocalDate paymentDate;

    public FeeRecord(int studentId, double amountPaid) {
        this.studentId = studentId;
        this.amountPaid = amountPaid;
        this.paymentDate = LocalDate.now();
    }

    public int getStudentId() { return studentId; }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }
    public LocalDate getPaymentDate() { return paymentDate; }

    @Override
    public double calculateNetFee() {
        return amountPaid;
    }
}
