package Week13;

interface Payment {
    public void processPayment();
}
interface PaymentFactory {
    public Payment createPayment();
}
class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Credit card payment processed.");
    }
}
class PayPalPament implements Payment {

    @Override
    public void processPayment() {
        System.out.println("Paypal payment processed.");
    }
}
class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPament();
    }
}
class PaymentMain {
    public static void main(String[] args) {

        //Instantiate pyament factories
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        PaymentFactory paypalFactory = new PayPalPaymentFactory();

        //Using factories to create different payment objects
        Payment creditCardPayment = creditCardFactory.createPayment();
        Payment paypalPayment = paypalFactory.createPayment();

        //preocessPayment()
        creditCardPayment.processPayment();
        paypalPayment.processPayment();
    }
}
