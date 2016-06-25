package com.huice.auto.framework.listener;

import java.io.File;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.huice.auto.framework.InitProperties;
import com.huice.auto.framework.until.CmdUtil;
import com.huice.auto.framework.until.Logger;

public class Listener implements IExecutionListener,IInvokedMethodListener2,ISuiteListener{
	File f=null;

	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult,
			ITestContext context) {
		
	}
	public void afterInvocation(IInvokedMethod method, ITestResult testResult,
			ITestContext context) {

	}
	//测试开始监听
	public void onExecutionStart() {
		//欢迎辞
		weclome();
		//初始化设置
		new InitProperties();
		//InitProperties.showAllSystemProperties();
		//日志设置
		Logger.setLog();
		Logger.log("................测试框架执行开始......................");
	}
	public void onExecutionFinish() {
		Logger.log("-------------------------测试框架执行结束-------------------------");
		//发送邮件
		sendMail();
		//判断是否自动打开报告页面
		autoOpenReport();
		
	}
	public void onStart(ISuite suite) {
		Logger.log("测试套件【" + suite.getName() + "】执行开始");
		
	}
	public void onFinish(ISuite suite) {
		Logger.log("测试套件【" + suite.getName() + "】执行结束");
	}
	private void autoOpenReport() {
		if(System.getProperty("auto.open.report").equals("true")) {
			CmdUtil.exeCmdCommand("start iexplore C:\\project\\project5\\reports\\html\\index.html");
		}
	}

	private void sendMail() {
		Logger.log("-------------------------已经发送邮件-------------------------");
		//在这里实现发送邮件的逻辑
	}

	private void weclome() {
		System.out.println(String.format("Started Train Test Framework V%s", InitProperties.VERSION));
	}

}
