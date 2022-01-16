package general;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Stores different Categories (filters) for Organizations
 */
public enum Category {
    COOKING("Cooking"), KIDS("Kids"), ANIMALS("Animals"), OUTDOORS("Outdoors"),
    INDOORS("Indoors"), SENIOR_CITIZENS("Senior Citizens"), TUTORING("Tutoring"),
    ART("Art"), SCIENCE("Science"), ENGINEERING("Engineering"),
    AFTER_SCHOOL("After School"),
    SUMMER("Summer"), WINTER_BREAK("Winter Break"), WEEKEND("Weekend");

    public static final Map<String, Category> nameMap = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("Cooking",COOKING),
                new AbstractMap.SimpleEntry<>("Kids", KIDS),
                new AbstractMap.SimpleEntry<>("Animals", ANIMALS),
                new AbstractMap.SimpleEntry<>("Outdoors", OUTDOORS),
                new AbstractMap.SimpleEntry<>("Indoors", INDOORS),
                new AbstractMap.SimpleEntry<>("Senior Citizens", SENIOR_CITIZENS),
                new AbstractMap.SimpleEntry<>("Tutoring", TUTORING),
                new AbstractMap.SimpleEntry<>("Art", ART),
                new AbstractMap.SimpleEntry<>("Science", SCIENCE),
                new AbstractMap.SimpleEntry<>("Engineering", ENGINEERING),
                new AbstractMap.SimpleEntry<>("After School", AFTER_SCHOOL),
                new AbstractMap.SimpleEntry<>("Summer", SUMMER),
                new AbstractMap.SimpleEntry<>("Winter Break", WINTER_BREAK),
                new AbstractMap.SimpleEntry<>("Weekend", WEEKEND)
        );

    // Stores the name of this Category
    private final String name;

    /**
     * Creates a new Category
     */
    Category(String name) {
        this.name = name;
    }

    public static Category getCategory(String name){
        return nameMap.get(name);
    }

    /**
     * Finds the name of this Category
     * @return this.name
     */
    public String getName() {
        return this.name;
    }
}
