package demoZK.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;


/**
 * Created by Admin on 24.05.2017.
 */
public class ModaldialogController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;

    @Listen("onClick = #saleBtn")
    public void showModal(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window) Executions.createComponents(
                "/widgets/window/modal_dialog/saccessfull.zul", null, null);
        window.doModal();
    }

    @Listen("onClick = #return")
    public void showIndex(Event e) {
            Executions.sendRedirect("index.zul");

    }

    @Listen("onClick = #welcome")
    public void showPayForm(Event e) {
       Executions.sendRedirect("payWindow.zul");
    }
}
