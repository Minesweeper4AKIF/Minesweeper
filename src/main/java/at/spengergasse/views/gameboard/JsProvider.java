package at.spengergasse.views.gameboard;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;

@JsModule("./handleRightClick.js")
@JsModule("./disableContextMenu.js")
public class JsProvider extends Div {
}
