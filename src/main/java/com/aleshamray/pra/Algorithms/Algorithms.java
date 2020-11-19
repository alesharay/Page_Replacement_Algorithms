package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Algorithms {
  protected ArrayList<Integer> page_reference_string;
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

  
  
  // <<<<<<<< ABSTRACT FUNCTIONS >>>>>>>>
  // protected abstract void replace(int value);
  
  public abstract void display();
  public abstract void run();
}