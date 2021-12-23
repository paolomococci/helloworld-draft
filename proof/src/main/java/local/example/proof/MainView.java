package local.example.proof;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route("")
public class MainView
        extends VerticalLayout {

    @Inject
    GreetService greetService;

    public MainView() {
        TextField guestNameTextField = new TextField("Please enter your name:");
        guestNameTextField.addThemeName("bordered");

        Button helloButton = new Button("Hello", e -> {
            Notification.show(greetService.greet(guestNameTextField.getValue()));
            guestNameTextField.setValue("");
        });

        helloButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        helloButton.addClickShortcut(Key.ENTER);

        add(guestNameTextField, helloButton);
    }
}
