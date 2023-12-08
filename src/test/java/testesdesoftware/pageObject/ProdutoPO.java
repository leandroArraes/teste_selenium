package testesdesoftware.pageObject;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement btnAdicionar;

    @FindBy(xpath = "//table[@class='table table-hover']")
    public WebElement tabelaProdutos;

    @FindBy(id = "cadastro-produto")
    public WebElement modalCadastroProduto;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement btnSalvar;

    @FindBy(id = "btn-sair")
    public WebElement btnSair;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center alert-dismissible']")
    public WebElement mensagemErro;

    /**
     * Construtor para a criação da página de produtos
     *
     * @param driver
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void preencherCamposCadastro(String codigo, String nome, String quantidade, String valor, String data) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        inputCodigo.sendKeys(codigo);
        inputNome.sendKeys(nome);
        inputQuantidade.sendKeys(quantidade);
        inputValor.sendKeys(valor);
        inputData.sendKeys(data);
       
    }

    public void clicarEmSalvar() {
        btnSalvar.click();
    }

    public void clicarEmSair() {
        btnSair.click();
    }
 // Método para realizar login
    public void realizarLogin(String email, String senha) {
        WebElement inputEmail = driver.findElement(By.id("email"));
        WebElement inputSenha = driver.findElement(By.id("senha"));
        WebElement btnEntrar = driver.findElement(By.id("btn-entrar"));

        inputEmail.sendKeys(email);
        inputSenha.sendKeys(senha);
        btnEntrar.click();
    }



    
    


     /**
     * Método para adicionar um produto com sucesso
     *
     * @param codigo     Código do produto
     * @param nome       Nome do produto
     * @param quantidade Quantidade do produto
     * @param valor      Valor do produto
     * @param data       Data de cadastro do produto
     */
    public void adicionarProdutoComSucesso(String codigo, String nome, String quantidade, String valor, String data) {
        // Clicar no botão adicionar
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(btnAdicionar));

        // Usar a classe Actions para realizar um clique duplo
        Actions actions = new Actions(driver);
        actions.doubleClick(addButton).perform();

        // Preencher campos do formulário
        preencherCamposCadastro(codigo, nome, quantidade, valor, data);

        // Clicar no botão salvar
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(btnSalvar));
        saveButton.click();

        // Esperar até que a tabela de produtos seja visível
        WebElement tabelaElement = wait.until(ExpectedConditions.visibilityOf(tabelaProdutos));

        // Verificar se a tabela de produtos está presente após adicionar
        assertTrue("A tabela de produtos não foi encontrada após adicionar um produto.", tabelaElement.isDisplayed());
    }

    
}
