package design_patterns.behavioural;

interface User {
    void sendMessage(String msg);
    void recieveMessage();
}


interface ChatMediator {
    void sendMessage(String msg, User user);
}

class ChatMediatorImpl implements ChatMediator {

    @Override
    public void sendMessage(String msg, User user) {

    }
}


class UserImpl implements User {
    ChatMediatorImpl mediator;

    UserImpl(ChatMediatorImpl med) {
        this.mediator = med;
    }

    @Override
    public void sendMessage(String msg) {
        mediator.sendMessage(msg, this);
    }

    @Override
    public void recieveMessage() {

    }
}