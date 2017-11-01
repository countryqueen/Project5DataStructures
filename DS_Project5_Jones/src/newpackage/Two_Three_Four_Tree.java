/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Owner
 * ‘***  Class Name: Two_Three_Four_Tree 
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class (Why did you write this class?)
‘***Create the 234 tree
‘******************************************************
‘*** Date10/31/17

 */
public class Two_Three_Four_Tree 
{
    private Nodes root = new Nodes();


	public void insert(String Newword)
	{
		Nodes curNode = root;
		DataItem tempItem = new DataItem(Newword);
		
		while(true)
		{
                    if (curNode.isFull() )		//if node full,
                    {
			split(curNode);			//split it
			curNode = curNode.getParent(); //back ups
			curNode = getNextChild(curNode, Newword);
                    }//end if(node is full)
			
                    else if (curNode.isLeaf() )	//if node is leaf,
                    {
                            break;
                    }
                    //go insert
			
                    else
                    {
                        if(!curNode.duplicate(tempItem))
                        {
                            curNode = getNextChild(curNode, Newword);
                        }
                        else
                        {
                            break;
                        }
                    }
		}//end while
		
		curNode.insertItem(tempItem);	//insert new DataItem
	}
	
        //    ‘***  Method Name: split
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    Ensures each word is counted for 
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    parameters: thisNode is a Nodes class data type
//‘*** Return value: no return value, void function
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date
	public void split(Nodes thisNode)
	{
		//assumes node is full
		DataItem itemB, itemC;
		Nodes parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem(); //remove rightmost item
		itemB = thisNode.removeItem(); //remove next item
		child2 = thisNode.disconnectChild(2); //remove children
		child3 = thisNode.disconnectChild(3);
		
		Nodes newRight = new Nodes();
		
		if(thisNode==root)					//if this is the root
		{
			root = new Nodes();			//make a new root
			parent = root;					//and connect thisNode to it
			root.connectChild(0, thisNode);
		}
                else
                {
			parent = thisNode.getParent();
                }
                
		
		//deal with parent
		itemIndex = parent.insertItem(itemB); //insert old middle item to parent
		int n = parent.getNumItems();			//total items?
		
		for(int j = n-1; j>itemIndex; j--)	//move parent's connections
		{
			Nodes temp = parent.disconnectChild(j);
			parent.connectChild(j+1, temp);	//one child to the right
		}
		
		//connect newRight to parent
		parent.connectChild(itemIndex+1, newRight);
		
		//deal with newRight
		newRight.insertItem(itemC);			//item C to newRight
		newRight.connectChild(0, child2);	//connect to 0 and 1
		newRight.connectChild(1, child3);	//on newRight
	}//end split()
        
        
        //    ‘***  Method Name: incrementCounter
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    this will increment the counter if duplicates exist 
//‘*** Method Inputs: 
//‘*** List all the method parameters with their expected value ranges
//    parameters: Newword is a String
//‘*** Return value: none, void
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date
        //this will increment the counter if duplicates exist
        public void incrementingCounter(String Newword)
        {
            int j = 0;
            if(Newword.equalsIgnoreCase(Newword))
            {
                j++;
            }
        }
        
        //    ‘***  Method Name: getNextChild
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    Ensures each word is counted for 
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    parameters: theNode of data type Nodes, Newword of data type String 
//‘*** Return value: key which is a boolean data type
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date

	public Nodes getNextChild(Nodes theNode, String Newword)
	{
            
            int j;
            incrementingCounter(Newword);
           
            //assumes node is not empty, not full, not a leaf
            int numItems = theNode.getNumItems();
            for(j=0; j<numItems; j++)		//for each item in node
            {								//are we less?
                if( Newword.compareTo(theNode.getItem(j).word)<0)
                {
                    return theNode.getChild(j);
                } //return left child
            } //end for						//we're greater, so
            return theNode.getChild(j);		//return right child
	}
	
//    ‘***  Method Name: displayTree
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method ( write this Method?)
//    to call the recdisplayTree method so it gets printed!
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    parameters include DataItem and newItem they are integers
//‘*** Return value: info which is a string
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date
	public String displayTree()
	{
            String info = recDisplayTree(root);
            return info;
	}
        
        
        
	//    ‘***  Method Name: recDisplayTree
//‘***  Method Author: Angelica
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    prints out the word and the counts  for the words
//‘*** Method Inputs:
//‘*** List all the method parameters with their expected value ranges
//    parameters include DataItem and newItem they are integers
//‘*** Return value: String collector
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date
	private String recDisplayTree(Nodes anotherNode)
	{
            String collector = "";
            
            if(!anotherNode.isLeaf())
            {
                int numChildren = anotherNode.getNumItems();
                
                for(int j = 0; j < numChildren + 1; j++ )
                {
                    Nodes newNode = anotherNode.getChild(j);
                    
                    collector += recDisplayTree(newNode);
                    try
                    {
                        collector += anotherNode.getItem(j).word + ": " + anotherNode.getItem(j).count + "\n";
                        
                        
                    }catch(Exception ex)
                    {
                        
                    }
                }
            }
            
            else
            {
                collector += anotherNode.displayNode();
            }
            
            return collector;
            
                
	}
} //end class tree23