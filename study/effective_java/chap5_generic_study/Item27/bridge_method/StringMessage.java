package effective_java.chap5_generic_study.Item27.bridge_method;

public class StringMessage extends Message<String> {
    @Override
    public void payload(String payload) {
        super.payload(payload);
    }
}
