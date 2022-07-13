package com.gcu.model;

import javax.validation.constraints.NotNull;

public class ProductModel
{
	private long vacationId;
	@NotNull(message = "Vacation name is a required field")
	private String vacationName;
	@NotNull(message = "Trip start date is a required field")
	private String startDate;
	@NotNull(message = "Trip length is a required field")
	private int tripLength;
	@NotNull(message = "Photo is a required field")
	private String photo;
	@NotNull(message = "Location is a required field")
	private String location;
	@NotNull(message = "Description is a required field")
	private String description;
	@NotNull(message = "Cost is a required field")
	private double cost;
	
	public ProductModel(long vacationId, @NotNull(message = "Vacation name is a required field")String vacationName, 
			@NotNull(message = "Trip start date is a required field")String startDate, 
			@NotNull(message = "Trip length is a required field")int tripLength, 
			@NotNull(message = "Photo is a required field")String photo, 
			@NotNull(message = "Location is a required field")String location,
			@NotNull(message = "Description is a required field")String description, 
			@NotNull(message = "Cost is a required field")double cost)
	{
		this.vacationId = vacationId;
		this.vacationName = vacationName;
		this.startDate = startDate;
		this.tripLength = tripLength;
		this.photo = photo;
		this.location = location;
		this.description = description;
		this.cost = cost;
	}
	
	public ProductModel()
	{
		
	}
	
	public long getVacationId()
	{
		return vacationId;
	}
	public void setVacationId(long vacationId)
	{
		this.vacationId = vacationId;
	}
	public String getVacationName()
	{
		return vacationName;
	}
	public void setVacationName(String vacationName)
	{
		this.vacationName = vacationName;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public int getTripLength()
	{
		return tripLength;
	}
	public void setTripLength(int tripLength)
	{
		this.tripLength = tripLength;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	@Override
	public String toString()
	{
		return "ProductModel [vacaationId= " + vacationId + ", vacationName=" + vacationName + ", startDate=" + startDate + ", tripLength=" + tripLength
				+ ", photo=" + photo + ", location=" + location + ", description=" + description + ", cost=" + cost
				+ "]";
	}
	
	
}
