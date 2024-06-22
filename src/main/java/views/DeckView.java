package views;

import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.DeckModel;

@Getter
public class DeckView {
    private final Panel panel;

    public DeckView(DeckModel deckModel) {
        Label deckLabel = new Label("Deck: " + deckModel.getCards().size());
        panel = new Panel(new GridLayout(1));
        panel.addComponent(deckLabel);
    }
}
