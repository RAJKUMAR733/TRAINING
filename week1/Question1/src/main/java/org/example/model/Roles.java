package org.example.model;

public enum Roles {
    MANAGER(45),
    SRASSOCIATE(30),
    ASSOCIATE(20);
    private final int increment;

    Roles(int increment){
        this.increment=increment;
    }

    public int getIncrement(){
        return increment;
    }

}
