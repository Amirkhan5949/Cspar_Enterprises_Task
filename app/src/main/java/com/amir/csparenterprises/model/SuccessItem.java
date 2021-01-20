package com.amir.csparenterprises.model;

import com.google.gson.annotations.SerializedName;

public class SuccessItem{

	@SerializedName("image")
	private String image;

	@SerializedName("address")
	private String address;

	@SerializedName("contact")
	private String contact;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("empcode")
	private String empcode;

	@SerializedName("category")
	private String category;

	@SerializedName("categoryid")
	private String categoryid;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
		return contact;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmpcode(String empcode){
		this.empcode = empcode;
	}

	public String getEmpcode(){
		return empcode;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setCategoryid(String categoryid){
		this.categoryid = categoryid;
	}

	public String getCategoryid(){
		return categoryid;
	}

	@Override
 	public String toString(){
		return 
			"SuccessItem{" + 
			"image = '" + image + '\'' + 
			",address = '" + address + '\'' + 
			",contact = '" + contact + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",empcode = '" + empcode + '\'' + 
			",category = '" + category + '\'' + 
			",categoryid = '" + categoryid + '\'' + 
			"}";
		}
}