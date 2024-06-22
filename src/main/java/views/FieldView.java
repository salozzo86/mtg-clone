package views;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
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

    public FieldView() {
        window = new BasicWindow();

        Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));
        DeckController deckController = new DeckController();

        // Initialize models
        LifePointsModel opponentLifePoints = new LifePointsModel();
        LifePointsModel playerLifePoints = new LifePointsModel();
        DeckModel opponentDeck = new DeckModel(deckController.generateDeck(60).getCards());
        DeckModel playerDeck = new DeckModel(deckController.generateDeck(60).getCards());
        FieldModel fieldModel = new FieldModel(playerLifePoints, opponentLifePoints, playerDeck, opponentDeck);


        // Initialize views and add them to panels


        // opponent panel
        Panel opponentPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        Panel opponentHandPanel = new Panel(new GridLayout(1));
        Panel opponentDecksPanel = new Panel(new GridLayout(1));
        opponentLifePointsView = new LifePointsView(fieldModel);
        opponentPanel.addComponent(new Label("Opponent"));
        opponentPanel.addComponent(opponentLifePointsView.getPanel());
        opponentPanel.addComponent(opponentHandPanel);
        opponentPanel.addComponent(opponentDecksPanel);


        // field panel
        Panel fieldPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        fieldPanel.addComponent(new Label("Field"));

        // player panel
        Panel playerPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        Panel playerHandPanel = new Panel(new GridLayout(1));
        Panel playerDecksPanel = new Panel(new GridLayout(1));
        playerLifePointsView = new LifePointsView(fieldModel);
        playerPanel.addComponent(new Label("Player"));
        playerPanel.addComponent(playerLifePointsView.getPanel());
        playerPanel.addComponent(playerHandPanel);
        playerPanel.addComponent(playerDecksPanel);


        mainPanel.addComponent(opponentPanel);
        mainPanel.addComponent(fieldPanel);
        mainPanel.addComponent(playerPanel);
        window.setComponent(mainPanel);
    }

}
