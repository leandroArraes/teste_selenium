package testesdesoftware;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testesdesoftware.pageObject.ProdutoPO;



public class ProdutosLoginTest extends BaseTest {

    private ProdutoPO produtoPage;

    @Before
    public void setUp() {
        produtoPage = new ProdutoPO(driver);
    }

    @Test
    public void verificarMensagemDeErroAoInserirCredenciaisInvalidas() {
        // Ação: inserir credenciais inválidas
        produtoPage.realizarLogin("usuario_invalido@gmail.com", "senha_invalida");

        // Verificação: verificar se a mensagem de erro é exibida
        assertTrue("A mensagem de erro não foi exibida corretamente ao inserir credenciais inválidas.",
                produtoPage.mensagemErro.isDisplayed());
    }

    @After
    public void tearDown() {
        // Nenhum código específico de tearDown necessário aqui, pois o método After
        // da classe BaseTest já fecha o navegador.
    }



    
}
