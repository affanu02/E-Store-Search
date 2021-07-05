/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package assign1;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test public void testProductID() {
        Book p = new Book();
        p.setProductID("000000");
        assertEquals("ELectronicsTest's product ID should be 000000", "000000", p.getProductID());
    }

    @Test public void testDescription() {
        Book p = new Book();
        p.setDescription("Ipad");
        assertEquals("BookTest's Description should be Ipad", "Ipad", p.getDescription());
    }
    
    @Test public void testYear() {
        Book p = new Book();
        p.setYear(2020);
        assertEquals("BookTest's speed should be 2020", 2020, p.getYear());
    }

    @Test public void testPrice() {
        Book p = new Book();
        p.setPrice(10.0);
        assertTrue("BookTest's price should be $10", 10.0 == p.getPrice());
    }

    @Test public void testPublishers() {
        Book p = new Book();
        p.setPublishers("New york times");
        assertEquals("BookTest's authors should be New york times", "New york times", p.getPublishers());
    }

    @Test public void testAuthors() {
        Book p = new Book();
        p.setAuthors("Jhon");
        assertEquals("BookTest's price should be Jhon", "Jhon", p.getAuthors());
    }

    
}
