package views;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.CardModel;

@Getter
public class CardView {
    private final Panel mainPanel;
    private final Panel namePanel;
    private final Panel manaCostPanel;
    private final Panel typePanel;
    private final Panel subtypePanel;
    private final Panel rarityPanel;

    public CardView(CardModel cardModel) {
        mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        Label nameLabel = new Label(cardModel.getName());
        namePanel = new Panel(new GridLayout(1));

        Label manaCostLabel = new Label(String.valueOf(cardModel.getManaCost()));
        manaCostPanel = new Panel(new GridLayout(1));

        Label typeLabel = new Label(cardModel.getType().getType().toString());
        typePanel = new Panel(new GridLayout(1));

        Label subtypeLabel = new Label(cardModel.getSubType().getName());
        subtypePanel = new Panel(new GridLayout(1));

        Label rarityLabel = new Label(cardModel.getRarity().toString());
        rarityPanel = new Panel(new GridLayout(1));

        mainPanel.addComponent(nameLabel);
        mainPanel.addComponent(manaCostLabel);
        mainPanel.addComponent(typeLabel);
        mainPanel.addComponent(subtypeLabel);
        mainPanel.addComponent(rarityLabel);

    }
}
