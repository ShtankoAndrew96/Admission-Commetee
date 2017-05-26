package ua.training.committee.model.university;

import ua.training.committee.GlobalConstants;
import ua.training.committee.model.Document;
import ua.training.committee.model.DocumentHolder;
import ua.training.committee.model.Type;


public class BiologicalUniversity extends University implements GlobalConstants {

    public BiologicalUniversity(DocumentHolder documentHolder) {
        super(BIOLOGIC_UNIVERSITY, documentHolder, SLEEP_BIO);
    }

    public boolean criteria() {
        Document document;
        try{
            document = documentHolder.viewDocumentFromQueue();
        }catch (RuntimeException e){
            return false;
        }
        return document.getType().equals(Type.BIOLOGY);
    }

}
