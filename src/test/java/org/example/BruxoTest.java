package org.example;

import org.junit.Assert;
import org.junit.Test;

public class BruxoTest {

    @Test
    public void deveSerCriadoSemEscola(){
        Bruxo bruxo = new Bruxo("Tássio", "Weasley");
        Assert.assertNull(bruxo.getEscolaDeBruxaria());
    }

    @Test
    public void deveSerCriadoSemVarinha(){
        Bruxo bruxo = new Bruxo("Tássio", "Weasley");
        Assert.assertNull(bruxo.getTipoVarinha());
    }

    @Test
    public void deveSerMatriculadoEmHogwartsCorretamente(){
        Bruxo bruxo = new Bruxo("Leo");
        bruxo.matricular();
        Assert.assertEquals("Hogwarts", bruxo.getEscolaDeBruxaria());
    }

    @Test
    public void aposMatriculaDeveTerUmaCasa(){
        Bruxo bruxo = new Bruxo("Leo");
        bruxo.matricular();
        Assert.assertNotNull(bruxo.getCasaSelecionada());
    }

    //Poção polissuco faz um bruxo ter a mesma aparencia de outro bruxo
    @Test
    public void UmBruxoComPolissucoDeveSerDiferenteDoOriginal(){
        Bruxo bruxo = new Bruxo("Leo");
        bruxo.matricular();
        bruxo.definirVarinha();

        Bruxo bruxo2 = new Bruxo("Tássio");
        bruxo.matricular();
        bruxo.definirVarinha();

        bruxo.polissuco(bruxo2);

        Assert.assertEquals(bruxo2, bruxo);
        Assert.assertNotSame(bruxo2, bruxo);

    }
    @Test
    public void UmBruxoNaoPodeSeTornarOutro(){
        Bruxo bruxo = new Bruxo("Leo");
        bruxo.matricular();

        Bruxo bruxo2 = new Bruxo("Tássio");
        bruxo.matricular();


        //Comentar com o Professor
        Assert.assertNotEquals(bruxo, bruxo2);
        Assert.assertEquals(bruxo2, bruxo.polissuco(bruxo2));
        Assert.assertSame(bruxo, bruxo.polissuco(bruxo2));
    }

    @Test
    public void deveSerCriadoSemSerAnimago(){
        Bruxo bruxo = new Bruxo("Leo");
        Assert.assertFalse(bruxo.getAnimago());
    }

    @Test
    public void deveVirarAnimagoCorretamente(){
        Bruxo bruxo = new Bruxo("Leo");
        bruxo.virarAnimago();
        Assert.assertTrue(bruxo.getAnimago());
    }

    @Test
    public void deveLancarExceptionSeNTiverVarinha(){
        Bruxo bruxo = new Bruxo("Leo");
        String feitico = "Reducto";
        Throwable throwable = Assert.assertThrows(Exception.class, ()-> bruxo.lancarFeitico(feitico));
        Assert.assertEquals("Impossível lançar "+ feitico, throwable.getMessage() );

    }
}
