import controllers.GrimoireController;
import models.GrimoireModel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GrimoireControllerTest {

    @Test
    public void deckControllerGenerationTest() {
        GrimoireController grimoireController = new GrimoireController();
        GrimoireModel deck = grimoireController.generateDeck(60);

        assertThat(deck.getCards().size()).isEqualTo(60);

    }

    @Test
    public void deckControllerShuffleTest() {
        GrimoireController grimoireController = new GrimoireController();
        GrimoireModel deck = grimoireController.generateDeck(60);

        String[] preShuffleDeckCards = new String[60];
        String[] postShuffleDeckCards = new String[60];

        for (int i = 0; i < deck.getCards().size(); i++) {
            preShuffleDeckCards[i] = deck.getCards().get(i).getName();
        }

        grimoireController.shuffleDeck(deck);

        for (int i = 0; i < deck.getCards().size(); i++) {
            postShuffleDeckCards[i] = deck.getCards().get(i).getName();
        }

        assertThat(preShuffleDeckCards).containsExactlyInAnyOrder(postShuffleDeckCards);

    }
}
