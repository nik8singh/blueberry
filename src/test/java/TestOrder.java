import com.fasterxml.jackson.databind.ObjectMapper;
import com.mana.spring.domain.NonceForm;
import com.mana.spring.domain.Order;
import com.mana.spring.web.OrderController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOrder {

    @Autowired
    private OrderController orderController;

    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void checkout() throws Exception {

        Order order = new Order();
        order.setShippingAddressName("Nikhil Singh");
        order.setShippingAddressLine("90 S 9th St, Apt 312");
        order.setShippingAddressCity("Minneapolis");
        order.setShippingAddressState("MN");
        order.setShippingAddressZipCode("55402");
        order.setShippingAddressCountry("USA");
//        order.setOrderId(42L);
        this.mockMvc.perform(post("/order/cus/review/29")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(order))
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void checkoutNULL() throws Exception {

        Order order = new Order();

        MvcResult result = this.mockMvc.perform(post("/order/cus/review/31")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(order))
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void processNewOrder() throws Exception {

        NonceForm nonceForm = new NonceForm();
        nonceForm.setNonce("CBASEE-Ns1sb-2v9wILA1G_9k5U");

        this.mockMvc.perform(post("/order/cus/process/51")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(nonceForm))
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addCoupon() throws Exception {

        Order order = new Order();
        order.setOrderId(3);
        this.mockMvc.perform(post("/order/cus/addc/winter2020/9"));
    }

    @Test
    public void getByStatus() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/order/adm/list/new/0")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }


}