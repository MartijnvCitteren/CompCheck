package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.cao.CaoService;
import com.martijn.CompCheck.company.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BenefitPackageServiceTest {

    @Test
    void fourDecimalsBecametwo() {
        Float euro = BenefitPackageService.euro(10.1234f);
        assertEquals(10.12f, euro);
    }

    @Test
    void eightDecimalsBecametwo() {
        Float euro = BenefitPackageService.euro(137.12345678f);
        assertEquals(137.12f, euro);
    }

    @Test
    void oneDecimalsBecametwo() {
        Float euro = BenefitPackageService.euro(1379.0f);
        assertEquals(1379.00f, euro);
    }


}