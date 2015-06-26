package com.my.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	public static <K, V> Map<K, V> get() {
		return new HashMap<K, V>();
	}
	
	public static <K, V> Map<K, V> put(K k, V v) {
		Map<K, V> result = get();
		result.put(k, v);
		return result;
	}
	
	public static <V> Map<String, V> put(String[] keys, V ...v) {
		Map<String, V> result = get();
		for (int i = 0; i < keys.length; i++) {
			result.put(keys[i], v[i]);
		}
		return result;
	}
	
}
