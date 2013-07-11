package com.pcitc.utils;
/**
 * 异步接口
 * @author rushun.zhang
 *
 * @param <Params>
 * @param <Progress>
 * @param <Result>
 */
public interface PcitcTask<Params, Progress, Result> {
	

	/**
	 * 异步操作
	 * 
	 * @throws Exception
	 */
	 Result before(Params... params) throws Exception;

	/**
	 * 异步操作完成，更新UI
	 */
	 void after(Result result);

}