package local.example.draft.views.hello;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

import local.example.draft.views.MainLayout;

@PageTitle("Hello")
@Route(value = "hello", layout = MainLayout.class)
@RolesAllowed("user")
public class HelloView
        extends HorizontalLayout {

    private final TextField nameTextField;

    public HelloView() {
        nameTextField = new TextField("Please enter your name:");
        Button helloButton = new Button("Hello");
        helloButton.addClickListener(e -> {
                Notification.show("Hello " + nameTextField.getValue() + "!");
                nemeTextField.setValue("");
        });
        helloButton.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(
                Alignment.END,
                nameTextField,
                helloButton
        );

        add(nameTextField, helloButton);
    }
}
