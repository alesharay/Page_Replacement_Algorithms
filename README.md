# PROGRAM 3 - PAGE REPLACEMENT ALGORITHMS

## 1. Overview

In this project, we are going to write a program that implements several virtual-memory page replacement algorithms. ***The goal of this project is to compare and assess the impact of these algorithms on the number of page faults incurred across a varying number of physical memory page frames available.***

### 1.1 Page Replacement Algorithms

We are going to implement the following page replacement algorithms that we discussed in class:

  1. First-In, First-Out (FIFO)
  2. Optimal (OPT)
  3. Least Recently Used (LRU)

Implement the algorithms so that the number of page frames available can be passed in as an argument.

### 1.2 Performance Metric

We are interested in computing the following metric:

  * The number of page faults incurred

## The Process

First, generate a random page-reference string, of 100 items where the virtual page numbers range from 0 to 49.