package views;


import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.ExilePileModel;

@Getter
public class ExilePileView {
    private final ExilePileModel exilePileModel;

    public ExilePileView(ExilePileModel exilePileModel) {
        this.exilePileModel = exilePileModel;
    }

    public Panel getPanel() {
        Label exilePileLabel = new Label("Exiled Cards: " + exilePileModel.getCards().size());
        final Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(exilePileLabel);
        System.out.println("EXILEEEE");
        return panel;
    }

}
