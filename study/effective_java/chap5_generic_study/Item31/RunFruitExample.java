package effective_java.chap5_generic_study.Item31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunFruitExample {
    public static void main(String[] args) {
        addItem(Collections.emptyList(), new Apple("red apple"));
    }

    public static void addItem(List<? super Fruit> cart, Fruit item) {
        if (cart.isEmpty()) {
            cart = new ArrayList<>();
        }
        cart.add(item);
    }
}