package pages;

public class PaginaCursos extends BasePage{

    private String introduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    
    public PaginaCursos(){
        super(driver);
    }
    
    public void clickIntroduccionTestingLink(){
        clickElement(introduccionTestingLink);
    }
}
