/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.ui.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author paolo mococci
 */

@SpringComponent
@UIScope
@SpringView(name = HelloView.VIEW_NAME)
public class HelloView 
        extends VerticalLayout 
        implements View {
    
    private static final long serialVersionUID = -928200010813944765L;
    private static final Logger HELLOVIEWLOG = LoggerFactory.getLogger(HelloView.class);
    public static final String TITLE_VIEW = "Hello Overview";
    public static final String VIEW_NAME = "";
    public final Label label = new Label(TITLE_VIEW);

    private final TextField name;
    private final Button push;
    private final VerticalLayout content;

    @Autowired
    public HelloView() {
        super();
        this.name = new TextField();
        this.push = new Button("forward", VaadinIcons.ARROW_FORWARD);
        this.content = new VerticalLayout(name, push);
        /* name blur listener */
        name.addBlurListener(listener -> {
            if (name.isEmpty() && null != listener) {
                name.setValue("");
                name.focus();
                Notification.show(
                    "name is required field", 
                    Type.WARNING_MESSAGE);
            }
        });
        /* push click listener */
        push.addClickListener(listener -> {
            if (null != listener) {
                try {
                    if (!name.getValue().matches("[a-zA-Z]{1,20}")) {
                        name.setValue("");
                        name.focus();
                        Notification.show(
                            "typing least an illegal character in name field", 
                            Type.WARNING_MESSAGE);
                    } else {
                        Notification.show(
                            "hello " + name.getValue().toLowerCase(), 
                            Type.HUMANIZED_MESSAGE);
                        name.setValue("");
                        name.focus();
                    }
                } catch (Exception e) {
                    Notification.show(
                            "i'm sorry, error occured", 
                            Notification.Type.ERROR_MESSAGE);
                    HELLOVIEWLOG.error(e.getMessage());
                }
            }
        });
    }

    @PostConstruct
    public void init() {
        /* add components */
        label.addStyleName(ValoTheme.LABEL_H2);
        this.addComponents(label, content);
        /* set property of elements */
        name.setPlaceholder("name");
        name.setDescription("max twenty letter characters without any space");
        name.setRequiredIndicatorVisible(true);
        name.setMaxLength(20);
        content.setMargin(true);
        content.setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        View.super.enter(event);
    }
}
