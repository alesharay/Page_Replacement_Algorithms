package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OPT extends Algorithms {

  public OPT( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
    page_faults = 0;
    replacement_algorithm = "OPT Replacement";
  }

  @Override
  public void run() {
    int swap_key = 0;
    for( int i = 0; i < page_reference_string.size(); ++i ) {
      int key = page_reference_string.get(i);
      // System.out.printf( "%nKey: %d%n", key); // FOR TESTING

      if( !memory_frames.isEmpty() ) {
        memory_frames.entrySet().forEach(frame -> memory_frames.replace(frame.getKey(), frame.getValue()+1));
      }

      if( memory_frames.containsKey(key) ) {
        // KEY ALREADY IN FRAMES
        int count = memory_frames.get( key );
        memory_frames.put( key, ++count ); 
        // System.out.println( "value in frames, no page fault\n" ); // FOR TESTING
      } else {
        ++page_faults;
        
        if( memory_frames.isEmpty() || 
              ( !memory_frames.containsKey(key) && (memory_frames.size() <  memory_frame_count)) ) {
          // EMPTY FRAMES AVAILABLE
          memory_frames.put( key, i );
          // System.out.println( "Value not in frames; page fault +1; empty frames available\n" ); // FOR TESTING
          // System.out.printf( "Page faults: %d%n", page_faults );
        } else {
          // SWAP IS NECESSARY
          HashMap<Integer,Integer> frame_to_replace = 
              (HashMap<Integer, Integer>) memory_frames.clone();

          for( int j = i+1; j < page_reference_string.size(); ++j ) {
            int next_key = page_reference_string.get(j);            
            if( frame_to_replace.size() > 1 && frame_to_replace.containsKey(next_key) ) {
              frame_to_replace.remove(next_key);
            }
          }

          boolean removed = false; 
          for( Map.Entry<Integer,Integer> replace : frame_to_replace.entrySet() ) {
            if( !removed ) {
              swap_key = replace.getKey();
              memory_frames.remove( swap_key, replace.getValue() );
              memory_frames.put(key, 1);
              removed = true;
            }
          }

          // System.out.printf( "Value not in frames; page fault +1; no empty frames; swapping %d with %d%n%n", swap_key, key ); // FOR TESTING
          // System.out.printf( "Page faults: %d%n", page_faults );
        }
      }
    }
  }
}