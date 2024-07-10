package com.example.buttonandlabel;

import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set title: ");

        String settingTitle = scanner.nextLine();
        Application.launch(UserTitle.class,
                "--title="+ settingTitle);
    }
}

/*
package com.example.buttonandlabel;

import com.example.buttonandlabel.UserTitle;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Application.launch(UserTitle.class,
                "--organization=Once upon a time",
                "--course=Title");
    }
}*/
