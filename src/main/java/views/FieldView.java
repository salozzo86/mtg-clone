package views;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import controllers.DeckController;
import lombok.Getter;
import models.CardModel;
import models.DeckModel;
import models.ExilePileModel;
import models.FieldModel;
import models.GraveyardModel;
import models.HandModel;
import models.LifePointsModel;

import java.util.List;

@Getter
public class FieldView {
    private final Window window;

    // TODO Consolidate the below duplication in a PlayerView class
    private final LifePointsView playerLifePointsView;
    private final LifePointsView opponentLifePointsView;
    private final DeckView playerDeckView;
    private final DeckView opponentDeckView;
    private final GraveyardView playerGraveyardView;
    private final GraveyardView opponentGraveyardView;
    private final ExilePileView playerExilePileView;
    private final ExilePileView opponentExilePileView;
    private final HandView playerHandView;
    private final HandView opponentHandView;
    private final ActionMenuView actionMenuView;


    public FieldView() {
        window = new BasicWindow();

        Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        FieldModel fieldModel = getFieldModel();


        // Initialize views and add them to panels

        // opponent panel
        Panel opponentPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        Panel opponentHandPanel = new Panel(new GridLayout(1));
        Panel opponentDecksPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        opponentLifePointsView = new LifePointsView(fieldModel.getOpponentLifePoints());
        opponentDeckView = new DeckView(fieldModel.getOpponentDeck());
        opponentGraveyardView = new GraveyardView(fieldModel.getOpponentGraveyard());
        opponentExilePileView = new ExilePileView(fieldModel.getOpponentExilePile());

        opponentPanel.addComponent(new Label("Opponent"));
        opponentPanel.addComponent(opponentLifePointsView.getPanel());
        opponentPanel.addComponent(opponentHandPanel);
        opponentHandView = new HandView();
        List<CardModel> opponentHandCards = fieldModel.getOpponentDeck().drawCards(7);

        for (CardModel card : opponentHandCards) {
            CardView cardView = new CardView(card);
            opponentHandView.addCard(cardView);
        }

        opponentHandPanel.addComponent(opponentHandView.getMainPanel());
        opponentDecksPanel.addComponent(opponentDeckView.getPanel());
        opponentDecksPanel.addComponent(opponentGraveyardView.getPanel());
        opponentDecksPanel.addComponent(opponentExilePileView.getPanel());
        opponentPanel.addComponent(opponentDecksPanel);


        // field panel
        Panel fieldPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        actionMenuView = new ActionMenuView();
        fieldPanel.addComponent(new Label("Field"));
        fieldPanel.addComponent(actionMenuView.getContentPanel());

        // player panel
        Panel playerPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
        Panel playerHandPanel = new Panel(new GridLayout(1));
        Panel playerDecksPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        playerLifePointsView = new LifePointsView(fieldModel.getPlayerLifePoints());
        playerDeckView = new DeckView(fieldModel.getPlayerDeck());
        playerGraveyardView = new GraveyardView(fieldModel.getPlayerGraveyard());
        playerExilePileView = new ExilePileView(fieldModel.getPlayerExilePile());


        playerPanel.addComponent(new Label("Player"));
        playerPanel.addComponent(playerLifePointsView.getPanel());
        playerPanel.addComponent(playerHandPanel);
        playerHandView = new HandView();
        List<CardModel> playerHandCards = fieldModel.getPlayerDeck().drawCards(7);

        for (CardModel card : playerHandCards) {
            CardView cardView = new CardView(card);
            playerHandView.addCard(cardView);
        }

        // update the deck label
        //playerDeckView.updateDeckLabel(fieldModel.getPlayerDeck().getCards().size());

        playerHandPanel.addComponent(playerHandView.getMainPanel());
        playerDecksPanel.addComponent(playerDeckView.getPanel());
        playerDecksPanel.addComponent(playerGraveyardView.getPanel());
        playerDecksPanel.addComponent(playerExilePileView.getPanel());
        playerPanel.addComponent(playerDecksPanel);

        // add everything to the main panel
        mainPanel.addComponent(opponentPanel);
        mainPanel.addComponent(fieldPanel);
        mainPanel.addComponent(playerPanel);
        window.setComponent(mainPanel);
    }

    private static FieldModel getFieldModel() {
        // Initialize controllers
        DeckController deckController = new DeckController();

        // Initialize models
        LifePointsModel playerLifePoints = new LifePointsModel();
        LifePointsModel opponentLifePoints = new LifePointsModel();

        DeckModel playerDeck = new DeckModel(deckController.generateDeck(60).getCards());
        DeckModel opponentDeck = new DeckModel(deckController.generateDeck(60).getCards());

        GraveyardModel playerGraveyard = new GraveyardModel();
        GraveyardModel opponentGraveyard = new GraveyardModel();

        ExilePileModel playerExilePile = new ExilePileModel();
        ExilePileModel opponentExilePile = new ExilePileModel();

        HandModel playerHand = new HandModel();
        HandModel opponentHand = new HandModel();



        return new FieldModel(
                playerLifePoints,
                opponentLifePoints,
                playerDeck,
                opponentDeck,
                playerGraveyard,
                opponentGraveyard,
                playerExilePile,
                opponentExilePile,
                playerHand,
                opponentHand);
    }

}
