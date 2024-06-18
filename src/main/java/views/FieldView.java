package views;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import controllers.DeckController;
import lombok.Getter;
import models.DeckModel;
import models.FieldModel;
import models.LifePointsModel;

@Getter
public class FieldView {
    private final Window window;
    private final LifePointsView playerLifePointsView;
    private final LifePointsView opponentLifePointsView;
    private final Label playerDeckLabel;
    private final Label opponentDeckLabel;

    public FieldView() {
        window = new BasicWindow();

        Panel contentPanel = new Panel(new GridLayout(1));
        DeckController deckController = new DeckController();

        LifePointsModel playerLifePoints = new LifePointsModel();
        LifePointsModel opponentLifePoints = new LifePointsModel();
        DeckModel playerDeck = new DeckModel(deckController.generateDeck(60).getCards());
        DeckModel opponentDeck = new DeckModel(deckController.generateDeck(60).getCards());
        FieldModel fieldModel = new FieldModel(playerLifePoints, opponentLifePoints, playerDeck, opponentDeck);
        playerLifePointsView = new LifePointsView(fieldModel);
        opponentLifePointsView = new LifePointsView(fieldModel);



        playerDeckLabel = new Label("Player Deck Cards: " + playerDeck.getCards().size());
        opponentDeckLabel = new Label("Opponent Deck Cards: " + playerDeck.getCards().size());



        contentPanel.addComponent(playerLifePointsView.getPanel());
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(opponentLifePointsView.getPanel());
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(playerDeckLabel);
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(opponentDeckLabel);


        window.setComponent(contentPanel);
    }

}
