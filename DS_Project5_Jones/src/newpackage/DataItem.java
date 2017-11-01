/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Owner
 * ‘***  Class Name: DataItem
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class:class holds the data item of count and integer
‘***
‘******************************************************
‘*** Date: 10/23/17

 */
public class DataItem 
{
   public int count;
   public String word;
   
   //constructor
    public DataItem(String word)
    {
        this.count =1;
        this.word = word;     
    }
    
//    ‘***  Method Name: displayItem
//‘***  Method Author: Angelica 
//‘******************************************************
//‘*** Purpose of the Method (Why did you write this Method?)
//    to display the words and the number of the words
//‘*** List all the method parameters with their expected value ranges
//‘*** Return value: the String word and the int count
//‘*** If this is a function list the return data type and the expected range of 
//‘*** values to be returned.
//‘******************************************************
//‘*** Date10/31/17

    public String displayItem()
    {
        return word + ": " + count;
    }
    
}
