package user;

import operation.Ioperation;

public abstract class User {
    String name;
    public Ioperation[] iopertions;
    public User(String name){
        this.name=name;
    }
    public abstract int menu();
}