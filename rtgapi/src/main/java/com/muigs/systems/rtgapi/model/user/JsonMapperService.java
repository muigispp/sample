package com.muigs.systems.rtgapi.model.user;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface JsonMapperService {
	String toJson(Object instance) throws IOException;
	 
	 String toJsonBeautify(Object instance) throws IOException;

	 <T> T fromJson(String json, Class<T> clazz) throws IOException;
	 
	 <T> List<T> constructCollectionType(String json, @SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<T> clazzB) throws IOException;

}
