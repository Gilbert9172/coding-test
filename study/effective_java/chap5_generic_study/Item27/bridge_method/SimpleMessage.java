package effective_java.chap5_generic_study.Item27.bridge_method;

public class SimpleMessage {
    String payload;

    public SimpleMessage(String payload) {
        this.payload = payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
