package com.fiberhome.fiberchat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fiberhome.fiberchat.TvSeriseDto;

public interface TvSeriesDao {
	@Select("select * from tv_series")
	public List<TvSeriseDto> getAll();
	@Update("update ")
	public void updateOne(TvSeriseDto dto);

}
