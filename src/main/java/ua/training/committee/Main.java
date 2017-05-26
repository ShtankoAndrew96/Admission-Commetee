package ua.training.committee;


import ua.training.committee.controller.Controller;
import ua.training.committee.view.View;

public class Main {
    public static void main(String [] args){
        View view = new View();
        Controller controller = new Controller(view);

        controller.process();
    }
}
