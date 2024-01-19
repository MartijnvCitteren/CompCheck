package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.tax.TaxServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompensationServiceTest {

    public CompensationService compensationService;
    public TaxServices taxServices;
    public CompensationServiceTest(CompensationService compensationService, TaxServices taxServices){
        this.compensationService = compensationService;
        this.taxServices =taxServices;
    }

    @Test
    void getMaxSellablePtoDays() {
        int actual = compensationService.getMaxSellablePtoHours(200, 65);
        assertEquals(65, actual);
    }

    @Test
    void sellPtODaysConvertInEuro() {
    }

    @Test
    void convertIntToFT() {
    }

    @Test
    void convertFloatToFT() {
    }
}