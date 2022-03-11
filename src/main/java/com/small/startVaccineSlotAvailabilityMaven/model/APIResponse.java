package com.small.startVaccineSlotAvailabilityMaven.model;

import java.util.List;

import lombok.Getter;

@Getter
public class APIResponse {
	public List<SlotResponse> sessions;
}
