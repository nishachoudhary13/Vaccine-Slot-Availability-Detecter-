package com.small.startVaccineSlotAvailabilityMaven.service;

import com.google.gson.Gson;
import com.small.startVaccineSlotAvailabilityMaven.model.APIResponse;
import com.small.startVaccineSlotAvailabilityMaven.model.SlotResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineSlotServiceImpl {

	@Autowired
	private Gson gson;

	private String ACCOUNT_SID = "ACd03443e1c9ecf47f912123201fbac688";

	private String AUTH_TOKEN = "7437b2c96ca7e79723c7a958990cdfe0";

	public void processResponse(String response) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		APIResponse apiResponse =gson.fromJson(response, APIResponse.class);
		List<SlotResponse> sessions = apiResponse.sessions;
		//System.out.println(sessions.size());
		sessions.forEach(slotResponse -> {
			/*if (slotResponse.min_age_limit == 18 && slotResponse.available_capacity_dose1 > 0 ) {
				Message.creator(new PhoneNumber("+919322466866"), new PhoneNumber("+17746148212"),
						"Vaccine Slots Available: " + slotResponse.available_capacity_dose1+" in Pincode: "+slotResponse.pincode).create();
			}*/
				if(slotResponse.min_age_limit == 18 && slotResponse.available_capacity_dose1 > 0 && slotResponse.pincode.equals("431605")){
					System.out.println("Response:"+slotResponse.toString());  
					Message.creator(new PhoneNumber("+919767069050"), new PhoneNumber("+17746148212"),
							"Vaccine Slots Available: " + slotResponse.available_capacity_dose1+" in Pincode: "+slotResponse.pincode).create();
				}
		});
	}

}
