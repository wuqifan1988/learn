package com.example.learn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class LearnApplicationTests {

	@Test
	public void testSet(){
		Set<String> sets = new HashSet<>();
		sets.add("182390182");
		sets.add("9082349082304");
		sets.add("09128301283");

		for(String i: sets){
			System.out.println(i);
		}
	}

	@Test
	void contextLoads() {
	}


	public static void main(String[] args) {
	}

}
