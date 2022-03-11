package com.small.startVaccineSlotAvailabilityMaven.controller;

import com.small.startVaccineSlotAvailabilityMaven.service.VaccineSlotServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Slf4j
@EnableScheduling
@RestController
public class VaccineController {
	
	@Autowired
	private VaccineSlotServiceImpl vaccineSlotService;

	@Scheduled(fixedRate = 500)
	@GetMapping(value = "/getSMS")
	public void triggerSMS() throws IOException {
		Date date = new Date();
		String dateSplit[] = date.toString().split(" ");
		String day = dateSplit[2];
		String currentDate = day + "-06-" + "2021";
		URL obj = new URL(
				"https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=382&date="+currentDate);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "");
		int responseCode = con.getResponseCode();
		//System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			InputStream inputStream = con.getInputStream();
			String response = convertStreamToString(inputStream);
			vaccineSlotService.processResponse(response);
		}
		//System.out.println("Execution Complete"+"********"+date);
	}

	private String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
