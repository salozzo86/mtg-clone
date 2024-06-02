import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        try {
            GameManager gameManager = new GameManager();
            gameManager.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
