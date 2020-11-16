package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;

public abstract class Algorithms {
  private ArrayList<Integer> page_reference_string;
  private int page_faults;
  private int physical_memory_frame_count;

  public Algorithms( ArrayList<Integer> page_reference_string ) {
    this.page_reference_string = page_reference_string;
    page_faults = 0;
    physical_memory_frame_count = 0;
  }

  public int get_page_faults() { return page_faults; }

  public void set_physical_memory_frame_count( int count ) { physical_memory_frame_count = count; }

  public abstract void run();
}