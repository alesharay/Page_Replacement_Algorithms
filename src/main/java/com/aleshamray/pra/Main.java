package com.aleshamray.pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import com.aleshamray.pra.Algorithms.*;

class Main {
  public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public static ArrayList<Integer> page_reference_string = new ArrayList<>();
  public static Random rand = new Random();
  public static int next_random;
  public static int physical_frame_count;

  public static void set_physical_frame_count(int frames) {
    // System.out.print( "Please enter physical memory frame count: " );
    // physical_frame_count = Integer.parseInt( in.readLine() );

    if( physical_frame_count < 1 || physical_frame_count > 30 ) {
      System.out.printf( "%d is an invalid frame count. Must be in range 1 - 30. Aborting!%n", physical_frame_count );
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) throws IOException {
    rand.setSeed( java.lang.System.currentTimeMillis() );

    // <<<<<<<< UNCOMMENT THIS AFTER TESTING >>>>>>>>
    for( int i = 0; i < 100; ++i ) { 
      next_random = rand.nextInt( 50 );
      page_reference_string.add( next_random );
    }

    // // <<<<<<<< THIS IS JUST FOR TESTING >>>>>>>>
    // page_reference_string = new ArrayList<>( Arrays.asList(1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6) );

    try {
      physical_frame_count = Integer.parseInt( args[0] );
      set_physical_frame_count( physical_frame_count );
    } catch ( ArrayIndexOutOfBoundsException aioob ) {
      aioob.printStackTrace();
    }

    FIFO fifo = new FIFO( page_reference_string );
    OPT opt = new OPT( page_reference_string );
    LRU lru = new LRU( page_reference_string );

    System.out.printf( "%nCreating file for run %d...%n", physical_frame_count );
    System.out.println( "Writing to file..." );

    fifo.set_memory_frame_count( physical_frame_count );
    fifo.run();
    fifo.write_to_file();
    opt.set_memory_frame_count( physical_frame_count );
    opt.run();
    opt.write_to_file();
    lru.set_memory_frame_count( physical_frame_count );
    lru.run();
    lru.write_to_file();
    
    try {
      if( "-v".equals(args[1])) {
        fifo.display_to_console();
        System.out.println();
        opt.display_to_console();
        System.out.println();
        lru.display_to_console();
        System.out.println();
      }
    } catch( ArrayIndexOutOfBoundsException aioob ) {
      // do nothing
    }
    System.out.println( "File writing complete!" );
    System.out.println( "File closed" );
  }
}