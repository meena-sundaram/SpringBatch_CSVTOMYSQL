package com.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App11 {
	public static void main(String[] args) {

		String[] springConfig  = 
			{	"spring/batch/config/database1.xml", 
				"spring/batch/config/context1.xml",
				"spring/batch/jobs/job-report1.xml" 
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		//from context.xml
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		System.out.println("ddd: "+jobLauncher);
		//from job-report.xml
		Job job = (Job) context.getBean("reportJob1");
		System.out.println("ddd1: "+job);
		
		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("ddd2: "+execution);
			
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
