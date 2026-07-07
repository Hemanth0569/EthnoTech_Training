package Generics.Learn;

public class Content <T> {
    T name;

    public void setName(T name){
        this.name=name;
    }
    public T getName(){
        return name;
    }
}
