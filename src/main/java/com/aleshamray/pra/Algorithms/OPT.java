package com.aleshamray.pra.Algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OPT extends Algorithms {

  public OPT( ArrayList<Integer> page_reference_string ) throws IOException{
    super( page_reference_string );
    page_faults = 0;
    replacement_algorithm = "OPT Replacement";
  }

  /**
  * Run method must be implemented from abstract parent class. 
  * <br>
  * This method runs the algorithm for the OPT Page-Replacement Algorithm
  */ 
  @Override
  public void run() {
    int swap_key = 0;
    for( int i = 0; i < page_reference_string.size(); ++i ) {
      int key = page_reference_string.get(i);

      if( !memory_frames.isEmpty() ) {
        memory_frames.entrySet().forEach(frame -> memory_frames.replace(frame.getKey(), frame.getValue()+1));
      }

      if( memory_frames.containsKey(key) ) {
        // KEY ALREADY IN FRAMES
        int count = memory_frames.get( key );
        memory_frames.put( key, ++count ); 
      } else {
        ++page_faults;
        
        if( memory_frames.isEmpty() || 
              ( !memory_frames.containsKey(key) && (memory_frames.size() <  memory_frame_count)) ) {
          // EMPTY FRAMES AVAILABLE
          memory_frames.put( key, i );
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
        }
      }
    }
  }
}