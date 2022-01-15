package general;

import java.util.List;

public class Organization {
    //Stores all OrganizationCategories
    private final HashList<OrganizationCategory> organizationCategories;

    /**
     * Creates a new Organization with no OrganizationCategories
     */
    public Organization() {
        this.organizationCategories = new HashList<>();
    }

    public Organization(Iterable<OrganizationCategory> iterable) {
        this.organizationCategories = new HashList<>();
    }
}
