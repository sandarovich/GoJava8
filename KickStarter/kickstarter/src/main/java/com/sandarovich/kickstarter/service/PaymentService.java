package com.sandarovich.kickstarter.service;


import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.model.Payment;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class PaymentService {

    public static final int CARD_NUMBER_LENGTH = 11;
    @Autowired
    PaymentDao paymentDao;

    private Payment payment;

    public boolean allowPayment() {
        String cardNumber = payment.getCardNumber();
        String cardHolder = payment.getCardHolder();
        double amount = payment.getAmount();

        return !(!StringUtils.isNumeric(cardNumber) || StringUtils.isNumericSpace(cardNumber)
            || StringUtils.isEmpty(cardHolder) || amount <= 0 || cardNumber.length() != CARD_NUMBER_LENGTH);

    }

    public void processPayment() {
        paymentDao.pay(payment);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
