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
}