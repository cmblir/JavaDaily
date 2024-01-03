package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVolume();

        speaker.volumeUp();
        speaker.volumeUp();

        speaker.showVolume();

        speaker.volumeDown();
        speaker.volumeDown();
        // speaker.volume = 200; 접근 제어자로 인해 접근 불가
        speaker.showVolume();
    }
}
