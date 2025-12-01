package org.ecommerce.paymentservice.controllers;


import org.ecommerce.paymentservice.dtos.InitiatePayementDto;
import org.ecommerce.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    //private ProductService productService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
        //this.productService = productService;

    }

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePayementDto initiatePayementDto) {

        return paymentService.initiatePayment(
                initiatePayementDto.getEmail(),
                initiatePayementDto.getPhoneNumber(),
                initiatePayementDto.getAmount(),
                initiatePayementDto.getOrderId());
    }

    @PostMapping("/webhook")
    public String listenToWebhook(@RequestBody String webhookEvent) {
        System.out.println(webhookEvent);
        return "OK";
    }

//    @GetMapping("/product/{id}")
//    public String getProduct(@PathVariable int id)
//    {
//        return productService.getProduct(id);
//    }

}

