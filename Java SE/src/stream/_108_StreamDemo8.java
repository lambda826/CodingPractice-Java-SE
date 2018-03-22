/**
 *  @author: Yunxiang He
 *  @date  : 2018-03-13 12:18
 */

package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class _108_StreamDemo8 { 
    
    public static void main(String[] args) { 
   
      // Create a list of Strings. 
      ArrayList<String> myList = new ArrayList<>(); 
      myList.add("Alpha"); 
      myList.add("Beta"); 
      myList.add("Gamma"); 
      myList.add("Delta"); 
      myList.add("Phi"); 
      myList.add("Omega"); 
   
      // Obtain a Stream to the array list. 
      Stream<String> myStream = myList.stream(); 
   
      // Obtain an iterator to the stream. 
      Iterator<String> itr = myStream.iterator(); 
   
      // Iterate the elements in the stream. 
      while(itr.hasNext())  
        System.out.println(itr.next()); 
    } 
  }