package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Algorithms {
  protected ArrayList<Integer> page_reference_string;
  protected int page_faults;
  protected int memory_frame_count;
  protected HashMap<Integer, Integer> memory_frames;
  protected String replacement_algorithm;

  protected Algorithms( ArrayList<Integer> page_reference_string ) {
    this.page_reference_string = page_reference_string;
    memory_frame_count = 0;
    replacement_algorithm = "";
    memory_frames = new HashMap<>();
  }

  public void set_memory_frame_count( int count ) { memory_frame_count = count; }

  protected void display_reference_string() {
    for( Integer value : page_reference_string ) { System.out.printf( "%d ", value); }
  }

  public void display_frames() {
    for( Map.Entry<Integer,Integer> frame : memory_frames.entrySet() ) {
      System.out.printf( "%d ", frame.getKey() );
      System.out.println();
    }
  }

  public void display() {
    System.out.println();
    System.out.printf( "%s%n", replacement_algorithm );
    System.out.print( "Reference string: " ); for( Integer value : page_reference_string ) { System.out.printf( "%d ", value ); }
    System.out.println();
    System.out.printf( "Page faults: %d%n", page_faults );
    System.out.println();
    System.out.println();
  }
  
  // <<<<<<<< ABSTRACT FUNCTIONS >>>>>>>>  
  public abstract void run();
}