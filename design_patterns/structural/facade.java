package design_patterns.structural;


class DVDPlayer {
    public void on() {}

    public void play() {}

    public void off() {}
}

class Projector {
    public void on() {}

    public void play() {}

    public void off() {}
}


class Amplifier {
    public void on() {}

    public void play() {}

    public void off() {}
}

class MovieTheatre {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;

    MovieTheatre(DVDPlayer dvdPlayer, Projector projector, Amplifier amplifier) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
    }

    public void play() {
        dvdPlayer.on();
        projector.on();
        amplifier.on();

        dvdPlayer.play();
        projector.play();
        amplifier.play();
    }

    public void off() {
        dvdPlayer.off();
        projector.off();
        amplifier.off();
    }
}