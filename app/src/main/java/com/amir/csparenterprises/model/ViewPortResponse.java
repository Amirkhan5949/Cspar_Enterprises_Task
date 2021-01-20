package com.amir.csparenterprises.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ViewPortResponse{

	@SerializedName("location")
	private List<LocationItem> location;

	@SerializedName("Success")
	private List<SuccessItem> success;

	public void setLocation(List<LocationItem> location){
		this.location = location;
	}

	public List<LocationItem> getLocation(){
		return location;
	}

	public void setSuccess(List<SuccessItem> success){
		this.success = success;
	}

	public List<SuccessItem> getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ViewPortResponse{" + 
			"location = '" + location + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}