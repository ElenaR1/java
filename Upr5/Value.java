package bg.uni.sofia.fmi.mjt.cache;

import java.time.LocalDateTime;

public class Value<V> {
	private V val;
    private LocalDateTime expiresAt;
    public Value(V v, LocalDateTime ex) {
    	val=v;
    	expiresAt=ex;
    }
    public LocalDateTime getLocalDateTime() {
    	return this.expiresAt;
    	
    }
    public boolean isExpired() {
    	return this.expiresAt.isBefore(LocalDateTime.now());//it expires today
    }
    
    public V getVal() {
    	return this.val;
    }
    public LocalDateTime getExpirationDate() {
    	return expiresAt.now();
    }
}
