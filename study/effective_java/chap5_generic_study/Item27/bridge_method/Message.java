package effective_java.chap5_generic_study.Item27.bridge_method;

public class Message<T> {
    public T payload;

    public void payload(T payload) {
        this.payload = payload;
    }
}
