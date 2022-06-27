package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    //trazendo como parâmetro no construtor o driver instanciado em steps
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //método para realizar o login no sistema
    public void loginSistema(){
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button")).click();
    }

}
