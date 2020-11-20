package com.aleshamray.pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import com.aleshamray.pra.Algorithms.*;


class Main {
  public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public static ArrayList<Integer> page_reference_string = new ArrayList<>();
  public static Random rand = new Random();
  public static int next_random;
  public static int physical_frame_count;

  public static void physical_frame_count_prompt() throws IOException {
    System.out.print( "Please enter physical memory frame count: " );
    physical_frame_count = Integer.parseInt( in.readLine() );

    if( physical_frame_count < 1 || physical_frame_count > 30 ) {
      System.out.printf( "%d is an invalid frame count. Must be in range 1 - 30. Aborting!%n", physical_frame_count );
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) throws IOException {
    rand.setSeed( java.lang.System.currentTimeMillis() );

    // <<<<<<<< UNCOMMENT THIS AFTER TESTING >>>>>>>>
    // for( int i = 0; i < 18; ++i ) {
    //   next_random = rand.nextInt( 10 );
    //   page_reference_string.add( next_random );
    // }


    // <<<<<<<< DELETE THIS, IT IS JUST FOR TESTING >>>>>>>>
    page_reference_string = new ArrayList<>( Arrays.asList(1,2,3,2,1,5,2,1,6,2,5,6,3,1,3,6,1,2,4,3) );


    physical_frame_count_prompt();

    FIFO fifo = new FIFO( page_reference_string );
    OPT opt = new OPT( page_reference_string );
    LRU lru = new LRU( page_reference_string );

    fifo.set_memory_frame_count( physical_frame_count );
    fifo.display();
    fifo.run();
    System.out.println();
    opt.set_memory_frame_count( physical_frame_count );
    opt.display();
    System.out.println();
    lru.set_memory_frame_count( physical_frame_count );
    lru.display();
    System.out.println();
  }
}