/*
Last Name, First Name
COP-3252
Assignment 6
Date
*/

// ArrayAccess.java
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArrayAccess extends JFrame 
{
   private JTextField inputField;
   private JTextField retrieveField1;
   private JTextField retrieveField2;
   private JTextField outputField;
   private JPanel inputArea; 
   private JPanel retrieveArea;
   private JPanel outputArea;

   private int num;
   private int index = 0;
   private int array[] = new int[ 10 ];
   private String result = "";
   private int sVal = 0;
   private String blank = "";
   
   // set up GUI
   public ArrayAccess()
   {
      super( "Accessing Array values" );
      setLayout( new FlowLayout() );
      
      // set up input Panel
      inputArea = new JPanel();
      inputArea.add( new JLabel( "Enter array elements here" ) );
      inputField = new JTextField( 10 );
      inputArea.add( inputField );
      inputField.addActionListener( 
         new ActionListener()
         {
            public void actionPerformed( ActionEvent e )
            {
               /* Create a try block in which the application reads the number
                  entered in the inputField and assigns it to the next index 
                  in the array, then increments instance variable index. */
                  try
                  {
                	  String inputText = inputField.getText();
                	  int arrayNum = Integer.parseInt(inputText);
                	  array[index] = arrayNum;
                	  index++;
                  }
               /* Write catch handlers that catch the two types of exceptions
                  that the previous try block might throw (NumberFormatException
                  and ArrayIndexOutOfBoundsException), and display appropriate 
                  messages in error message dialogs. */
                  catch(ArrayIndexOutOfBoundsException ec)
                  {
                	  JOptionPane.showMessageDialog(null,"Array may contain only 10 elements.","Array Full", JOptionPane.ERROR_MESSAGE);
                  }
                  catch(NumberFormatException ec)
                  {
                	  JOptionPane.showMessageDialog(null, "Please enter only integer values.","Invalid Input", JOptionPane.ERROR_MESSAGE);
                  }
               
               inputField.setText( "" );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
      
      // set up retrieve Panel
      retrieveArea = new JPanel( new GridLayout( 2, 2 ) );
      retrieveArea.add( new JLabel( "Enter number to retrieve" ) );
      retrieveField1 = new JTextField( 10 );
      retrieveArea.add( retrieveField1 );
      retrieveField1.addActionListener( 
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent event ) 
            {
               /* Create a try block in which the application reads from 
                  retrieveField1 the number the user wants to find in the 
                  array, then searches the current array contents for the number.
                  If the number is found, the outputField should display all the 
                  indices in which the number was found. If the number is not 
                  found, a NumberNotFoundException should be thrown. */
            	try
            	{
            		result = "";
            		boolean test = false;
            		for(int i = 0; i < index; i++)
            		{
            			String rTextField1 = retrieveField1.getText();
            			if(array[i] == Integer.parseInt(rTextField1))
            			{
            				result = result + Integer.toString(i) + " ";
            				test = true;
            			}
            		}
            		outputField.setText(result);
            		
            		testException(test);
            	}
               /* Write catch handlers that catch the two types of exceptions that
                  the try block might throw (NumberFormatException and 
                  NumberNotFoundException), and display appropriate messages 
                  in error message dialogs. */
                catch(NumberFormatException ec)
            	{
                	JOptionPane.showMessageDialog(null, "Please enter only integer values.","Invalid Input", JOptionPane.ERROR_MESSAGE);
            	}
            	catch(NumberNotFoundException ec)
            	{
            		JOptionPane.showMessageDialog(null, "Number not found in array.","Not Found", JOptionPane.ERROR_MESSAGE);
            	}
               retrieveField1.setText( "" );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
            
      retrieveArea.add( new JLabel( "Enter index to retrieve" ) );
      retrieveField2 = new JTextField( 10 );
      retrieveArea.add( retrieveField2 );
      retrieveField2.addActionListener(
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent event )
            {
               /* Create a try block in which the application reads from 
                  retrieveField2 the index of a value in the array, then 
                  displays the value at that index in the outputField. If the index
                  input by the user is not a number a NumberFormatException should
                  be thrown. If the number input by the user is outside the array 
                  bounds or represents an element in which the application has not
                  stored a value, an ArrayIndexOutOfBoundsException should 
                  be thrown. */
            	try
            	{
            		String searchVal = retrieveField2.getText();
            		result = "";
            		sVal = Integer.parseInt(searchVal);
            		
            		if(index < sVal)
            		{
            			throw new ArrayIndexOutOfBoundsException();
            		}
            		else
            		{            			
            			result = Integer.toString(array[sVal]);
            			outputField.setText(result);
            		}
            		
            	}               
               /* Write catch handlers that catch the two types of exceptions
                  the try block might throw (NumberFormatException and 
                  ArrayIndexOutOfBoundsException), and display appropriate 
                  messages in error message dialogs. */
            	catch(NumberFormatException ec)
            	{
                	JOptionPane.showMessageDialog(null, "Please enter only integer values.","Invalid Input", JOptionPane.ERROR_MESSAGE);
            	}
            	catch(ArrayIndexOutOfBoundsException ec)
                {
            		if(index < sVal)
            		{
            			JOptionPane.showMessageDialog(null,"Index Not Found.","Index Out of Bounds", JOptionPane.ERROR_MESSAGE);
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(null,"Array may contain only 10 elements.","Array Full", JOptionPane.ERROR_MESSAGE);
            		}
                }
               
               retrieveField2.setText( "" );
            } // end anonymous inner class
         } // end new ActionListener
      ); // end call to addActionListener
      
      // set up output Panel
      outputArea = new JPanel();
      outputArea.add( new JLabel( "Result" ) );
      outputField = new JTextField( 30 );
      outputField.setEditable( false );
      outputArea.add( outputField );
      
      add( inputArea );
      add( retrieveArea );
      add( outputArea );
      
   }  // end constructor
   
   public void testException(boolean val)throws NumberNotFoundException
   {
	   if(val == false)
	   {
		   throw new NumberNotFoundException();
	   }
   }
} // end class ArrayAccess
