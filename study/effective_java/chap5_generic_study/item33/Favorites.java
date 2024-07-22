package effective_java.chap5_generic_study.item33;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {

    private static final Map<Class<?>, Object> favorites = new HashMap<>();
    private static final Map<?, Object> favoritesV2 = new HashMap<>();

    public static <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public static <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        favorites.put(Integer.class, "new");

    }
}
