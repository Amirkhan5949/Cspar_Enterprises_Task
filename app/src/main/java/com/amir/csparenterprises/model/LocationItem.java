package com.amir.csparenterprises.model;

import com.google.gson.annotations.SerializedName;

public class LocationItem{

	@SerializedName("longg")
	private String longg;

	@SerializedName("lat")
	private String lat;

	public void setLongg(String longg){
		this.longg = longg;
	}

	public String getLongg(){
		return longg;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"LocationItem{" + 
			"longg = '" + longg + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}