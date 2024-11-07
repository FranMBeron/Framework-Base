package pages;

public class PaginaPrincipal extends BasePage{
    
    //private String searchButton = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";

    private String sectionLink = "//a[normalize-space()='%s' and @href]"; 
    private String elegirPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal() {
        super(driver);
    }

    // Metodo para navegar a www.freerangetesters.com
    public void navigateToFreerangeTesters(){
        // Par maximizar la ventana al abrir chrome y eveitar error en los locators
        driver.manage().window().maximize();

        navigateTo("https://www.freerangetesters.com/");
    }

    public void clickOnSectionNavigationBar(String section){
        //Remplazar el marcador de posición (%s) en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickElegirPLanButton() {
        clickElement(elegirPlanButton);
    }

}
