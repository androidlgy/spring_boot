package com.fiberhome.fiberchat;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fiberhome.fiberchat.dao.TvSeriesDao;
import com.fiberhome.fiberchat.services.TvSeriseService;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TvSeriesServiceTest {
	/**
	 * @MockBean可以给当前的spring context装载一个bean去替代原来的bean
	 */
	@MockBean TvCharactorDto TvCharactorDto;
	@MockBean TvSeriseDto TvSeriseDto;
	
	@Autowired TvSeriseService tvSeriesService;
	@Autowired TvSeriesDao tvSeriesDao;
	
	@Test
	public void getAllWithMockito() {
		List<TvSeriseDto> list = tvSeriesService.getAll();
		Assert.assertTrue(list.size() >= 0);		
	}
	
	@Test
	public void getAll() {
		List<TvSeriseDto> list = new ArrayList<>();
		TvSeriseDto tvSeriseDto = new TvSeriseDto();
		tvSeriseDto.setName("冰与火之歌");
		list.add(tvSeriseDto);
		/**
		 * 桩模块
		 */
		//当TvSeriesDao调用getAll()方法，将上面的list返回去
		Mockito.when(tvSeriesDao.getAll()).thenReturn(list);
		
		List<TvSeriseDto> result = tvSeriesService.getAll();
		//判断返回值和最初的设置的list是否相同
		Assert.assertTrue(result.size() == list.size());
		Assert.assertTrue("冰与火之歌".equals(result.get(0).getName()));		
	}
	
//	@Test
//	public void testOne() {
//		String newName = "have a try";
//		BitSet bitSet = new BitSet();
//		Mockito.doAnswer(new Answer<Object>() {
//			@Override
//			public Object answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				Object[] arguments = invocation.getArguments();
//				TvSeriseDto tvSeriseDto = (TvSeriseDto) arguments[0];
//				Assert.assertEquals(newName, tvSeriseDto.getName());
//				bitSet.set(0);
//				return 1;
//			}
//		}).when(tvSeriesDao).updateOne(any(TvSeriseDto.class));
//	}

}
