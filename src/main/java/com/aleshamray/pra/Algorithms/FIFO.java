package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public class FIFO extends Algorithms {

  public FIFO( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
  }

  @Override
  public void run() {
    for( Integer value : page_reference_string ) {
            
      System.out.print(value + " ");
      System.out.println();
      
      if( memory_frames.get(value) != null ) { 
        int count = memory_frames.get(value);
        memory_frames.put(value, ++count);
        break;
      } else {
        page_faults++;

        if( memory_frames.isEmpty() || 
          ( !memory_frames.containsKey(value) && (memory_frames.size() < memory_frame_count) ) ) {
          // empty frames available
          memory_frames.put(value, 1);
          break;
        } else {
          // swap is necessary
          int highest_count_frame = 0;
          
          
          memory_frames.put(value, 1); 
          

          break;
        }
      }
    }
  }

  @Override
  public void display() {
    replacement_algorithm = "FIFO Replacement";
    super.display();
  }
}