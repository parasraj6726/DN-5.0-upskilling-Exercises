// Q19: Interface Implementation
public class InterfaceImplementation {

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the Guitar: Strum strum!");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the Piano: Tinkle tinkle!");
        }
    }

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}
