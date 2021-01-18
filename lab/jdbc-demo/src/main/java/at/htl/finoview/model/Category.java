package at.htl.finoview.model;

public class Category {
    
    private String abbr;
    private String name;

    //region constructors
    public Category() {
    }

    public Category(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }
    //endregion

    //region getter and setter
    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%s (%s)",abbr, name);
    }
}
