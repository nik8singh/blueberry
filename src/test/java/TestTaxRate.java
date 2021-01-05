import com.mana.spring.domain.TaxRate;
import com.mana.spring.web.TaxRateController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTaxRate {

    @Autowired
    private TaxRateController taxRateController;


    @Test
    public void addNewTaxrate() {
        String[] taxRateLocation = {"Navada", "Minnesota", "North Dakota", "Alabama", "Vermont"};
        double[] taxRatePercent = {7.0, 6.99, 5.99, 8.0, 7.99};
        double[] taxRateOtherTaxPercent = {0, 1.99, 0, 2, 2.99};

        for (int i = 0; i < taxRateLocation.length; i++) {

            TaxRate taxRate = new TaxRate();
            taxRate.setTaxRateLocation(taxRateLocation[i]);
            taxRate.setTaxRatePercent(taxRatePercent[i]);
            taxRate.setTaxRateOtherTaxPercent(taxRateOtherTaxPercent[i]);

            taxRateController.saveTaxRate(taxRate);
        }

    }
}