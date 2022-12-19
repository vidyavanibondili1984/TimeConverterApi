package com.first.app.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.first.app.service.TimeConverterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
public class AbcdController {

	@Autowired
TimeConverterService timeConverterService;

	
	@GetMapping(value="/welcome")
	public String welcomeString() {
		System.out.println("server calling");
		return "welcome to time converter app";
	}
	
	@GetMapping(value="/time/{hoursAndMinute}")
	public ResponseEntity<String> getTimeInWords(@RequestParam(name="hoursAndMinute" ,required=true)String hoursAndMinutes)
	{
		System.out.println(hoursAndMinutes);
		String tms= timeConverterService.convertTimeToString(hoursAndMinutes);
		System.out.println("tms="+tms);
		
		return new ResponseEntity<>(timeConverterService.convertTimeToString(hoursAndMinutes),HttpStatus.OK);
		
	}

}
