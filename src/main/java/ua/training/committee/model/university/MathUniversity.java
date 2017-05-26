package ua.training.committee.model.university;

import ua.training.committee.GlobalConstants;
import ua.training.committee.model.Document;
import ua.training.committee.model.DocumentHolder;
import ua.training.committee.model.Type;

public class MathUniversity extends University implements GlobalConstants {
    public MathUniversity(DocumentHolder documentHolder) {
        super(MATH_UNIVERSITY, documentHolder, SLEEP_MATH);
    }

    public boolean criteria() {
        Document document;
        try{
            document = documentHolder.viewDocumentFromQueue();
        }catch (RuntimeException e){
            return false;
        }
        return document.getType().equals(Type.MATH);
    }
}
