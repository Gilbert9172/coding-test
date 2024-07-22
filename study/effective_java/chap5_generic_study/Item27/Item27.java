package effective_java.chap5_generic_study.Item27;

import java.util.Arrays;

/**
 * Item 27. Eliminate unchecked warnings
 */
public class Item27 {

    private final int size = 10;

    @SuppressWarnings("unchecked")
    public <T> T[] toArrayV1(T[] a) {
        Object[] elements = {"a", "b", "c"};
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        } else {
            a[size] = null;
            return a;
         }
    }

    /**
     * V2에서는 코드는 깔끔하게 Compile되고, unchecked warning을 숨기는 범위도 최소로 좁혀졌다.
     */
    public <T> T[] toArrayV2(T[] a) {
        Object[] elements = {"a", "b", "c"};
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        } else {
            a[size] = null;
            return a;
        }
    }

    @SuppressWarnings("line 42 - unchecked")
    public <T> T[] toArrayV3(T[] a) {
        Object[] elements = {"a", "b", "c"};
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        } else {
            a[size] = null;
            return a;
        }
    }
}


