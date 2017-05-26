package ua.training.committee.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DocumentHolder {
    ArrayList<Document> documentStorage;
    BlockingQueue<Document> documentQueue;

    public DocumentHolder(){
        generateStorage();
        documentQueue = new LinkedBlockingQueue<Document>();
    }

    public void addDocumentToQueue(){
        if(!documentStorage.isEmpty()){
            documentQueue.add(documentStorage.get(0));
            documentStorage.remove(0);
        }
    }

    public Document viewDocumentFromQueue(){
        if(!isQueueEmpty()) {
            return documentQueue.peek();
        }
        throw new RuntimeException("Queue is empty");
    }

    public Document takeDocumentFromQueue(){
        if(!isQueueEmpty()){
            return documentQueue.poll();
        }
        throw new RuntimeException("Queue is empty");
    }

    public boolean isStorageEmpry(){
        return documentStorage.isEmpty();
    }

    public boolean isQueueEmpty(){
        return documentQueue.isEmpty();
    }

    public int getQueueSize(){
        return documentQueue.size();
    }

    private void generateStorage(){
        documentStorage = new ArrayList<Document>();
        for(int i=0; i<Type.BIOLOGY.getMaxAmount(); i++){
            documentStorage.add(new Document(Type.BIOLOGY));
        }
        for(int i=0; i<Type.MATH.getMaxAmount(); i++){
            documentStorage.add(new Document(Type.MATH));
        }
        Collections.shuffle(documentStorage);
    }
}
