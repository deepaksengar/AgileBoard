package agileboard;

public class Card {
	
	private String title;
	private String description;
	private int estimatePoints;
	private String currentColumnId;
	
	
	public Card(String title, String desc, int estimates){
		this.setDescription(desc);
		this.setEstimatePoints(estimates);
		this.setTitle(title);
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEstimatePoints() {
		return estimatePoints;
	}
	public void setEstimatePoints(int estimatePoints) {
		this.estimatePoints = estimatePoints;
	}

	public String getCurrentColumnId() {
		return currentColumnId;
	}

	public void setCurrentColumnId(String currentColumnId) {
		this.currentColumnId = currentColumnId;
	}

}
