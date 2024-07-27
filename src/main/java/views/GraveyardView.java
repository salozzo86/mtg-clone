package views;

import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import models.GraveyardModel;

public class GraveyardView {
    private final GraveyardModel graveyardModel;

    public GraveyardView(GraveyardModel graveyardModel) {
        this.graveyardModel = graveyardModel;
    }

    public Panel getPanel() {
        Label graveyardLabel = new Label("Graveyard: " + graveyardModel.getCards().size());
        final Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(graveyardLabel);
        return panel;
    }
}
