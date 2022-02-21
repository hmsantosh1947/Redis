package com.san.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.san.redis.model.Sample;
import com.san.redis.repo.RedisRepository;

@Component
public class SampleCache {

	@Autowired
	RedisRepository redisRepository;
	
	@CachePut(value="SampleCache", key="#id")
	public void addSample(Sample sample) {
		redisRepository.addSample(sample);
	}
	
	@Cacheable(value="SampleCache", key="#id")
	public Sample getSample(Integer id) {
		return redisRepository.getSample(id);
	}
}
