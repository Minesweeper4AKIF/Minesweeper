package at.spengergasse.views.gameboard;

import at.spengergasse.components.MinesWeeperButton;
import at.spengergasse.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.Random;


@PageTitle("Minesweeper Game Board")
@Route(value = "minesweeper", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class GameBoard extends HorizontalLayout {
    private int N = 15; // TODO number of mines to be placed

    // private MineBoard mineBoard; // TODO to be implemented
    // private CountBoard countBoard; // TODO to be implemented

    public void handleRightClick() {
        Notification.show("Right mouse click detected!");
        System.out.println("Right Click");
    }

    public GameBoard() {
        initUI();
    }

    private void initUI() {
        VerticalLayout vl = new VerticalLayout();
        vl.setPadding(false);
        vl.setSpacing(false);
        vl.setMargin(false);

        for (int i=0; i<N; i++) {
            HorizontalLayout hl = new HorizontalLayout();
            hl.setPadding(false);
            hl.setSpacing(false);
            hl.setMargin(false);

            for (int j=0; j<N; j++) {
                MinesWeeperButton btn = new MinesWeeperButton(i, j);
                btn.setButtonValue((new Random()).nextInt(8)+1); //  to demonstrate possible values

                UI.getCurrent().getPage().executeJs("return ns.init($0, $1, $2, $3)", btn, this, i, j);
                btn.addClickListener(this::onBoardEntryClicked);
                // btn.addSingleClickListener(this::onBoardEntryClicked);

                hl.add(btn);
            }
            vl.add(hl);
        }
        add(vl);
    }

    @ClientCallable
    public void btnRightClicked(int row, int column) {
        System.out.println("Java: Right click (event via JS) in " + row + ", " + column);
    }

    private void onBoardEntryClicked(ClickEvent<Button> e) {
        System.out.println("Left Click Handler --------------");
        if (e.getSource().getClass().equals(MinesWeeperButton.class)) {
            MinesWeeperButton mwb = (MinesWeeperButton) e.getSource();
            int row = mwb.getRow();
            int col = mwb.getCol();

            if (e.getButton() == 0) {
                System.out.println("Left click in " + row + ", " + col);
            } else if (e.getButton() == 2) {
                System.out.println("Right click in " + row + ", " + col);
            } else {
                System.out.println("other click in " + row + ", " + col);
            }

        } else {
            System.out.println("Got other button");
        }
    }



}
