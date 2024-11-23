package design_patterns.structural;


interface TV {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}


class SamSungTv implements TV {
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void setChannel(int channel) {}
}

interface Remote {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

class SamsungRemote implements Remote {

    TV tv;
    SamsungRemote() {
        tv = new SamSungTv();
    }

    @Override
    public void turnOn() {
        tv.turnOn();
    }

    @Override
    public void turnOff() {
        tv.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        tv.setChannel(channel);
    }
}