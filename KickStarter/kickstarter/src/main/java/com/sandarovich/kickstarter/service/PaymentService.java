package com.sandarovich.kickstarter.service;


import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dto.PaymentDto;
import com.sandarovich.kickstarter.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;


public class PaymentService {

    public static final int CARD_NUMBER_LENGTH = 11;
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    ProjectDao projectDao;

    private PaymentDto paymentDto;

    public boolean allowPayment() {
        //TODO implement
//        String cardNumber = paymentDto.getCardNumber();
//        String cardHolder = paymentDto.getCardHolder();
//        double amount = paymentDto.getAmount();
//
//        return !(!StringUtils.isNumeric(cardNumber) || StringUtils.isNumericSpace(cardNumber)
//            || StringUtils.isEmpty(cardHolder) || amount <= 0 || cardNumber.length() != CARD_NUMBER_LENGTH);
        return true;
    }

    public void processPayment() {
        Payment payment = new Payment();
        payment.setCardHolder(paymentDto.getCardHolder());
        payment.setCardNumber(paymentDto.getCardNumber());
        payment.setAmount(paymentDto.getAmount());
        payment.setProject(projectDao.findById(paymentDto.getProjectId()));
        paymentDao.pay(payment);
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }
}
