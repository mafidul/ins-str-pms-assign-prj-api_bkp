package com.tcs.ins.resource.client;

import com.tcs.ins.resource.client.model.ResourceModel;

public interface ResourceClient {
	
	ResourceModel getResourceById(Long resourceId);
}
