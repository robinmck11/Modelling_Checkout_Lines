package modelling_checkout_lines;

/**
 *
 * @author Robin McKenna
 *  Date: 19/02/17
 */


public class Customer 
{
    private int items;
    
    final int min = 15;
    final int max = 20;
    
    /**
     *  Creates a customer with a random number of items
     *  between 1 and 20
     */
    
    public Customer()
    {
        items = min + (int)(Math.random() * max);
    }
    
    public void decrementItems()
    {
        items--;
    }
    
    /**
     * 
     * @return items - The number of items the customer has
     */
    
    public int getNumItems() 
    {
        return items;
    }

    @Override
    public String toString() {
        return "Customer{" + "items=" + items + '}';
    }

    public void setItems(int items) {
        this.items = items;
    }
    
    
    
}
