package design_patterns.creational;

interface PaymentGateway {
    void paymentProcessing();
}

class PaypalG implements PaymentGateway {
    @Override
    public void paymentProcessing() {
        System.out.println("this is payment processing @paypal");
    }
}

class PayuG implements PaymentGateway {
    @Override
    public void paymentProcessing() {
        System.out.println("payment processing at @PayU");
    }
}


interface PaymentGFactory {
    PaymentGateway createGateway();
}

class PaypalGFactory implements PaymentGFactory {
    @Override
    public PaymentGateway createGateway() {
        return new PaypalG();
    }
}

class StripeFactory implements PaymentGFactory {
    @Override
    public PaymentGateway createGateway() {
        return new PayuG();
    }
}


// client side

class PaymentProcessor {
    private PaymentGFactory pgFactory;

    PaymentProcessor(PaymentGFactory factory) {
        this.pgFactory = factory;
    }

    public void processPayment() {
        PaymentGateway factory = pgFactory.createGateway();
        factory.paymentProcessing();
    }
}


