package com.fiberhome.fiberchat;

import javax.validation.constraints.NotNull;

public class TvCharactorDto {
	private Integer id;
	private int seriesId;
	@NotNull private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public TvCharactorDto(Integer id, int seriesId, @NotNull String name) {
		super();
		this.id = id;
		this.seriesId = seriesId;
		this.name = name;
	}
	public TvCharactorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
