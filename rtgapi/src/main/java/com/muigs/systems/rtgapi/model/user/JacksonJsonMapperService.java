package com.muigs.systems.rtgapi.model.user;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonJsonMapperService implements JsonMapperService{
	
	private final ObjectMapper mapper;

	JacksonJsonMapperService(final ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	@Override
	public String toJson(final Object instance) throws IOException {
		return mapper.writeValueAsString(instance);
	}
	
	@Override
	public String toJsonBeautify(Object instance) throws IOException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(instance);
	}

	@Override
	public <T> T fromJson(final String json, final Class<T> clazz) throws IOException {
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false); 
		return mapper.readValue(json, clazz);
	}

	@Override
	public <T> List<T> constructCollectionType(String json, @SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<T> clazzB) throws IOException {	
		return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(collectionClass, clazzB));
	}

}
