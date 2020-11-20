package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public class LRU extends Algorithms {
  
  public LRU( ArrayList<Integer> page_reference_string ) {
    super( page_reference_string );
    page_faults = 0;
    replacement_algorithm = "LRU Replacement";
  }
  
  @Override
  public void run() {
    // TODO: Implement this code
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