package agileboard;


public class Column {
	
	private String id;
	private String name;
	private int limit = 0; //0 means no limit
	
	public Column(String id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	 //Overriding equals and hasCode method of Object class, 
		//so Column can be used as Map Key
	
	@Override
	public boolean equals(Object object){
		
		if (this == object){
	         return true;
		}
		
		if (object == null || getClass() != object.getClass()){
	         return false;
		} 
		Column col = (Column) object;
	      
		return (this.getId().equals(col.getId()) && this.getName().equals(col.getName())) ? true : false ;
	}
	
	@Override
	public int hashCode(){
		return getId().hashCode() + getName().hashCode();
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		if(limit >= 0){
			this.limit = limit;
		}	
	}

}
