package design_patterns.behavioural;

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategy classes
class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

class StripeStrategy implements PaymentStrategy {
    private String cardNumber;

    public StripeStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Stripe card " + cardNumber);
    }
}

class BankTransferStrategy implements PaymentStrategy {
    private String accountNumber;

    public BankTransferStrategy(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using bank transfer to account " + accountNumber);
    }
}

// Context class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code
class Main23 {
    public static void main(String[] args) {
        PaymentStrategy paypalStrategy = new PayPalStrategy("john.doe@example.com");
        PaymentStrategy stripeStrategy = new StripeStrategy("1234-5678-9012-3456");
        PaymentStrategy bankTransferStrategy = new BankTransferStrategy("1234567890");

        PaymentContext paymentContext = new PaymentContext(paypalStrategy);
        paymentContext.pay(100.0);

        paymentContext.setPaymentStrategy(stripeStrategy);
        paymentContext.pay(200.0);

        paymentContext.setPaymentStrategy(bankTransferStrategy);
        paymentContext.pay(300.0);
    }
}
