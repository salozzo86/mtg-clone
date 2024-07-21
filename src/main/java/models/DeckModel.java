package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class DeckModel {
    List<CardModel> cards;

//    public List<CardModel> draw(DeckModel deck, int count) {
//        return deck.getCards().subList(0, count);
//    }

    public List<CardModel> drawCards(int count) {
        List<CardModel> drawnCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!cards.isEmpty()) {
                drawnCards.add(cards.remove(0));
            }
        }
        return drawnCards;
    }
}
