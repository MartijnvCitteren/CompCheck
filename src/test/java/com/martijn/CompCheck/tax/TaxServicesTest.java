package com.martijn.CompCheck.tax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxServicesTest {

    @Test
    void hunderdEuroReturnshunderd(){
        TaxServices taxServices = new TaxServices();
       assertEquals(100, taxServices.netRegularIncome(100.00f));
    }

    @Test
    void fifeteenHunderdEuroReturnsFivfeteenHunderd(){
        TaxServices taxServices = new TaxServices();
        assertEquals(1500, taxServices.netRegularIncome(1500.00f));
    }

    @Test
    void seventeenHunderdEuroReturnsSixteenHunderdSixty(){
        TaxServices taxServices = new TaxServices();
        assertEquals(1660, taxServices.netRegularIncome(1700.00f));
    }

    @Test
    void thirthyThousandFifeHunderdEuroReturnsTwentyEightThousandThreeHunderd(){
        TaxServices taxServices = new TaxServices();
        assertEquals(28300.00f, taxServices.netRegularIncome(35000.00f));
    }

    @Test
    void thirthySixThousandEuroReturnsTwentnineThousandAndEight(){
        TaxServices taxServices = new TaxServices();
        assertEquals(29008.13f, taxServices.netRegularIncome(36000.00f));
    }

    @Test
    void sixtFourThousandEuroReturnsFourthySixFiveHunderdAndEight(){
        TaxServices taxServices = new TaxServices();
        assertEquals(46508.13f, taxServices.netRegularIncome(64000.00f));
    }

    @Test
    void seventhyThousandEuroReturnsFourthynineThousandFiveHunderdAndEightSix(){
        TaxServices taxServices = new TaxServices();
        assertEquals(49586.13f, taxServices.netRegularIncome(70000.00f));
    }

    @Test
    void bonusOfFifeThousandReturns(){
        TaxServices taxServices = new TaxServices();
        assertEquals(2450.00f, taxServices.netBonusIncome(5000.00f));
    }

}