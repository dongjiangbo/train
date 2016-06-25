package com.huice.auto.framework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class InitProperties {
	//框架版本
	public static final String VERSION="0.0.1";
	//配置文件地址
	public static final String PFILEPATH="src/test/resources/project.properties";
	//测试时间戳 格式化的
	public static final String TIMEKEY="TestTimeStamp";
	//Unix时间戳
	public static final String MILITIMEKEY="TestMillTimeStamp";
	
	private InputStream fis=null;
	private Properties props=new Properties();
	public static Map<String,String> mapproperties=new HashMap<String,String>();
	public InitProperties(){
		//构造初始配置文件
		init();
	}
	//初始化Property配置文件，放入系统属性变量中
	private void init(){
		try{
			fis=new BufferedInputStream(new FileInputStream(PFILEPATH));
			props.load(fis);
			if(!props.isEmpty()){
				Set<Object> keys=props.keySet();
				for(Object key:keys){
					InitProperties.mapproperties.put(key.toString(),props.getProperty(key.toString()));
					if(!System.getProperties().containsKey(key.toString())&&!props.getProperty(key.toString()).isEmpty()){
						System.setProperty(key.toString(), props.getProperty(key.toString()));
					}
				}
				addTimeStampProperty();
				keys.clear();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	//加入测试执行开始时间，包括格式化和UNIX时间戳
	private void addTimeStampProperty(){
		Date d=new Date();
		String dt=new SimpleDateFormat("yyyyMMddHHmmss").format(d);
		InitProperties.mapproperties.put(TIMEKEY,dt);
		System.setProperty(TIMEKEY,dt);
		String mdt=String.valueOf(d.getTime());
		InitProperties.mapproperties.put(MILITIMEKEY,mdt);
		System.setProperty(MILITIMEKEY, mdt);
	}
	
	//对外调试使用
	public static void showAllSystemProperties(){
		Set<String> syskeys=InitProperties.mapproperties.keySet();
		for(Object key:syskeys){
			if(System.getProperties().containsKey(key)){
				System.out.println(key.toString()+""+System.getProperty(key.toString()));
			}
		}
		syskeys.clear();
	}
	
}
