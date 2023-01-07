package 클린코드8장;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {

    }

}

class WrapperMap {

    private Map<String, String> wrapperMap = new HashMap<>();

    public WrapperMap(Map<String, String> wrapperMap) {
        this.wrapperMap = wrapperMap;
    }

    public String getById(String id) {
        return wrapperMap.get(id);
    }

}
