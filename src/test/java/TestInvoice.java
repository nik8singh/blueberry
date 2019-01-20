import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import com.mana.spring.web.InvoiceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestInvoice {
    @Autowired
    private InvoiceController invoiceController;


    @Test
    public void addInvoice() {
        User user = new User();

        user.setUserEmail("nik8singh@gmail.com");
        user.setUserId(3L);

        Invoice invoice = new Invoice();

        invoice.setUser(user);

        System.out.println(invoiceController.createInvoice(invoice));
    }


}
