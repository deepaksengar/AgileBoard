package agileboard;

import java.util.Set;

public class Board {
	
	private Iteration currentIteration;

	public Board(Set<Column> columns){
		currentIteration = new Iteration();
		currentIteration.setColumns(columns);
	}
	
	public Iteration getCurrentIteration() {
		return currentIteration;
	}

	public void setCurrentIteration(Iteration currentIteration) {
		this.currentIteration = currentIteration;
	}

}
