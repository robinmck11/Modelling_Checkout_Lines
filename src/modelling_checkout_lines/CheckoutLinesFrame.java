package modelling_checkout_lines;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Robin McKenna
 */

public class CheckoutLinesFrame extends JFrame
{
    JButton button = new JButton();
    
    ArrayList<CheckoutThread> checkoutThreads = new ArrayList<>();
    
    // Number of checkout lines.
    private final int lines = 3;
    
    private final int WIDTH = 400;
    private final int HEIGHT = 100;
    
    public CheckoutLinesFrame()
    {
        setSize(WIDTH,HEIGHT);
        setTitle("Add Customer");
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        button.setText("Add Customer");
        button.setSize(new Dimension(WIDTH,HEIGHT));
        
        addCheckoutLines(lines);
        
        
        ActionListener listener = new buttonListener();
        button.addActionListener(listener);
        add(button);
    }
    
    class buttonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            addCustomer();
        }
        
        
    }
    
    private void addCheckoutLines(int lines)
    {
        for(int i = 0; i < lines; i++)
        {
            checkoutThreads.add(i, new CheckoutThread());
        }
        
        for(int i = 0; i < lines; i++)
        {
            checkoutThreads.get(i).setID(i);
            checkoutThreads.get(i).start();
        }
        
        startCustomers();
        
    }
    
    /**
     * Add a customer to the checkout line with the least total
     * number of items
     */
    
    private void addCustomer()
    {
        int min = checkoutThreads.get(0).getItems();
        
        int index = 0;
        
        for(int i = 1; i < lines; i++)
        {
           if (checkoutThreads.get(i).getItems() < min)
           {
               min = checkoutThreads.get(i).getItems();
               index = i;
           } 
        }
        
        checkoutThreads.get(index).addCustomer();
    }
    
    private void startCustomers()
    {
        
        // For adding customers when the program starts.
        
        //for(int i = 0; i < 3; i++)
        //{
        //   checkoutThreads.get(i).addCustomer();
        //}
    }
}
