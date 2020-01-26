package amit.examples.stuff;

public class AccessSpecifiersExample {

    public String badAccessSpecifier = "Everyone Can Access Me";
    private String good = "Only my owner can access me";
    protected String stillGood = "Only my owner and their children can access me";
    //If the value is initialised only once, ensure they are final as a best practice
    private final String best = "Only my owner can access me";
}
