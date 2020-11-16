package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public class FIFO extends Algorithms {

  
  public FIFO( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
  }

  @Override
  public void run() {
    for(Integer value : page_reference_string ) {
      for( int i = 0; i < physical_memory_frame_count; ++i ) {
        if( memory_frames[i] == value ) break;

        if( memory_frames[i] == -1 ) {
          page_faults++;
          memory_frames[i] = value;
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