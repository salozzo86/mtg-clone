package views;

import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.DeckModel;

public class DeckView {
    private final DeckModel deckModel;

    public DeckView(DeckModel deckModel) {
        this.deckModel = deckModel;
    }

    // Rerender every time, do not try to update existing ones
    public Panel getPanel () {
        final Label deckLabel = new Label("Deck: " + deckModel.getCards().size());
        final Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(deckLabel);
        return panel;
    }
}
