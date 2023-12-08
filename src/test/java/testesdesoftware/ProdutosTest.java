package testesdesoftware;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testesdesoftware.pageObject.ProdutoPO;



public class ProdutosTest extends BaseTestProduto {

    private ProdutoPO produtoPage;

    @Before
    public void setUp() {
        produtoPage = new ProdutoPO(driver);
    }
    
    @Test
    public void deveAdicionarProdutoComSucesso() {
        // Ação: Adicionar um produto com dados válidos
        produtoPage.adicionarProdutoComSucesso("123", "Produto Teste", "10", "50.00", "2023-01-01");
    }


    @Test
    public void deveFecharTelaCadastroAoClicarSair() {
        // Ação: Adicionar um produto com dados válidos
        produtoPage.adicionarProdutoComSucesso("123", "Produto Teste", "10", "50.00", "2023-01-01");

        // Clicar no botão Sair
        produtoPage.clicarEmSair();

        // Verificar se a tela de cadastro de produtos está fechada
        assertFalse("A tela de cadastro de produtos ainda está aberta após clicar em Sair.",
                produtoPage.modalCadastroProduto.isDisplayed());
    }

    @After
    public void tearDown() {
        
    }



    
}
