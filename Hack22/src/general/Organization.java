package general;

/**
 * Stores community service Organizations recognized by this Application
 */
public class Organization {
    //The name of this Organization
    private String name;
    //Stores all Categories
    private final HashList<Category> organizationCategories;

    /**
     * Creates a new Organization with no Categories
     */
    public Organization() {
        setName("");
        this.organizationCategories = new HashList<>();
    }

    /**
     * Creates a new Organization with a specified Iterable list of Categories
     * @param iterable the list of Categories
     */
    public Organization(String name, Iterable<Category> iterable) {
        setName(name);
        this.organizationCategories = new HashList<>(iterable);
    }

    /**
     * Resets the name of this Organization
     * @param name the new name for this Organization
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of this Organization
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a new Category
     * @param category the specified Category
     * @return false if the Category already existed in this Organization, else true
     */
    public boolean add(Category category) {
        return this.organizationCategories.add(category);
    }

    /**
     * Removes a Category from this Organization
     * @param category the target Category
     * @return true if the specified Category is removed from this Organization, else false
     */
    public boolean remove(Category category) {
        return this.organizationCategories.remove(category);
    }

    /**
     * Determines whether this Organization is described by a specific Category
     * @param category the target Category
     * @return true if the specified Category is contained in this Organization's list of Categories, else false
     */
    public boolean contains(Category category) {
        return this.organizationCategories.contains(category);
    }
}
