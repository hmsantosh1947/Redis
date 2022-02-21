package com.san.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.redis.model.Sample;
import com.san.redis.repo.RedisRepository;

@RestController
@RequestMapping
public class RedisController {
	@Autowired
	RedisRepository redisRepository;
	
	@PostMapping(value = "/sample/add", consumes = "application/json", produces = "application/json")
	public void addSample(@RequestBody Sample sample) {
		redisRepository.addSample(sample);
	}
	
	@GetMapping(value = "/sample/{id}")
	public Sample getSample(@PathVariable Integer id) {
		return redisRepository.getSample(id);
	}
}
