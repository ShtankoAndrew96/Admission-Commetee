package ua.training.committee.model;

public enum Type {
    MATH(250),BIOLOGY(200);


    private int maxAmount;

    Type(int maxAmount){
        this.maxAmount=maxAmount;
    }

    public int getMaxAmount(){
        return maxAmount;
    }
}
