package design_patterns.behavioural;

// Command interface
interface Command {
    void execute();
}

// Concrete command classes
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private TV tv;
    private int channel;

    public ChangeChannelCommand(TV tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}

// Receiver class
class TV {
    public void turnOn() {
        System.out.println("TV is turned on");
    }

    public void turnOff() {
        System.out.println("TV is turned off");
    }

    public void changeChannel(int channel) {
        System.out.println("TV channel is changed to " + channel);
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
//public class Main {
//    public static void main(String[] args) {
//        TV tv = new TV();
//
//        Command turnOnCommand = new TurnOnCommand(tv);
//        Command turnOffCommand = new TurnOffCommand(tv);
//        Command changeChannelCommand = new ChangeChannelCommand(tv, 10);
//
//        RemoteControl remoteControl = new RemoteControl();
//
//        remoteControl.setCommand(turnOnCommand);
//        remoteControl.pressButton();
//
//        remoteControl.setCommand(changeChannelCommand);
//        remoteControl.pressButton();
//
//        remoteControl.setCommand(turnOffCommand);
//        remoteControl.pressButton();
//    }
//}