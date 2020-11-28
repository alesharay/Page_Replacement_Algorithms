package com.aleshamray.pra.Algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * First-In First-Out Page Replacement Algorithm
 */
public class FIFO extends Algorithms {
  private int highest_count_frame;

  /**
   * FIFO Constructor
   * @param page_reference_string the replacement string for which page faults will be calculated
   */
  public FIFO( ArrayList<Integer> page_reference_string ) throws IOException {
    super( page_reference_string );
    highest_count_frame = -1;
    page_faults = 0;
    replacement_algorithm = "FIFO Replacement";
  }

  /**
   * Run method must be implemented from abstract parent class. 
   * <br>
   * This method runs the algorithm for the FIFO Page-Replacement Algorithm
   */
  @Override
  public void run() {
    for( Integer key : page_reference_string ) {
      
      if( !memory_frames.isEmpty() ) {
        memory_frames.entrySet()
                     .forEach(frame -> memory_frames.replace(frame.getKey(), (frame.getValue()+1)));
      }

      if( memory_frames.containsKey(key) ) { 
        // KEY ALREADY IN FRAMES
        int count = memory_frames.get( key );
        memory_frames.put( key, count++ );
      } else {
        ++page_faults;

        if( memory_frames.isEmpty() || (!memory_frames.containsKey(key) && (memory_frames.size() < memory_frame_count)) ) {
          // EMPTY FRAMES AVAILABLE
          memory_frames.put( key, 1 );
        } else {
          // SWAP IS NECESSARY
          for( Map.Entry<Integer,Integer> frame : memory_frames.entrySet() ) {
            if( !memory_frames.containsKey(highest_count_frame) || frame.getValue() > memory_frames.get(highest_count_frame) ) {
              highest_count_frame = frame.getKey();
            }
          }
          
          memory_frames.remove( highest_count_frame );
          memory_frames.put( key, 1 ); 
          highest_count_frame = -1;
        }
      }
    }
  }
}