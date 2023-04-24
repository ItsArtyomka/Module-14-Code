import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
public final class ImmutableClassExample {

    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public ImmutableClassExample(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFoods() {
        return new ArrayList<>(favoriteFoods);
    }
}