package bg.uni.sofia.fmi.mjt.cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MemCache<K,V> implements  Cache<K,V> {
 private long maxCapacity;
 private long currentCapacity;
 private HashMap<K,Value<V>> cache;
 private LocalDateTime expiresAt;
 private int successfulHits;
 private int nullHits;
 private double hitRate;
 
 	public MemCache(long capacity) {
 		this.maxCapacity=capacity;
 	}
 	
 	 public MemCache() {
 		 this.maxCapacity=1000;
 	 }
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if(cache.containsKey(key) && !cache.get(key).isExpired()) {
			successfulHits+=1;
			return cache.get(key).getVal();
		}
		if(cache.containsKey(key) && cache.get(key).isExpired()) {
			cache.remove(key);
			currentCapacity-=1;
			nullHits+=1;
			return null;
		}
		else {
			nullHits+=1;
			return null;
	}}

	
	@Override
	public void set(K key, V value, LocalDateTime expiresAt) throws CapacityExceededException {
		// TODO Auto-generated method stub
		if(key!=null && value!= null) {
			if(cache.containsKey(key)) {
				Value obj=new Value<V>(value,expiresAt);
				cache.put(key, obj);
				currentCapacity+=1;
			}
			else {
				Value obj=new Value<V>(value,expiresAt);
				cache.put(key, obj);
				currentCapacity+=1;
			}
			if(currentCapacity==maxCapacity) {
				Value obj=new Value<V>(value,expiresAt);
				for(Entry<K, Value<V>> me:cache.entrySet()) {
					if(me.getValue().isExpired()) {
						cache.remove(me.getKey());
						cache.put(key, obj);
						
					}
				}
			}
			}
		else
			throw new CapacityExceededException();
	}

	@Override
	public LocalDateTime getExpiration(K key) {
		// TODO Auto-generated method stub
		if(cache.containsKey(key)) {
			return cache.get(key).getExpirationDate();
		}
		else
		 return null;
	}

	@Override
	public boolean remove(Object key) {
		if(cache.containsKey(key))
		{
			cache.remove(key);
			return true;
		}
		else
		return false;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return currentCapacity;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cache.clear();
		hitRate=0;
	}

	@Override
	public double getHitRate() {
		// TODO Auto-generated method stub
		if(successfulHits==0) {
			hitRate= 0.0;
			return hitRate;
		}
		else if(nullHits==0)
		{
			hitRate= 1.0;
			return hitRate;
		}
		else
			hitRate= successfulHits/(successfulHits+ nullHits);
		return hitRate;
	}

}
