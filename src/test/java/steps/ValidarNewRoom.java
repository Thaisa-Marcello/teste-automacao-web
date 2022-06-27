package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

//método que executa a feature - BDD/Gherkin
public class ValidarNewRoom {

    //criando instância do driver
    WebDriver driver = new ChromeDriver();
    //criando instância da page object, passando o driver como parâmetro para poder realizar o login
    HomePage homepage = new HomePage(driver);


    @Dado("^que loguei no sistema$")
    //chama o método que realiza o login pela page object
    public void logar_no_sistema(){
        homepage.loginSistema();
      }

    @E("^cliquei em Hotels no menu lateral para expandir$")
    //método para maximizar a tela do chrome e encontrar o elemento (Hotels) para clique
    public void clicar_no_menu_lateral_para_expandir() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div/a[8]")).click();
    }

    @E("^cliquei novamente em Hotels para abrir um novo menu$")
    //método para encontrar o segundo elemento Hotels para o segundo clique em Hotels para abrir um novo menu
    public void clicar_novamente_para_abrir_um_novo_menu(){
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div/div[10]/nav/a[1]")).click();
    }

    @E("^cliquei em Rooms")
    //método para encontrar o elemento Rooms e clicar
    public void clicar_em_rooms(){
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div/div[10]/nav/div[1]/nav/a[2]")).click();
    }

    @E ("^cliquei em ADD$")
    //método para encontrar o elemento ADD e clicar
    public void cliquei_em_ADD(){
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/div/div/form/button")).click();
    }

    @E("^inseri um hotel$")
    //método para encontrar os elementos e inserir um hotel
    public void inserir_um_hotel(){
        driver.findElement(By.id("s2id_autogen1")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]")).click();
    }

    @E("^inseri o tipo de quarto$")
    //método para encontrar os elementos e inserir um quarto
    public void inserir_tipo_de_quarto(){
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/div/form/div[1]/div[2]/div/div/div[1]/div[3]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]")).click();
    }

    @E("^adicionei um preço$")
    //método para inserir um preço para o quarto
    public void adicionar_um_preço(){
        driver.findElement(By.name("basicprice")).sendKeys("200");
    }

    @Quando("^clicar em Submit")
    //método parar clicar em submit e salvar o novo quarto disponível
    public void clicar_em_submit() throws InterruptedException {
        //método para dar scroll down na tela para encontrar o elemento submit
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1050)");
        //método para pausar o teste por 2 seguntos, para dar tempo de realizar o scroll
        Thread.sleep(2000);
        driver.findElement(By.id("add")).click();
    }

    @Então("^o quarto deve aparecer na lista de quartos disponíveis$")
    //método que salva o text do elemento na interface e compara com o texto esperado, em seguida fecha o navegador
    public void quarto_adicionado_sucesso(){
        String quarto_Hotel_Adicionado = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/div/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals("One-Bedroom Apartment", quarto_Hotel_Adicionado);
        driver.quit();
    }
}
