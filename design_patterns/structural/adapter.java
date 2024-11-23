package design_patterns.structural;

interface AudioPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedAudioPlayer {
    void playVLC(String val);
    void playMP4(String val);
}

class VLCPlayer implements AdvancedAudioPlayer {
    @Override
    public void playVLC(String val) {
        System.out.println("this is playvlc");
    }

    @Override
    public void playMP4(String val) {
        System.out.println("this is playmp4");
    }
}

class AudioPlayerAdapter implements AudioPlayer {
    AdvancedAudioPlayer advancedAudioPlayer;
    public AudioPlayerAdapter(AdvancedAudioPlayer advancedAudioPlayer) {
        this.advancedAudioPlayer = advancedAudioPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedAudioPlayer.playVLC(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedAudioPlayer.playMP4(fileName);
        }
    }
}