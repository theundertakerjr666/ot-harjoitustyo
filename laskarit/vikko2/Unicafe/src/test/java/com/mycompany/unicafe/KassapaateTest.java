package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Maksukortti kortti;
    Kassapaate kaasapaate;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1);
        kaasapaate = new Kassapaate();
        kaasapaate.lataaRahaaKortille(kortti, 999);

    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void maksukorttia() {
        assertTrue(kaasapaate.syoEdullisesti(kortti));
        assertTrue(kaasapaate.syoMaukkaasti(kortti));
        kaasapaate.lataaRahaaKortille(kortti, 999);
        assertTrue(kaasapaate.syoEdullisesti(480) > 0);
        assertTrue(kaasapaate.syoMaukkaasti(800) > 0);
        assertTrue(kaasapaate.kassassaRahaa() > 0);
        assertTrue(kaasapaate.maukkaitaLounaitaMyyty() > 0);
        assertTrue(kaasapaate.edullisiaLounaitaMyyty() > 0);
        assertFalse(kaasapaate.syoEdullisesti(240) > 0);
        assertFalse(kaasapaate.syoMaukkaasti(400) > 0);
        assertFalse(kaasapaate.syoEdullisesti(-1) > 0);
        assertFalse(kaasapaate.syoMaukkaasti(-1) > 0);
        kortti = new Maksukortti(0);
        kaasapaate.lataaRahaaKortille(kortti, -1);
        assertFalse(kaasapaate.syoEdullisesti(kortti));
        assertFalse(kaasapaate.syoMaukkaasti(kortti));
    }
}
