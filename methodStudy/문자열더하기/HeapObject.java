package 문자열더하기;

import java.io.*;

public class HeapObject implements Serializable, Cloneable {

    private final String name;

    public HeapObject(String name) {
        this.name = name;
    }

    @Override
    public HeapObject clone() throws CloneNotSupportedException {
        return (HeapObject) super.clone();
    }

    private static HeapObject serializeAndDesirialize(HeapObject t1) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(t1);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(baos.toByteArray()));
        return (HeapObject) ois.readObject();

    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        HeapObject t1 = new HeapObject("test");
        HeapObject t2 = t1.clone();
        HeapObject t3 = serializeAndDesirialize(t1);
        HeapObject t4 = t1;
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);
        System.out.println("t4 = " + t4);
    }
}
