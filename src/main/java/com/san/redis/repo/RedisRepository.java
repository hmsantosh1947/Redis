package com.san.redis.repo;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.san.redis.model.Sample;

@Repository
public class RedisRepository {
	public static final String KEY="Sample";
	private RedisTemplate<String, Sample> redisTemplate;
	private HashOperations hashOperations;
	
	public RedisRepository(RedisTemplate<String, Sample> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
//	@CachePut(value="SampleCache", key="#id")
	public void addSample(Sample sample) {
		hashOperations.put(KEY, sample.getId(), sample);
	}
	
//	@Cacheable(value="SampleCache", key="#id")
	public Sample getSample(Integer id) {
		return (Sample) hashOperations.get(KEY, id);
	}
}
