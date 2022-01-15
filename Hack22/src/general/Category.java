package general;

/**
 * Stores different Categories (filters) for Organizations
 */
public enum Category {
    COOKING("Cooking"),
    KIDS("Kids"),
    ANIMALS("Animals"),
    OUTDOORS("Outdoors"),
    INDOORS("Indoors"),
    SENIOR_CITIZENS("Senior Citizens"),
    TUTORING("Tutoring"),
    ART("Art"),
    SCIENCE("Science"),
    ENGINEERING("Engineering"),
    AFTER_SCHOOL("After School"),
    SUMMER("Summer"),
    WINTER_BREAK("Winter Break"),
    WEEKEND("Weekend");

    // Stores the name of this Category
    private final String name;

    /**
     * Creates a new Category
     * @param name the name of this Category
     */
    Category(String name) {
        this.name = name;
    }

    /**
     * Finds the name of this Category
     * @return this.name
     */
    public String getName() {
        return this.name;
    }
}
