package com.cyberup.util;

import java.io.File;

public class FileDeletor extends Thread {
	private File file = null;
	
	public FileDeletor(File file)
	{
		super();
		
		this.file = file;
	}
	public void run(){
		System.out.println("file("+file.getAbsolutePath()+") delete before");
		while(file.exists())
		{
			if(file.delete())
			{
				System.out.println("file("+file.getAbsolutePath()+") delete after");
				break;
			}
			else
			{
				try{
					Thread.sleep((long)(10*1000));
				}catch(Exception e){}
			}
		}
	}
}
