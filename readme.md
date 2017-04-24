# AgileBoard

[![Build Status](https://travis-ci.org/deepaksengar/AgileBoard.svg?branch=master)](https://travis-ci.org/deepaksengar/AgileBoard)

Description:
----------- 
	This is maven project, implementation of a Agile Board coding exercise in java. 
	Board have iteration and, interation have function to add card, 
	move card to different columns (status), undo last move, 
	find velocity (sum of estimation points of cards which has been marked as done).
	create cards. Cards have a title, description and estimate in points
	Cards belong to an iteration and assumption is that board has only one iteration at the moment. 
	An iteration can have multiple columns. You can undo your last card column transition. 
	You can enforce a work in progress limit (expressed in points) for a column. 
	If you try and add a card to a column that goes above the WIP limit, it will throw an exception.
		
Dependencies:
------------ 
	JRE 1.8
	JUnit 4 (to run test cases)
	
Execution Instruction: (Execution environment should have dependencies installed.)
---------------------

	To run test cases,
		In Eclipse, go to src->testcase, open AgileBoardTest.java, then Run as Junit Test.
		

Design:
------
		
	AgileBoard
		This package holds all classes which are needed for a agile board.
		
		Board: This class hold current iteration object.
		
		Iteration: This has list of cards and set of columns(card statuses), 
		and implementation of API for add, move, find velocity etc.
		
		Column: Each column will have id, name and its initial limit. 
		Limit 0 means there is no limit for that column.
		
		IterationMove : This contains information about card which has been moved in between columns, 
		along with its last column information.
		
		StatusClass: This class holds information for column and works as initial column seed.
		
		Card: This class has title, description and estimates in points, along with 
		information about which column it belongs to currently.
		
	ErrorUtility package
		This has Custom exception classes.		
		
	Test
		This has test class, AgileBoardTest.java, which implements unit-test cases 
		for agile board, and ensures that system is working as intended.
		
	ExecutorClient package
		ExecutorClient.java
		This is execution class, to create a new board and start iteration based 
		on already existing columns from StatusClass.


Test Result:
-----------
	Running test.AgileBoardTest
	Results :
	Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.17 sec
	
	
	 		 
