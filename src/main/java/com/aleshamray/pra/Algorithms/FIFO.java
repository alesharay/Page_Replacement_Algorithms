package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public class FIFO extends Algorithms {

  
  public FIFO( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
  }

  @Override
  protected void replace( int value ) {
    for( int i = 0; i < physical_memory_frame_count; ++i ) {
      
    }
  }

  @Override
  public void run() {
    for(Integer value : page_reference_string ) {
      empty_frame_found = false;
      for( int i = 0; i < physical_memory_frame_count; ++i ) {
        if( memory_frames[i] == value ) break;

        if( memory_frames[i] == -1 ) {
          empty_frame_found = true;
          page_faults++;
          memory_frames[i] = value;
          break;
        }
      }

      replace(value);
    }
  }

  @Override
  public void display() {
    replacement_algorithm = "FIFO Replacement";
    super.display();
  }
}