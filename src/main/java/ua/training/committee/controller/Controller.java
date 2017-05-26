package ua.training.committee.controller;

import ua.training.committee.GlobalConstants;
import ua.training.committee.model.DocumentHolder;
import ua.training.committee.model.university.AllScienceUniversity;
import ua.training.committee.model.university.BiologicalUniversity;
import ua.training.committee.model.university.MathUniversity;
import ua.training.committee.model.university.University;
import ua.training.committee.view.View;

import java.util.ArrayList;


public class Controller implements GlobalConstants{

    private View view;
    private DocumentHolder documentHolder;
    private ArrayList<University> universities;

    public Controller(View view){
        generateUniversities();
        documentHolder = new DocumentHolder();
        this.view = view;
    }

    public void process(){
        generateUniversities();

        new Thread(new Runnable() {
            public void run() {
                while(!documentHolder.isStorageEmpry()){
                    if(documentHolder.getQueueSize()<MIN_AMOUNT_IN_QUEUE){
                        for(int i=0; i<AMOUNT_TO_ADD; i++){
                            documentHolder.addDocumentToQueue();
                        }
                    }
                }
            }
        }).start();

        for(final University university: universities){
            new Thread(new Runnable() {
                public void run() {
                    while (!documentHolder.isQueueEmpty() || !documentHolder.isStorageEmpry()){
                        universityProcess(university);
                        try {
                            Thread.sleep(university.getSleepTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    view.printMessage(university.getName()+COLUMN+SPACE+university.getStudentsAmount());

                }
            }).start();
        }

    }

    private void universityProcess(University university){
        if(university instanceof AllScienceUniversity){
            ((AllScienceUniversity) university).generateRandNumber();
        }
        university.applyStudents();
    }

    private void generateUniversities(){
        universities = new ArrayList<University>();
        universities.add(new AllScienceUniversity(documentHolder));
        universities.add(new BiologicalUniversity(documentHolder));
        universities.add(new MathUniversity(documentHolder));
    }
}
