package com.aleshamray.pra.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Algorithms {
  protected ArrayList<Integer> page_reference_string;
  protected int page_faults;
  protected int memory_frame_count;
  protected HashMap<Integer, Integer> memory_frames;
  protected String replacement_algorithm;

  protected Algorithms( ArrayList<Integer> page_reference_string ) throws IOException {
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

  public void write_to_file() throws IOException {
    
    try {
      File file = new File("./algs.data");    
      if (!file.exists()) { file.createNewFile(); } 

      BufferedWriter f_out = new BufferedWriter(new FileWriter(file, true));

      f_out.write( replacement_algorithm + " run " + memory_frame_count + "\n"  ); 
      f_out.write( "Reference string:\n" ); 
      for( int i = 0; i < page_reference_string.size(); ++i ) { 
        int value = page_reference_string.get( i );
        f_out.write( " " + value ); 
        if( (i+1) % 10 == 0 ) { f_out.write("\n"); }
      }
      f_out.write( "Page faults: " + page_faults + "\n");
      f_out.write( "\n" );

      f_out.close();
    } catch (IOException ioe) {
      System.out.println("An error occurred.");
      ioe.printStackTrace();
    }

  }

  public void display_to_console() {
    System.out.println();
    System.out.printf( "%s run %d%n", replacement_algorithm, memory_frame_count );
    // System.out.print( "Reference string: " ); for( Integer value : page_reference_string ) { System.out.printf( "%d ", value ); }
    // System.out.println();
    System.out.printf( "Page faults: %d%n", page_faults );
    // System.out.println();
    // System.out.println();
  }
  
  // <<<<<<<< ABSTRACT FUNCTIONS >>>>>>>>  
  public abstract void run();
}