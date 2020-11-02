package com.cyberup.schedule.kocw;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class KocwDistHandler extends QuartzJobBean {
	private Logger logger = Logger.getLogger(KocwDistHandler.class);
	
	private KocwDistributor kocwDistributor;
	private KocwDemolisher kocwDemolisher;
	
	public void setKocwDistributor(KocwDistributor kocwDistributor) {
		this.kocwDistributor = kocwDistributor;
	}

	public void setKocwDemolisher(KocwDemolisher kocwDemolisher) {
		this.kocwDemolisher = kocwDemolisher;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		try {
			logger.info("executeInternal start");
			
			execute();
			
			logger.info("executeInternal end");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void execute()
	{
		distribute();
		
		demolish();
	}
	
	public void distribute()
	{
		Calendar calendar = Calendar.getInstance();
		//calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		kocwDistributor.setStartDate(calendar.getTime());
		kocwDistributor.setEndDate(calendar.getTime());
		
		kocwDistributor.run();
	}
	
	public void demolish()
	{
		Calendar calendar = Calendar.getInstance();
		//calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		kocwDemolisher.setStartDate(calendar.getTime());
		kocwDemolisher.setEndDate(calendar.getTime());
		
		kocwDemolisher.run();
	}
}
