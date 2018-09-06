package com.fiberhome.fiberchat.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fiberhome.fiberchat.TvSeriseDto;
import com.fiberhome.fiberchat.services.TvSeriseService;

@RestController
@RequestMapping("/tvseries")
public class TvseriseApplication {
	private static final Log log = LogFactory.getLog(TvseriseApplication.class);
	@Autowired TvSeriseService service;
       @GetMapping
       public List<TvSeriseDto> getSeries() {
    	      if (log.isTraceEnabled()) {
    	    	  log.trace("getSeries()被调用了！");
    	      }
    	      List<TvSeriseDto> all = service.getAll();
              return all;
       }
       @GetMapping("/{id}")
       public TvSeriseDto getOne(@PathVariable int id) {
    	   if (log.isTraceEnabled()) {
    		   log.trace("getOne" + id);
    	   }
    	   if (id == 101) {
    		   return createWestWorld();
    	   } else if(id == 102) {
    		   return createWestPoi();
    	   } else {
    		   throw new ResourceNotFoundException();
    	   }
    	   
       }
       @DeleteMapping("/{id}")
       public Map<String, String> deleteOne(@PathVariable int id, HttpServletRequest request, 
    		   @RequestParam(value = "delete_reason", required = false) String deleteReason ) {    	   
    	   if (log.isTraceEnabled()) {
    		   log.trace("deleteOne" + id);
    	   }
    	   Map<String, String> result = new HashMap<>();
    	   if (id == 101) {
    		   result.put("message", "101被删除" + deleteReason);
   		   
    	   } else if(id == 102) {
    		   throw new RuntimeException("102不能被删除"); 		   
    	   } else {
    		   throw new ResourceNotFoundException();
    	   }
    	   return result;
    	   
       }
       @PutMapping("/{id}")
       public TvSeriseDto updateOne(@PathVariable int id, @RequestBody TvSeriseDto dto) {
    	   if (log.isTraceEnabled()) {
    		   log.trace("updateOne" + id);
    	   }
    	   if (id == 101 || id == 102) {
    		   return createWestWorld();
    	   } else {
    		   throw new ResourceNotFoundException();
    	   }
    	   
       }
       @PostMapping
       public TvSeriseDto insertOne(@Valid @RequestBody TvSeriseDto dto) {
    	   if (log.isTraceEnabled()) {
    		   log.trace("接受的参数是：" + dto);
    	   }
    	   //数据库存储
    	   dto.setId(9999);
    	   return dto;
       }
       /**
        * 上传图片
        * @param id 
        * @param imgFile
        */
    @PostMapping(value ="/{id}/photos", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile imgFile) {
    	   if (log.isTraceEnabled()) {
    		   log.trace("接收到 id = " + id + "的文件，文件名称为：" + imgFile.getOriginalFilename());
    	   } 
    	   //保存文件
    		try {
				FileOutputStream fileOutputStream = new FileOutputStream("target/" + imgFile.getOriginalFilename());
				IOUtils.copy(imgFile.getInputStream(), fileOutputStream);
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   
       }
    
	@GetMapping(value ="/{id}/icon", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(@PathVariable int id) throws IOException {
    	   if (log.isTraceEnabled()) {
    		   log.trace("getPhoto" + id);
    	   } 
    	   String iconFile = "src/test/resources/装修流程图01.jpg";
    	   //保存文件
    	   InputStream fileInputStream = new FileInputStream(iconFile);
		   return IOUtils.toByteArray(fileInputStream);
	   
       }
       private TvSeriseDto createWestWorld() {
    	   Calendar calendar= Calendar.getInstance();
           calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
           return new TvSeriseDto(1, "WestWorld", calendar.getTime(), new ArrayList<>());
       }
       private TvSeriseDto createWestPoi() {
    	   Calendar calendar= Calendar.getInstance();
           calendar.set(2011, Calendar.SEPTEMBER, 2, 0, 0);
           return new TvSeriseDto(1, "Poi", calendar.getTime(), new ArrayList<>());
       }
}
