package modelling_checkout_lines;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robin McKenna Date: 19/02/17
 */
public class CheckoutThread extends Thread {

    LinkedBlockingQueue<Customer> queue = new LinkedBlockingQueue();

    private Customer customer;
    
    // Identifies the checkout line
    int id = 0;

    @Override
    public void run() 
    {

        while (true) 
        {
            try 
            {
                customer = queue.take();
 
                while (customer.getNumItems() > 0) 
                {
                    customer.decrementItems();
                    System.out.println("CHECKOUT LINE :> " + id + "\n" + printCustomers());

                    sleep(1000);
                }
                
                sleep(1000);
                
            } catch (InterruptedException ex) 
            {
                Logger.getLogger(CheckoutThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String printCustomers() 
    {
        String customersString = "";

        customersString += customer.toString() + "\n";

        for (Customer customer : queue) 
        {
            if (!queue.isEmpty()) 
            {
                customersString += customer.toString() + "\n";
            }
        }
        return customersString;
    }

    private int getNumItems() 
    {
        int numItems = 0;
        
        for (Customer customer : queue) 
        {
            numItems += customer.getNumItems();
        }
        return numItems;
    }

    public void addCustomer() 
    {
        queue.add(new Customer());
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public int getItems()
    {
        return getNumItems();
    }

}
