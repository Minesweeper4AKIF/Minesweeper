package at.spengergasse.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;


public class MinesWeeperButton extends Button {

    private final String SIZE = "35px";
    private int row;
    private int col;

    public enum ButtonValues { EMPTY, MINE, FLAG };

    public MinesWeeperButton(int row, int col) {
        // this.setIcon(new Icon(VaadinIcon.FLAG));
        this.row = row;
        this.col = col;
        this.getStyle().set("min-width", SIZE);
        this.getStyle().set("min-height", SIZE);

        this.getStyle().set("width", SIZE);
        this.getStyle().set("height", SIZE);
        this.getStyle().set("border", "black solid 1px");
        this.getStyle().set("border-radius", "0px");
        this.getStyle().set("margin", "0px");
        this.getStyle().set("font-weight", "bold");
        this.getStyle().set("font-size", "1.5rem");
    }

    public void setButtonValue(int v) {
        if (v > 0 && v < 9) {
            this.setIcon(null);
            this.addClassName("minesweeper-button");
            switch (v) {
                // case 0: this.getStyle().set("color", "red"); break;
                case 1: this.getStyle().set("color", "blue"); break;
                case 2: this.getStyle().set("color", "green"); break;
                case 3: this.getStyle().set("color", "red"); break;
                case 4: this.getStyle().set("color", "darkblue"); break;
                case 5: this.getStyle().set("color", "brown"); break;
                case 6: this.getStyle().set("color", "cyan"); break;
                case 7: this.getStyle().set("color", "black"); break;
                case 8: this.getStyle().set("color", "pink"); break;
            }
            this.setText(String.valueOf(v));
        } else {
            throw new IllegalArgumentException("Invalid argument" + v);
        }
    }

    public void setButtonValue(ButtonValues bv) {
        switch (bv) {
            case EMPTY:
                this.setIcon(null);
                break;
            case MINE:
                Icon ic = new Icon(VaadinIcon.BOMB);
                ic.setColor("black");
                this.setIcon(ic);
                break;
            case FLAG:
                Icon icFlag = new Icon(VaadinIcon.FLAG);
                icFlag.setColor("red");
                this.setIcon(icFlag);
                break;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void debug_assignRandomType() {
        switch ((row*col)%12) {
            case 9:
                this.setButtonValue(MinesWeeperButton.ButtonValues.FLAG);
                break;
            case 10:
                this.setButtonValue(MinesWeeperButton.ButtonValues.MINE);
                break;
            case 11:
                this.setButtonValue(MinesWeeperButton.ButtonValues.EMPTY);
                break;
            case 1, 2, 3, 4, 5, 6, 7, 8:
                this.setButtonValue(row*col%8+1);
                break;
        }
    }

    @Override
    public String toString() {
        return "MinesWeeperButton{" +
                "SIZE='" + SIZE + '\'' +
                ", row=" + row +
                ", col=" + col +
                '}';
    }

}
