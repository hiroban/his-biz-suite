
package com.doublechaintech.his.wechatminiappidentify;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.*;
import com.doublechaintech.his.tree.*;
import com.doublechaintech.his.treenode.*;
import com.doublechaintech.his.HisUserContextImpl;
import com.doublechaintech.his.iamservice.*;
import com.doublechaintech.his.services.IamService;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.his.secuser.SecUser;

import com.doublechaintech.his.secuser.CandidateSecUser;







public class WechatMiniappIdentifyManagerImpl extends CustomHisCheckerManager implements WechatMiniappIdentifyManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "WechatMiniappIdentify";
	@Override
	public WechatMiniappIdentifyDAO daoOf(HisUserContext userContext) {
		return wechatMiniappIdentifyDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws WechatMiniappIdentifyManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new WechatMiniappIdentifyManagerException(message);

	}



 	protected WechatMiniappIdentify saveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, String [] tokensExpr) throws Exception{	
 		//return getWechatMiniappIdentifyDAO().save(wechatMiniappIdentify, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, tokens);
 	}
 	
 	protected WechatMiniappIdentify saveWechatMiniappIdentifyDetail(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception{	

 		
 		return saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, allTokens());
 	}
 	
 	public WechatMiniappIdentify loadWechatMiniappIdentify(HisUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatMiniappIdentifyManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify( userContext, wechatMiniappIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatMiniappIdentify, tokens);
 	}
 	
 	
 	 public WechatMiniappIdentify searchWechatMiniappIdentify(HisUserContext userContext, String wechatMiniappIdentifyId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatMiniappIdentifyManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify( userContext, wechatMiniappIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatMiniappIdentify, tokens);
 	}
 	
 	

 	protected WechatMiniappIdentify present(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatMiniappIdentify,tokens);
		
		
		WechatMiniappIdentify  wechatMiniappIdentifyToPresent = wechatMiniappIdentifyDaoOf(userContext).present(wechatMiniappIdentify, tokens);
		
		List<BaseEntity> entityListToNaming = wechatMiniappIdentifyToPresent.collectRefercencesFromLists();
		wechatMiniappIdentifyDaoOf(userContext).alias(entityListToNaming);
		
		return  wechatMiniappIdentifyToPresent;
		
		
	}
 
 	
 	
 	public WechatMiniappIdentify loadWechatMiniappIdentifyDetail(HisUserContext userContext, String wechatMiniappIdentifyId) throws Exception{	
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify( userContext, wechatMiniappIdentifyId, allTokens());
 		return present(userContext,wechatMiniappIdentify, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String wechatMiniappIdentifyId) throws Exception{	
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify( userContext, wechatMiniappIdentifyId, viewTokens());
 		return present(userContext,wechatMiniappIdentify, allTokens());
		
 	}
 	protected WechatMiniappIdentify saveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, Map<String,Object>tokens) throws Exception{	
 		return wechatMiniappIdentifyDaoOf(userContext).save(wechatMiniappIdentify, tokens);
 	}
 	protected WechatMiniappIdentify loadWechatMiniappIdentify(HisUserContext userContext, String wechatMiniappIdentifyId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatMiniappIdentifyManagerException.class);

 
 		return wechatMiniappIdentifyDaoOf(userContext).load(wechatMiniappIdentifyId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, Map<String, Object> tokens){
		super.addActions(userContext, wechatMiniappIdentify, tokens);
		
		addAction(userContext, wechatMiniappIdentify, tokens,"@create","createWechatMiniappIdentify","createWechatMiniappIdentify/","main","primary");
		addAction(userContext, wechatMiniappIdentify, tokens,"@update","updateWechatMiniappIdentify","updateWechatMiniappIdentify/"+wechatMiniappIdentify.getId()+"/","main","primary");
		addAction(userContext, wechatMiniappIdentify, tokens,"@copy","cloneWechatMiniappIdentify","cloneWechatMiniappIdentify/"+wechatMiniappIdentify.getId()+"/","main","primary");
		
		addAction(userContext, wechatMiniappIdentify, tokens,"wechat_miniapp_identify.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+wechatMiniappIdentify.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public WechatMiniappIdentify createWechatMiniappIdentify(HisUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception
	//public WechatMiniappIdentify createWechatMiniappIdentify(HisUserContext userContext,String openId, String appId, String secUserId, DateTime lastLoginTime) throws Exception
	{

		

		

		checkerOf(userContext).checkOpenIdOfWechatMiniappIdentify(openId);
		checkerOf(userContext).checkAppIdOfWechatMiniappIdentify(appId);
		checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentify(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);


		WechatMiniappIdentify wechatMiniappIdentify=createNewWechatMiniappIdentify();	

		wechatMiniappIdentify.setOpenId(openId);
		wechatMiniappIdentify.setAppId(appId);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		wechatMiniappIdentify.setSecUser(secUser);
		
		
		wechatMiniappIdentify.setCreateTime(userContext.now());
		wechatMiniappIdentify.setLastLoginTime(lastLoginTime);

		wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatMiniappIdentify);
		return wechatMiniappIdentify;


	}
	protected WechatMiniappIdentify createNewWechatMiniappIdentify()
	{

		return new WechatMiniappIdentify();
	}

	protected void checkParamsForUpdatingWechatMiniappIdentify(HisUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentify( wechatMiniappIdentifyVersion);
		

		if(WechatMiniappIdentify.OPEN_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOpenIdOfWechatMiniappIdentify(parseString(newValueExpr));
		
			
		}
		if(WechatMiniappIdentify.APP_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAppIdOfWechatMiniappIdentify(parseString(newValueExpr));
		
			
		}		

		
		if(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentify(parseTimestamp(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);


	}



	public WechatMiniappIdentify clone(HisUserContext userContext, String fromWechatMiniappIdentifyId) throws Exception{

		return wechatMiniappIdentifyDaoOf(userContext).clone(fromWechatMiniappIdentifyId, this.allTokens());
	}

	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception
	{
		return internalSaveWechatMiniappIdentify(userContext, wechatMiniappIdentify, allTokens());

	}
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion, property, newValueExpr, tokensExpr);


		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatMiniappIdentify.
			if (wechatMiniappIdentify.isChanged()){
			
			}
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, options);
			return wechatMiniappIdentify;

		}

	}

	public WechatMiniappIdentify updateWechatMiniappIdentify(HisUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion, property, newValueExpr, tokensExpr);



		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());
		if(wechatMiniappIdentify.getVersion() != wechatMiniappIdentifyVersion){
			String message = "The target version("+wechatMiniappIdentify.getVersion()+") is not equals to version("+wechatMiniappIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatMiniappIdentify.
			
			wechatMiniappIdentify.changeProperty(property, newValueExpr);
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, tokens().done());
			return present(userContext,wechatMiniappIdentify, mergedAllTokens(tokensExpr));
			//return saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, tokens().done());
		}

	}

	public WechatMiniappIdentify updateWechatMiniappIdentifyProperty(HisUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion, property, newValueExpr, tokensExpr);

		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());
		if(wechatMiniappIdentify.getVersion() != wechatMiniappIdentifyVersion){
			String message = "The target version("+wechatMiniappIdentify.getVersion()+") is not equals to version("+wechatMiniappIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatMiniappIdentify.

			wechatMiniappIdentify.changeProperty(property, newValueExpr);
			
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, tokens().done());
			return present(userContext,wechatMiniappIdentify, mergedAllTokens(tokensExpr));
			//return saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected WechatMiniappIdentifyTokens tokens(){
		return WechatMiniappIdentifyTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatMiniappIdentifyTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatMiniappIdentifyTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);

 	}
 	public WechatMiniappIdentify transferToAnotherSecUser(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, wechatMiniappIdentifyId,anotherSecUserId);
 
		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());	
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			wechatMiniappIdentify.updateSecUser(secUser);		
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, emptyOptions());
			
			return present(userContext,wechatMiniappIdentify, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);

 	}

 	public WechatMiniappIdentify transferToAnotherSecUserWithLogin(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, wechatMiniappIdentifyId,anotherLogin);
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			wechatMiniappIdentify.updateSecUser(secUser);
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, emptyOptions());

			return present(userContext,wechatMiniappIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);

 	}

 	public WechatMiniappIdentify transferToAnotherSecUserWithEmail(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, wechatMiniappIdentifyId,anotherEmail);
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			wechatMiniappIdentify.updateSecUser(secUser);
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, emptyOptions());

			return present(userContext,wechatMiniappIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentifyManagerException.class);

 	}

 	public WechatMiniappIdentify transferToAnotherSecUserWithMobile(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, wechatMiniappIdentifyId,anotherMobile);
 		WechatMiniappIdentify wechatMiniappIdentify = loadWechatMiniappIdentify(userContext, wechatMiniappIdentifyId, allTokens());
		synchronized(wechatMiniappIdentify){
			//will be good when the wechatMiniappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			wechatMiniappIdentify.updateSecUser(secUser);
			wechatMiniappIdentify = saveWechatMiniappIdentify(userContext, wechatMiniappIdentify, emptyOptions());

			return present(userContext,wechatMiniappIdentify, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForWechatMiniappIdentify(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(HisUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(HisUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(HisUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(HisUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion) throws Exception {
		//deleteInternal(userContext, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion) throws Exception{

		wechatMiniappIdentifyDaoOf(userContext).delete(wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
	}

	public WechatMiniappIdentify forgetByAll(HisUserContext userContext, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
	}
	protected WechatMiniappIdentify forgetByAllInternal(HisUserContext userContext,
			String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion) throws Exception{

		return wechatMiniappIdentifyDaoOf(userContext).disconnectFromAll(wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatMiniappIdentifyManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return wechatMiniappIdentifyDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, WechatMiniappIdentify newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(HisUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(HisUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(HisUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		HisUserContextImpl userContext = (HisUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(HisUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(HisUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(HisUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   WechatMiniappIdentify newWechatMiniappIdentify = this.createWechatMiniappIdentify(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newWechatMiniappIdentify
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, WechatMiniappIdentify.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<WechatMiniappIdentify> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SecUser> secUserList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<WechatMiniappIdentify> list = wechatMiniappIdentifyDaoOf(userContext).findWechatMiniappIdentifyBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(WechatMiniappIdentify.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("微信Miniapp识别列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

		page.assemblerContent(userContext, "listBySecUser");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String wechatMiniappIdentifyId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getWechatMiniappIdentifyDetailScope().clone();
		WechatMiniappIdentify merchantObj = (WechatMiniappIdentify) this.view(userContext, wechatMiniappIdentifyId);
    String merchantObjId = wechatMiniappIdentifyId;
    String linkToUrl =	"wechatMiniappIdentifyManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "微信Miniapp识别"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-openId")
				    .put("fieldName", "openId")
				    .put("label", "开放Id")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("openId", merchantObj.getOpenId());

		propList.add(
				MapUtil.put("id", "3-appId")
				    .put("fieldName", "appId")
				    .put("label", "应用程序Id")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("appId", merchantObj.getAppId());

		propList.add(
				MapUtil.put("id", "4-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "安全用户")
				    .put("type", "object")
				    .put("displayField", "login")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "5-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

		propList.add(
				MapUtil.put("id", "6-lastLoginTime")
				    .put("fieldName", "lastLoginTime")
				    .put("label", "最后登录时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("lastLoginTime", merchantObj.getLastLoginTime());

		//处理 sectionList

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


