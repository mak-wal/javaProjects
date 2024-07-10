package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

import java.util.Scanner;


public class UserTitle extends Application {

    @Override
    public void start(Stage window) {



        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("title");

        window.setTitle(title);
        window.show();
    }
}

/*
package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String organization = params.getNamed().get("organization");
        String course = params.getNamed().get("course");

        window.setTitle(organization + ": " + course);
        window.show();
    }
}*/
