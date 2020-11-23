package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.Map;

public class FIFO extends Algorithms {
  private int highest_count_frame;

  public FIFO( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
    highest_count_frame = -1;
    page_faults = 0;
    replacement_algorithm = "FIFO Replacement";
  }

  @Override
  public void run() {
    for( Integer key : page_reference_string ) {
      // System.out.printf( "%nKey: %d%n", key);  // FOR TESTING
      
      if( !memory_frames.isEmpty() ) {
        memory_frames.entrySet().forEach(frame -> memory_frames.replace(frame.getKey(), (frame.getValue()+1)));
      }

      if( memory_frames.containsKey(key) ) { 
        int count = memory_frames.get( key );
        memory_frames.put( key, count++ );
        // System.out.println( "value in frames, no page fault\n" );    // FOR TESTING
      } else {
        ++page_faults;

        if( memory_frames.isEmpty() || (!memory_frames.containsKey(key) && (memory_frames.size() < memory_frame_count)) ) {
          // EMPTY FRAMES AVAILABLE
          memory_frames.put( key, 1 );
          // System.out.println( "Value not in frames; page fault +1; empty frames available\n" );  // FOR TESTING
        } else {
          // SWAP IS NECESSARY
          for( Map.Entry<Integer,Integer> frame : memory_frames.entrySet() ) {
            if( !memory_frames.containsKey(highest_count_frame) || frame.getValue() > memory_frames.get(highest_count_frame) ) {
              highest_count_frame = frame.getKey();
            }
          }
          
          memory_frames.remove( highest_count_frame );
          memory_frames.put( key, 1 ); 
          // System.out.printf( "Value not in frames; page fault +1; no empty frames; swapping %d with %d%n%n", highest_count_frame, key ); // FOR TESTING
          // System.out.println(memory_frames.toString());
          highest_count_frame = -1;
        }
      }
    }
  }
}