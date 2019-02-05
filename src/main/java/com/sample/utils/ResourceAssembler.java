package com.sample.utils;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType,ResourceType>{

	public abstract ResourceType toResource(DomainType domainObj);
	
	public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjs){
		return domainObjs.stream().map(o-> toResource(o)).collect(Collectors.toList());
	}
	
}
