/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package assign1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test public void testProductID() {
        Product p = new Product();
        p.setProductID("000000");
        assertEquals("ProductTest's product ID should be 000000", "000000", p.getProductID());
    }

    @Test public void testDescription() {
        Product p = new Product();
        p.setDescription("Ipad");
        assertEquals("ProductTest's Description should be Ipad", "Ipad", p.getDescription());
    }
    
    @Test public void testYear() {
        Product p = new Product();
        p.setYear(2020);
        assertEquals("ProductTest's speed should be 2020", 2020, p.getYear());
    }

    @Test public void testPrice() {
        Product p = new Product();
        p.setPrice(10.0);
        assertTrue("ProductTest's price should be $10", 10.0 == p.getPrice());
    }
}
