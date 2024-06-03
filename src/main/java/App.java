import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try {
            GameManager gameManager = new GameManager();
            gameManager.runMainMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
