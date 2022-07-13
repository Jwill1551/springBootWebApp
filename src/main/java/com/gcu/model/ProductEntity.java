package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("vacations")
public class ProductEntity
{
	@Id
	@Column("vacationId")
	private long vacationId;
	
	@Column("vacationName")
	private String vacationName;
	
	@Column("vacationStartDate")
	private String startDate;
	
	@Column("vacationTripLength")
	private int tripLength;
	
	@Column("vacationPhoto")
	private String photo;
	
	@Column("vacationLocation")
	private String location;
	
	@Column("vacationDescription")
	private String description;
	
	@Column("vacationCost")
	private double cost;
	
	public ProductEntity(long vacationId, String vacationName, String startDate, 
			int tripLength, String photo, String location, String description, double cost)
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
		return "ProductV [vacationId= " + vacationId + ", vacationName=" + vacationName + ", startDate=" + startDate + ", tripLength=" + tripLength
				+ ", photo=" + photo + ", location=" + location + ", description=" + description + ", cost=" + cost
				+ "]";
	}
	
	
}
