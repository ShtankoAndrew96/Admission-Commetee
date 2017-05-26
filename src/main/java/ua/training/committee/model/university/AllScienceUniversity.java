package ua.training.committee.model.university;


import ua.training.committee.GlobalConstants;
import ua.training.committee.model.DocumentHolder;

public class AllScienceUniversity extends University implements GlobalConstants{

    private int randNumber;

    public AllScienceUniversity(DocumentHolder documentHolder) {
        super(ALL_SCIENCE_UNIVERSITY, documentHolder, SLEEP_POLY);
    }

    public boolean criteria() {
        randNumber--;
        return randNumber > 0;
    }

    public void generateRandNumber(){
        randNumber = 1 + (int) Math.ceil(Math.random()*4);
    }
}
