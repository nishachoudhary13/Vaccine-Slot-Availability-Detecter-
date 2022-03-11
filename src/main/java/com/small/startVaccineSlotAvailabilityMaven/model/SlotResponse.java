package com.small.startVaccineSlotAvailabilityMaven.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SlotResponse {
	public int center_id;
    public String name;
    public String name_l;
    public String address;
    public String address_l;
    public String state_name;
    public String state_name_l;
    public String district_name;
    public String district_name_l;
    public String block_name;
    public String block_name_l;
    public String pincode;
    public double lat;
    public double  longitude;
    public String from;
    public String to;
    public String fee_type;
    public String fee;
    public String session_id;
    public String date;
    public int  available_capacity;
    public int  available_capacity_dose1;
    public int  available_capacity_dose2;
    public int  min_age_limit;
    public String vaccine;
    public List<String> slots;
    
	@Override
	public String toString() {
		return "SlotResponse [center_id=" + center_id + ", name=" + name + ", name_l=" + name_l + ", address=" + address
				+ ", address_l=" + address_l + ", state_name=" + state_name + ", state_name_l=" + state_name_l
				+ ", district_name=" + district_name + ", district_name_l=" + district_name_l + ", block_name="
				+ block_name + ", block_name_l=" + block_name_l + ", pincode=" + pincode + ", lat=" + lat
				+ ", longitude=" + longitude + ", from=" + from + ", to=" + to + ", fee_type=" + fee_type + ", fee="
				+ fee + ", session_id=" + session_id + ", date=" + date + ", available_capacity=" + available_capacity
				+ ", available_capacity_dose1=" + available_capacity_dose1 + ", available_capacity_dose2="
				+ available_capacity_dose2 + ", min_age_limit=" + min_age_limit + ", vaccine=" + vaccine + ", slots="
				+ slots + "]";
	}
    
    
}
