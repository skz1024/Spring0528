package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	public void outputChef() {
		System.out.println("난 세프다");
	}
}
