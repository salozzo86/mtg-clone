package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class DeckModel {
    List<CardModel> cards;

    public List<CardModel> drawCards(int count) {
        List<CardModel> drawnCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!cards.isEmpty()) {
                drawnCards.add(cards.removeFirst());
            }
        }
        return drawnCards;
    }
}
