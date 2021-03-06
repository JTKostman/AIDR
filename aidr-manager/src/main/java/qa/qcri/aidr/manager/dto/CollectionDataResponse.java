package qa.qcri.aidr.manager.dto;

import java.io.Serializable;
import java.util.List;

import qa.qcri.aidr.manager.persistence.entities.Collection;

public class CollectionDataResponse implements Serializable{
	/**
	 * 
	 */
	
	public CollectionDataResponse(){
		
	}
	
	public CollectionDataResponse(List<Collection> data,Long total){
		this.total = total;
		this.data= data;
	}
	
	private static final long serialVersionUID = 1L;
	private Long total;
	private List<Collection> data;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<Collection> getData() {
		return data;
	}
	public void setData(List<Collection> data) {
		this.data = data;
	}
	
}
