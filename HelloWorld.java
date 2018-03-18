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

package local.example.draft.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import local.example.draft.ui.view.ErrorView;
import local.example.draft.ui.view.HelloView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author paolo mococci
 */

@SpringViewDisplay
@SpringUI(path = "/")
@Theme(value = "valo")
@Title(value = HelloWorld.TITLE)
public class HelloWorld 
        extends UI 
        implements ViewDisplay {

    private static final long serialVersionUID = 604163411062432142L;
    protected static final String TITLE = "Hello World Draft";
    protected static final String HTML_TITLE = "<h1><em>Hello World Draft</em></h1>";
    protected static final float SIZE_PANEL = 1.0f;
    private final Label title = new Label(HTML_TITLE, ContentMode.HTML);
    private final CssLayout nav = new CssLayout();
    private final VerticalLayout main = new VerticalLayout();
    private Panel panel;

    @Autowired
    SpringNavigator springNavigator;

    @Autowired
    public HelloWorld() {
        super();
    }

    @PostConstruct
    public void init() {
        springNavigator.setErrorView(ErrorView.class);
        panel = new Panel();
        panel.setSizeFull();
    }

    @Override
    protected void init(VaadinRequest request) {
        /* navigation components */
        nav.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        nav.addComponent(setNavButton(HelloView.TITLE_VIEW, HelloView.VIEW_NAME));
        /* main components */
        nav.setVisible(false);
        main.setSizeFull();
        main.addComponents(title, nav, panel);
        main.setExpandRatio(panel, SIZE_PANEL);
        /* set contents in user interface */
        this.setContent(main);
    }

    @Override
    public void showView(View view) {
        panel.setContent((Component)view);
    }

    /* for setting navigation bar elements */
    private Button setNavButton(String title, String viewName) {
        Button button = new Button(title);
        button.addClickListener(listener -> {
            this.getUI().getNavigator().navigateTo(viewName);
        });
        return button;
    }
}
