package SerializationandDeserialization.Serialization;

import java.io.Serializable;

public class SER implements Serializable {

    int id;
    String name;

    public SER(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display(){
        System.out.println(id);
        System.out.println(name);
    }
}
