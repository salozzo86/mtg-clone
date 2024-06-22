import controllers.DeckController;
import models.DeckModel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DeckControllerTest {

    @Test
    public void deckControllerGenerationTest() {
        DeckController deckController = new DeckController();
        DeckModel deck = deckController.generateDeck(60);

        assertThat(deck.getCards().size()).isEqualTo(60);

    }

    @Test
    public void deckControllerShuffleTest() {
        DeckController deckController = new DeckController();
        DeckModel deck = deckController.generateDeck(60);

        String[] preShuffleDeckCards = new String[60];
        String[] postShuffleDeckCards = new String[60];

        for (int i = 0; i < deck.getCards().size(); i++) {
            preShuffleDeckCards[i] = deck.getCards().get(i).getName();
        }

        deckController.shuffleDeck(deck);

        for (int i = 0; i < deck.getCards().size(); i++) {
            postShuffleDeckCards[i] = deck.getCards().get(i).getName();
        }

        assertThat(preShuffleDeckCards).containsExactlyInAnyOrder(postShuffleDeckCards);

    }
}
