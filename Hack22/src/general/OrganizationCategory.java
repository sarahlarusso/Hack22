package general;

/**
 * Stores different categories of
 */
public enum OrganizationCategory {
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
    WINTER_BREAK("Winter Break");

    // Stores the name of this OrganizationCategory
    private final String name;

    /**
     * Creates a new OrganizationCategory
     * @param name the name of this OrganizationCategory
     */
    OrganizationCategory(String name) {
        this.name = name;
    }

    /**
     * Finds the name of this OrganizationCategory
     * @return this.name
     */
    public String getName() {
        return this.name;
    }
}
