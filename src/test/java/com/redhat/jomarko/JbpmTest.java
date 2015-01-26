package com.redhat.jomarko;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class JbpmTest {
	private static KieServices ks;
	private static KieContainer kContainer;
	private static KieBase kbase;
	
	@BeforeClass
	public static void createBase() {
		ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
		kbase = kContainer.getKieBase("kbase");
	}
	
	@Test
	public void parallelSplitJoinTest() {
		KieSession ksession = kbase.newKieSession();

		ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new SystemOutWorkItemHandler());
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("VariableOne", "123456");
		
		org.kie.api.runtime.process.ProcessInstance inst = ksession.startProcess("Evaluation", mapa);
		assertEquals(ProcessInstance.STATE_COMPLETED, inst.getState());
	}

}
