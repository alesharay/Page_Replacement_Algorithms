package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Algorithms {
  protected ArrayList<Integer> page_reference_string;
  protected int page_faults;
  protected int memory_frame_count;
  protected HashMap<Integer, Integer> memory_frames;

  protected String replacement_algorithm;

  protected Algorithms( ArrayList<Integer> page_reference_string ) {
    this.page_reference_string = page_reference_string;
    page_faults = 0;
    memory_frame_count = 0;
    replacement_algorithm = "";
    memory_frames = new HashMap<>();

    // init_frames();
  }

  // public void init_frames() {
  //   memory_frames = new HashMap<>();
  //   for( int i = 0; i < memory_frame_count; ++i ) {
  //     memory_frames.put(-1, 0);
  //   }
  // }

  public int get_page_faults() { return page_faults; }

  public void set_memory_frame_count( int count ) { memory_frame_count = count; }

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
  // protected abstract void replace(int value);

  public abstract void run();
}