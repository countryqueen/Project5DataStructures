/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Owner
 * 
 * ‘***  Class Name: Nodes
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class (Why did you write this class?)
‘***Create the nodes of the class
‘******************************************************
‘*** Date: 10/31/17

 */



public class Nodes 
{
    //here we have our private variables
    private static final int ORDER = 4;
    private int numItems;
    private Nodes parent;
    private Nodes childArray[] = new Nodes[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];
    
//    ‘***  Method Name: connectChild
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    Connects child with the parent if it is not empty
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    int is childNum and Nodes is the child
//‘*** Return value: nothing it is void
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date: 10/31/17

    public void connectChild(int childNum, Nodes child)
    {
	childArray[childNum] = child;
	if(child != null)
        {
            child.parent = this;
            //child is connected with the parent, isn't that sweet?
        }
    
    }
    
    public Nodes disconnectChild(int childNum)
    {
	Nodes tempNode = childArray[childNum];
	childArray[childNum] = null;
	return tempNode;
    }
    //this is a getter
    public Nodes getChild(int childNum)
    { 
        return childArray[childNum]; 
    
    }
	//this is a getter
    public Nodes getParent()
    { 
        return parent; 
    }
	//setter
    public boolean isLeaf()
    { 
        return (childArray[0]==null); 
    }
	//this is a getter
    public int getNumItems()
    { 
        return numItems; 
    
    }
	//this is a getter
    public DataItem getItem(int index)
    { 
        return itemArray[index]; 
    }
	//setter
    public boolean isFull()
    { 
        return (numItems==ORDER-1); 
    }
    
//    ‘***  Method Name: insertItem
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    DataItem is int and newItem is int
//‘*** Return value: 0
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date: 10/31/17

    public int insertItem(DataItem newItem)
    {
		//assumes node is not full
	numItems++;
        String Newword="";
	boolean twins = duplicate(newItem);
        
        String term = newItem.word;
        
		
	for(int j=ORDER-2; j>=0; j--)
	{
            if(itemArray[j] == null)
            {
                continue;
            }
            else
            {
                
                Newword = itemArray[j].word;
                
                if(term.compareTo(Newword)==0)
                {
                    numItems--;
                    itemArray[j].count++;
                    break;
                    
                }
                else if(term.compareTo(Newword)<0 && !twins)
                {
                    itemArray[j+ 1] = itemArray[j];
                    
                }
                else if (term.compareTo(Newword) > 0 && !twins)
                {
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            
            }
        }
        
        if(term.compareTo(Newword)!=0)
        {
            itemArray[0] = newItem;
        }
        return 0;
        
    }

    
//‘***  Method Name: removeItem
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
    //to remove items form the array into a temporary holder
//‘*** Method Inputs: DataItem
//‘*** List all the method parameters with their expected value ranges
//‘*** Return value: temp
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date 10/31/17
	
    public DataItem removeItem()
    {
	//assumes node not empty
	DataItem temp = itemArray[numItems-1];
	itemArray[numItems-1] = null;
	numItems--;
	return temp;
    }
    
//    ‘***  Method Name: displayNode
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//‘*** Return value:
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date

    public String displayNode()	//format
    {
	String collector = "";
        for(int j = 0; j <numItems; j++)
        {
            collector +=itemArray[j].displayItem() +"\n";
        }
        return collector;
    }
    
//    ‘***  Method Name: duplicate
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    Ensures each word is counted for 
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    parameters include DataItem and newItem they are integers
//‘*** Return value: key which is a boolean data type
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date

    public boolean duplicate(DataItem newItem )
    {
        //set boolean equal to false first
        boolean key = false;
        String term = "";
        String Newword;
        //a four loop is used because it needs to compare two words, a while loop is not used because we are only
        //comparing two words to start off, plus this for loop will decrement the duplicate error.
        for(int j  = 2; j >=0; j--)
        {
           Newword = newItem.word;
           
           if(itemArray[j] == null)
           {
               continue;
               ///continue thru loop
           }
           else
           {
               term = itemArray[j].word;
               
              
               if(Newword.compareTo(term) == 0)
               {
                   key = true;
                   break;
                   //stop loop
               }
           } 
           
        }
        return key;
    }
	

    
}
