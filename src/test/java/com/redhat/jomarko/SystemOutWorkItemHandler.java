package com.redhat.jomarko;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class SystemOutWorkItemHandler implements WorkItemHandler {
	
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		 System.out.println("Executing work item " + workItem);
		manager.completeWorkItem(workItem.getId(), null);
		
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
