package org.ecommerce.paymentservice.paymentGateways;


public interface PaymentGateway {
    public String generatePaymentLink(String email, String phoneNumber, Long amount, String orderId);
}
