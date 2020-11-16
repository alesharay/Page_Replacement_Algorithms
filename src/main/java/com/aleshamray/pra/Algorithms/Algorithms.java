package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public abstract class Algorithms {
  protected ArrayList<Integer> page_reference_string;
  protected int page_faults;
  protected int physical_memory_frame_count;
  protected String replacement_algorithm;
  protected int[] memory_frames;

  public Algorithms( ArrayList<Integer> page_reference_string ) {
    this.page_reference_string = page_reference_string;
    page_faults = 0;
    physical_memory_frame_count = 0;
    replacement_algorithm = "";
    init_frames();
  }

  public void init_frames() {
    memory_frames = new int[physical_memory_frame_count];
    for( int i = 0; i < physical_memory_frame_count; ++i ) {
      memory_frames[i] = -1;
    }
  }

  public int get_page_faults() { return page_faults; }

  public void set_physical_memory_frame_count( int count ) { physical_memory_frame_count = count; }

  protected void display_reference_string() {
    for( Integer value : page_reference_string ) {
        System.out.printf( "%d ", value);
    }
  }

  public void display() {
    System.out.println();
    System.out.printf( "%s", replacement_algorithm );
    System.out.println();
    System.out.printf( "Page faults: %d%n", page_faults );
  }


// <<<<<<<< ABSTRACT FUNCTIONS >>>>>>>>
  public abstract void run();

}