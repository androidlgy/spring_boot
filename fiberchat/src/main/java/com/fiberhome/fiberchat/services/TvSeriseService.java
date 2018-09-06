package com.fiberhome.fiberchat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiberhome.fiberchat.TvSeriseDto;
import com.fiberhome.fiberchat.dao.TvSeriesDao;

@Service
public class TvSeriseService {
	@Autowired TvSeriesDao dao;
	public List<TvSeriseDto> getAll() {
		return dao.getAll();
	}
	public void update(TvSeriseDto dto) {
		dao.updateOne(dto);
	}
 
}
