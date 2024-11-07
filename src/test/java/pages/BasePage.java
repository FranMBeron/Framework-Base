package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;

    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /* 
     * Declaración de una variable estatica 'actions' del tipo Actions
     * Esta variable va a habilitar todas las funciones de la class Actions que se encuentra dentro de Selenium
    */
    private static Actions actions;

    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static {
        WebDriverManager.chromedriver().setup();

        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Este es el método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    /*
     * Se crea un objeto del tipo WebElemnt (de Selenium) para invocar funciones que permitan trabajar con estos.
     * Se devuelve un obj de tipo WebElemnt, para atraves del locator devolver el WebElement buscado.
     */
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    //Se crea para no instanciar WebElement en casa page object class y que el tiempo de espera se haga una sola vez. 
    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    public List<String> getDropDownValues (String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions){
            values.add(option.getText());
        }

        return values;
    }

    public void hoverOverElement(String locator){
        actions.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        actions.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        actions.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int colum){
        String cellNeed = locator+"/table/tbody/tr["+row+"]/td["+colum+"]";

        return Find(cellNeed).getText();
    }

    public void setValueOnTable(String locator, int row, int colum, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+colum+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }
}
