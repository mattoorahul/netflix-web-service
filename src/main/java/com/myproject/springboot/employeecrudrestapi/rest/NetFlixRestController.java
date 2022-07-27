package com.myproject.springboot.employeecrudrestapi.rest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.springboot.employeecrudrestapi.entity.Data;
import com.myproject.springboot.employeecrudrestapi.service.NetflixService;

@RestController
@RequestMapping("/v1")
public class NetFlixRestController {

	private NetflixService netflixService;

	@Autowired
	public NetFlixRestController(NetflixService theNextFlixService) {
		netflixService = theNextFlixService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/tvshows")
	public List<Data> findAll(@RequestParam(required = true) Map<String, String> qparams) {
		System.out.println("qparams " + qparams);
		if (qparams.containsKey("count")) {
			String count = qparams.get("count");
			return netflixService.find(Integer.parseInt(count));

		} else if (qparams.containsKey("movieType")) {
			String movieType = qparams.get("movieType");
			return netflixService.findBymovieType(movieType);

		} else if (qparams.containsKey("country")) {
			String country = qparams.get("country");
			return netflixService.findBycountry(country);

		} else if (qparams.containsKey("startDate") && qparams.containsKey("endDate")) {
			String startDate = qparams.get("startDate");
			String endDate = qparams.get("endDate");
			return netflixService.findByDate(startDate, endDate);

		}
		return netflixService.findAll();
	}

	
	/*
	 
	 http://localhost:8080/v1/store?show_id=12
	 
	 {
   		"show_id": "1",
    	"type": "A",
    	"country": "E",
    	"date_added": "C",
    	"listed_in": "D"
	 }

	 
	 */
	
	@PostMapping("/store")
	public Data addEmployee(@RequestBody Data data, @RequestParam(required = true) Map<String, String> qparams) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		System.out.println("qparams : " + qparams);
		if (qparams.get("isDataBase") != null && qparams.get("isDataBase").equals("true")) {
			data.setId(0);

			netflixService.save(data);

		} else {

			FileWriter filewriter;
			try {
				filewriter = new FileWriter(
						"C:\\Users\\HP\\eclipse-workspace\\netflix-api - milestone3\\input\\netflix_titles.csv", true);
				BufferedWriter br = new BufferedWriter(filewriter);
				StringBuilder sb = new StringBuilder();

				sb.append(data.getShow_id() != null ? data.getShow_id() : "").append(",");
				sb.append(data.getType() != null ? data.getType() : "").append(",");
				sb.append(data.getCountry() != null ? data.getCountry() : "").append(",");
				sb.append(data.getDate_added() != null ? data.getDate_added() : "").append(",");
				sb.append(data.getListed_in() != null ? data.getListed_in() : "").append(",");
				br.newLine();
				br.append(sb.toString());
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return data;
	}
	
	
//	@Scheduled(fixedRate=30000)
//	public void cronJob () { 
//		
//		
//		
//	}

}
