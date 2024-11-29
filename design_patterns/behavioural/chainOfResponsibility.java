package design_patterns.behavioural;

interface WithdrawalHandler {
    void withDraw(int val);
}

class TenWithdrawalHandler implements WithdrawalHandler {
    WithdrawalHandler nextHandler;
    TenWithdrawalHandler (WithdrawalHandler next) {
        this.nextHandler = next;
    }

    @Override
    public void withDraw(int val) {
        int temp = val/10;
        val = val%10;
        System.out.println("Total " + temp + " coins");
        if(val != 0) {
            nextHandler.withDraw(val);
        }
    }
}

class HundredWithDrawal implements WithdrawalHandler {

    WithdrawalHandler nextHandler;
    HundredWithDrawal(WithdrawalHandler next) {
        this.nextHandler = next;
    }

    @Override
    public void withDraw(int val) {
        int temp = val/100;
        val = val%100;
        System.out.println("Total " + temp + " coins");
        if(val != 0) {
            nextHandler.withDraw(val);
        }
    }
}


class Front {
    public void perform() {
        WithdrawalHandler ten = new TenWithdrawalHandler(null);
        WithdrawalHandler hundred = new HundredWithDrawal(ten);
        hundred.withDraw(323323);
    }
}