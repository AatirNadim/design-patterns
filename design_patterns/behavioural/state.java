package design_patterns.behavioural;

// State interface
interface State {
    void selectProduct(VendingMachine vendingMachine);
    void makePayment(VendingMachine vendingMachine);
    void dispenseProduct(VendingMachine vendingMachine);
}

// Concrete state classes
class NoSelectionState implements State {
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Product selected");
        vendingMachine.setState(vendingMachine.getHasSelectionState());
    }

    @Override
    public void makePayment(VendingMachine vendingMachine) {
        System.out.println("Please select a product first");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please select a product and make payment first");
    }
}

class HasSelectionState implements State {
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Product already selected");
    }

    @Override
    public void makePayment(VendingMachine vendingMachine) {
        System.out.println("Payment made");
        vendingMachine.setState(vendingMachine.getSoldState());
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please make payment first");
    }
}

class SoldState implements State {
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Please wait, we are already dispensing a product");
    }

    @Override
    public void makePayment(VendingMachine vendingMachine) {
        System.out.println("Please wait, we are already dispensing a product");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Dispensing product");
        vendingMachine.setState(vendingMachine.getNoSelectionState());
    }
}

// Context class
class VendingMachine {
    private State noSelectionState;
    private State hasSelectionState;
    private State soldState;
    private State currentState;

    public VendingMachine() {
        noSelectionState = new NoSelectionState();
        hasSelectionState = new HasSelectionState();
        soldState = new SoldState();
        currentState = noSelectionState;
    }

    public void selectProduct() {
        currentState.selectProduct(this);
    }

    public void makePayment() {
        currentState.makePayment(this);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void setState(State state) {
        currentState = state;
    }

    public State getNoSelectionState() {
        return noSelectionState;
    }

    public State getHasSelectionState() {
        return hasSelectionState;
    }

    public State getSoldState() {
        return soldState;
    }
}

// Client code
class Main3 {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectProduct();
        vendingMachine.makePayment();
        vendingMachine.dispenseProduct();

        vendingMachine.selectProduct();
        vendingMachine.makePayment();
        vendingMachine.dispenseProduct();
    }
}