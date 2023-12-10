package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.component.button.Button;




import java.awt.*;

@Route("")
public class MainView extends VerticalLayout {
    private  AnimalRepository repository;
    private TextField name = new TextField("name");
    private TextField age = new TextField("age");
    private TextField healthStatus = new TextField("healthStatus");
    private Binder<Animal> binder = new Binder<>(Animal.class);
    private Grid<Animal> grid = new Grid<>(Animal.class);


    public MainView(AnimalRepository repository){
        this.repository = repository;
        add(new H1(("ZOO")));
        grid.setColumns("name", "age", "healthStatus");

        add(getForm(), grid);
        refreshGrid();
    }

    private Component getForm() {
        var layout = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);
        var addButton = new Button("Add");
        addButton.addClickShortcut(Key.ENTER);
        layout.add(name, age, healthStatus, addButton);

        binder.bindInstanceFields(this);

        addButton.addClickListener(click -> {
            try{
                var Animal = new Animal();
                binder.writeBean(Animal);
                repository.save(Animal);
                binder.readBean(new Animal());
                refreshGrid();

            }catch (ValidationException e) {
                //
            }
        });

        return layout;
    }

    private void refreshGrid(){
        grid.setItems(repository.findAll());
    }
}
