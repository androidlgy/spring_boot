package com.fiberhome.fiberchat;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TvSeriseDto {
	private int id;
	@NotNull 
	private String name;
	private Date oringe;
	//@Valid表示需要级联校验 @Size(min = 2)表示列表长度只是为2
	@Valid @NotNull @Size(min = 2) 
	private List<TvCharactorDto> dtoList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOringe() {
		return oringe;
	}
	public void setOringe(Date oringe) {
		this.oringe = oringe;
	}
	

	public List<TvCharactorDto> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<TvCharactorDto> dtoList) {
		this.dtoList = dtoList;
	}
	public TvSeriseDto(int id, @NotNull String name, Date oringe,
			@Valid @NotNull @Size(min = 2) List<TvCharactorDto> dtoList) {
		super();
		this.id = id;
		this.name = name;
		this.oringe = oringe;
		this.dtoList = dtoList;
	}
	public TvSeriseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return this.getClass().getName() + "{id =" + id + ";name = " + name +"}";
	}

}
