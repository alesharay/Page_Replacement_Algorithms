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
    for( int i = 0; i < page_reference_string.size(); ++i ) {
      int key = page_reference_string.get(i);

      if( memory_frames.isEmpty() || 
        (!memory_frames.containsKey(key) && (memory_frames.size() <  memory_frame_count)) ) {
        // EMPTY FRAMES AVAILABLE
        memory_frames.put( key, i );
        System.out.println( "Value not in frames; page fault +1; empty frames available\n" );
      }

    }

    System.out.printf( "Page faults: %d%n", page_faults );  
  }

  @Override
  public void display() {
    System.out.println();
    System.out.printf( "%s%n", replacement_algorithm );
    System.out.print( "Reference string: " ); for( Integer value : page_reference_string ) { System.out.printf( "%d ", value ); }
    System.out.println();
    System.out.printf( "Page faults: %d%n", page_faults );
  }
}