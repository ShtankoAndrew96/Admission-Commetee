package ua.training.committee.model.university;


import ua.training.committee.model.Document;
import ua.training.committee.model.DocumentHolder;

import java.util.ArrayList;

public abstract class University {
    ArrayList<Document> applyDocuments;
    DocumentHolder documentHolder;
    int sleepTime;
    String name;

    public University(String name, DocumentHolder documentHolder, int sleepTime){
        this.name = name;
        applyDocuments = new ArrayList<Document>();
        this.documentHolder = documentHolder;
        this.sleepTime=sleepTime;
    }

    public synchronized void applyStudents(){
        while(criteria() && !documentHolder.isQueueEmpty()){
            applyDocuments.add(documentHolder.takeDocumentFromQueue());
        }
    }

    public int getStudentsAmount(){
        return applyDocuments.size();
    }

    public String getName(){
        return name;
    }

    public int getSleepTime(){
        return sleepTime;
    }

    public abstract boolean criteria();

}
