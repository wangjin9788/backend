package com.plastech.crm.resultcode;

/**
 * errorCode of login
 *
 * @author : yemin
 * @date : 2018年7月10日 上午9:28:35
 *
 */
public final class ResultCodeLogin {

  private ResultCodeLogin() {}

  // Module : /user-management
  // Module number : 1
  // Interface : /users/login/web
  // Interface number : 001
  // Method : post
  public static final int RESULT_CODE_1001100 = 1001100;
  public static final String RESULT_MSG_1001100 = "Missing login data";

  public static final int RESULT_CODE_1001101 = 1001101;
  public static final String RESULT_MSG_1001101 = "Missing ucode";

  public static final int RESULT_CODE_1001102 = 1001102;
  public static final String RESULT_MSG_1001102 = "Missing password";

  public static final int RESULT_CODE_1001300 = 1001300;
  public static final String RESULT_MSG_1001300 = "User not exists";

  public static final int RESULT_CODE_1001301 = 1001301;
  public static final String RESULT_MSG_1001301 = "Password error";

  public static final int RESULT_CODE_1001302 = 1001302;
  public static final String RESULT_MSG_1001302 =
      "Login failure,please try again later";

  public static final int RESULT_CODE_1001303 = 1001303;
  public static final String RESULT_MSG_1001303 = "User acount has bean frozen";


  // /**
  // * 状态码： 1001101.
  // */
  // public static final int RESULT_CODE_1001101 = 1001101;
  //
  // /**
  // * 状态消息：Missing password.
  // */
  // public static final String RESULT_MSG_1001101 = "Missing password";
  //
  // /**
  // * 状态码： 1001102.
  // */
  // public static final int RESULT_CODE_1001102 = 1001102;
  //
  // /**
  // * 状态消息：Missing passport.
  // */
  // public static final String RESULT_MSG_1001102 = "Missing passport";
  //
  // /**
  // * 状态码： 1001200.
  // */
  // public static final int RESULT_CODE_1001200 = 1001200;
  //
  // /**
  // * 状态消息：Invalid phone number.
  // */
  // public static final String RESULT_MSG_1001200 = "Invalid phone number";
  //
  // /**
  // * 状态码： 1001201.
  // */
  // public static final int RESULT_CODE_1001201 = 1001201;
  //
  // /**
  // * 状态消息： Invalid email address.
  // */
  // public static final String RESULT_MSG_1001201 = "Invalid email address";
  //
  // /**
  // * 状态码： 1001300.
  // */
  // public static final int RESULT_CODE_1001300 = 1001300;
  //
  // /**
  // * 状态消息： Phone number has been registered.
  // */
  // public static final String RESULT_MSG_1001300 =
  // "Phone number has been registered";
  //
  // /**
  // * 状态码：1001301.
  // */
  // public static final int RESULT_CODE_1001301 = 1001301;
  //
  // /**
  // * 状态消息：Email address has been registered.
  // */
  // public static final String RESULT_MSG_1001301 =
  // "Email address has been registered";
  //
  // /**
  // * 状态码：1001302.
  // */
  // public static final int RESULT_CODE_1001302 = 1001302;
  //
  // /**
  // * 状态消息： Passport is invalid or expired .
  // */
  // public static final String RESULT_MSG_1001302 =
  // "Passport is invalid or expired ";
  //
  //
  // /**
  // * Module : /user-management Interface : /users/login Module number : 1
  // * Interface number : 002
  // */
  //
  // /**
  // * 状态码：1002100.
  // */
  // public static final int RESULT_CODE_1002100 = 1002100;
  //
  // /**
  // * 状态消息：Missing login account(phone number or email).
  // */
  // public static final String RESULT_MSG_1002100 =
  // "Missing login account(phone number or email)";
  //
  // /**
  // * 状态码：1002101.
  // */
  // public static final int RESULT_CODE_1002101 = 1002101;
  //
  // /**
  // * 状态消息：Missing phoneid.
  // */
  // public static final String RESULT_MSG_1002101 = "Missing phoneid";
  //
  // /**
  // * 状态码：1002200.
  // */
  // public static final int RESULT_CODE_1002200 = 1002200;
  //
  // /**
  // * 状态消息：Login account is invalid.
  // */
  // public static final String RESULT_MSG_1002200 = "Login account is invalid";
  //
  // /**
  // * 状态码：1002300.
  // */
  // public static final int RESULT_CODE_1002300 = 1002300;
  //
  // /**
  // * 状态消息：Account is not registered yet.
  // */
  // public static final String RESULT_MSG_1002300 =
  // "Account is not registered yet";
  //
  // /**
  // * 状态码：1002301.
  // */
  // public static final int RESULT_CODE_1002301 = 1002301;
  //
  // /**
  // * 状态消息：Incorrect password.
  // */
  // public static final String RESULT_MSG_1002301 = "Incorrect password";
  //
  // /**
  // * 状态码：1002302.
  // */
  // public static final int RESULT_CODE_1002302 = 1002302;
  //
  // /**
  // * 状态消息：Mailbox not verified.
  // */
  // public static final String RESULT_MSG_1002302 = "Mailbox not verified";
  //
  // /**
  // * Module : /user-management Interface : /users Module number : 1 Interface.
  // * number : 003
  // */
  //
  // /**
  // * 状态码：1003200.
  // */
  // public static final int RESULT_CODE_1003200 = 1003200;
  //
  // /**
  // * 状态消息：Invalid email address.
  // */
  // public static final String RESULT_MSG_1003200 = "Invalid email address";
  //
  // /**
  // * 状态码：1003301.
  // */
  // public static final int RESULT_CODE_1003301 = 1003301;
  //
  // /**
  // * 状态消息：Email address has been registered.
  // */
  // public static final String RESULT_MSG_1003301 =
  // "Email address has been registered";
  //
  // /**
  // * Module : /user-management Interface : /users/logout Module number : 1.
  // * Interface number : 004
  // */
  //
  // /**
  // * 状态码：1004100.
  // */
  // public static final int RESULT_CODE_1004100 = 1004100;
  //
  // /**
  // * 状态消息：Missing token.
  // */
  // public static final String RESULT_MSG_1004100 = "Missing token";
  //
  // /**
  // * Module : /user-management Interface : /users/phonenumber/check Module.
  // * number : 1 Interface number : 005
  // */
  //
  // /**
  // * 状态码：1005100.
  // */
  // public static final int RESULT_CODE_1005100 = 1005100;
  //
  // /**
  // * 状态消息：Missing phone number.
  // */
  // public static final String RESULT_MSG_1005100 = "Missing phone number";
  //
  // /**
  // * 状态码：1005101.
  // */
  // public static final int RESULT_CODE_1005101 = 1005101;
  //
  // /**
  // * 状态消息：Missing area code.
  // */
  // public static final String RESULT_MSG_1005101 = "Missing area code";
  //
  // /**
  // * 状态码：1005200.
  // */
  // public static final int RESULT_CODE_1005200 = 1005200;
  //
  // /**
  // * 状态消息：Invalid area code.
  // */
  // public static final String RESULT_MSG_1005200 = "Invalid area code";
  //
  // /**
  // * 状态码：1005201.
  // */
  // public static final int RESULT_CODE_1005201 = 1005201;
  //
  // /**
  // * 状态消息：Invalid phone number.
  // */
  // public static final String RESULT_MSG_1005201 = "Invalid phone number";
  //
  // /**
  // * 状态码：1005300.
  // */
  // public static final int RESULT_CODE_1005300 = 1005300;
  //
  // /**
  // * 状态消息：Phone number has been registered.
  // */
  // public static final String RESULT_MSG_1005300 =
  // "Phone number has been registered";
  //
  // /**
  // * 状态码：1005301.
  // */
  // public static final int RESULT_CODE_1005301 = 1005301;
  //
  // /**
  // * 状态消息Telephone number is not registered.
  // */
  // public static final String RESULT_MSG_1005301 =
  // "Telephone number is not registered.";
  //
  // /**
  // * Module : /user-management Interface : /users/password/change Module
  // number.
  // * : 1 Interface number : 006
  // */
  //
  // /**
  // * 状态码：1006100.
  // */
  // public static final int RESULT_CODE_1006100 = 1006100;
  //
  // /**
  // * 状态消息：Missing old password.
  // */
  // public static final String RESULT_MSG_1006100 = "Missing old password";
  //
  // /**
  // * 状态码：1006101.
  // */
  // public static final int RESULT_CODE_1006101 = 1006101;
  //
  // /**
  // * 状态消息：Missing new password.
  // */
  // public static final String RESULT_MSG_1006101 = "Missing new password";
  //
  // /**
  // * 状态码：1006300.
  // */
  // public static final int RESULT_CODE_1006300 = 1006300;
  //
  // /**
  // * 状态消息：旧密码错误.
  // */
  // public static final String RESULT_MSG_1006300 = "Incorrect old password";
  //
  // /**
  // * 状态码：1006301.
  // */
  // public static final int RESULT_CODE_1006301 = 1006301;
  //
  // /**
  // * 状态消息：新密码与旧密码相同.
  // */
  // public static final String RESULT_MSG_1006301 =
  // "New password can't be the same with the old password";
  //
  // /**
  // * Module : /user-management Interface : /users/login/web Module number : 1.
  // * Interface number : 007
  // */
  // /**
  // * 状态码：1007100.
  // */
  // public static final int RESULT_CODE_1007100 = 1007100;
  //
  // /**
  // * 状态消息：Missing ucode.
  // */
  // public static final String RESULT_MSG_1007100 = "Missing ucode";
  // /**
  // * 状态码：1007101.
  // */
  // public static final int RESULT_CODE_1007101 = 1007101;
  //
  // /**
  // * 状态消息：Missing password.
  // */
  // public static final String RESULT_MSG_1007101 = "Missing password";
  // /**
  // * 状态码：1007300.
  // */
  // public static final int RESULT_CODE_1007300 = 1007300;
  //
  // /**
  // * 状态消息：Account is not exist.
  // */
  // public static final String RESULT_MSG_1007300 = "Account is not exist";
  //
  // /**
  // * 状态码：1007301.
  // */
  // public static final int RESULT_CODE_1007301 = 1007301;
  //
  // /**
  // * 状态消息：密码错误.
  // */
  // public static final String RESULT_MSG_1007301 = "Incorrect password";
  //
  // /**
  // * 状态码：1007302.
  // */
  // public static final int RESULT_CODE_1007302 = 1007302;
  //
  // /**
  // * 状态消息：.
  // */
  // public static final String RESULT_MSG_1007302 =
  // "Insufficient user privileges";
  //
  // /**
  // * 状态码：1007303.
  // */
  // public static final int RESULT_CODE_1007303 = 1007303;
  //
  // /**
  // * 状态消息：Mailbox not verified.
  // */
  // public static final String RESULT_MSG_1007303 = "Mailbox not verified";
  //
  // /**
  // * Module : /user-management Interface : /user/upgrade Module number : 1.
  // * Interface number : 008
  // */
  // /**
  // * 状态码：1008001.
  // */
  // public static final int RESULT_CODE_1008000 = 1008000;
  //
  // /**
  // * 状态消息：The agency application has already existed.
  // */
  // public static final String RESULT_MSG_1008000 =
  // "The agency application has already existed";
  // /**
  // * 状态码：1008001.
  // */
  // public static final int RESULT_CODE_1008001 = 1008001;
  //
  // /**
  // * 状态消息：Missing name.
  // */
  // public static final String RESULT_MSG_1008001 = "Missing name";
  //
  // /**
  // * 状态码：1008002.
  // */
  // public static final int RESULT_CODE_1008002 = 1008002;
  //
  // /**
  // * 状态消息：Missing user lincense number.
  // */
  // public static final String RESULT_MSG_1008002 =
  // "Missing user lincense number";
  //
  // /**
  // * 状态码：1008002.
  // */
  // public static final int RESULT_CODE_1008003 = 1008003;
  //
  // /**
  // * 状态消息：Missing acName.
  // */
  // public static final String RESULT_MSG_1008003 = "Missing acName";
  //
  // /**
  // * 状态码：1008004.
  // */
  // public static final int RESULT_CODE_1008004 = 1008004;
  //
  // /**
  // * 状态消息：Missing acLincense.
  // */
  // public static final String RESULT_MSG_1008004 = "Missing acLincense";
  //
  // /**
  // * 状态码：1008005.
  // */
  // public static final int RESULT_CODE_1008005 = 1008005;
  //
  // /**
  // * 状态消息：Missing aoName.
  // */
  // public static final String RESULT_MSG_1008005 = "Missing aoName";
  //
  // /**
  // * 状态码：1008006.
  // */
  // public static final int RESULT_CODE_1008006 = 1008006;
  //
  // /**
  // * 状态消息：Missing aoLevel.
  // */
  // public static final String RESULT_MSG_1008006 = "Missing aoLevel";
  //
  // /**
  // * 状态码：1008007.
  // */
  // public static final int RESULT_CODE_1008007 = 1008007;
  //
  // /**
  // * 状态消息：Missing aoAddress.
  // */
  // public static final String RESULT_MSG_1008007 = "Missing aoAddress";
  //
  // /**
  // * 状态码：1008008.
  // */
  // public static final int RESULT_CODE_1008008 = 1008008;
  //
  // /**
  // * 状态消息：Missing aoPhone.
  // */
  // public static final String RESULT_MSG_1008008 = "Missing aoPhone";
  //
  //
  // /**
  // * 状态码： 1008009.
  // */
  // public static final int RESULT_CODE_1008009 = 1008009;
  //
  // /**
  // * 状态消息：Invalid uagLicenseCode.
  // */
  // public static final String RESULT_MSG_1008009 = "Invalid uagLicenseCode";
  //
  // /**
  // * 状态码： 1008010.
  // */
  // public static final int RESULT_CODE_1008010 = 1008010;
  //
  // /**
  // * 状态消息：Invalid acArea.
  // */
  // public static final String RESULT_MSG_1008011 = "Invalid acArea";
  //
  // /**
  // * 状态码： 1008011.
  // */
  // public static final int RESULT_CODE_1008011 = 1008011;
  //
  // /**
  // * 状态消息：Invalid aoArea.
  // */
  // public static final String RESULT_MSG_1008012 = "Invalid aoArea";
  //
  // /**
  // * 状态码： 1008012.
  // */
  // public static final int RESULT_CODE_1008012 = 1008012;
  //
  // /**
  // * 状态消息：Invalid uagPosition .
  // */
  // public static final String RESULT_MSG_1008013 = "Invalid uagPosition";
  //
  // /**
  // * 状态码： 1008013.
  // */
  // public static final int RESULT_CODE_1008013 = 1008013;
  //
  // /**
  // * 状态消息：Invalid uagTelephone .
  // */
  // public static final String RESULT_MSG_1008014 = "Invalid uagTelephone";
  // /**
  // * 状态码： 1008014.
  // */
  // public static final int RESULT_CODE_1008014 = 1008014;
  //
  // /**
  // * 状态消息：Invalid uagArea.
  // */
  // public static final String RESULT_MSG_10080154 = "Invalid uagArea";
  //
  // /**
  // * 状态码： 1008015.
  // */
  // public static final int RESULT_CODE_1008015 = 1008015;
  //
  // /**
  // * 状态消息：Invalid uagExperience.
  // */
  // public static final String RESULT_MSG_1008015 = "Invalid uagExperience";
  // /**
  // * 状态码： 1008300.
  // */
  // public static final int RESULT_CODE_1008300 = 1008300;
  //
  // /**
  // * 状态消息：Agent licence number exists. Please change it.
  // */
  // public static final String RESULT_MSG_1008300 =
  // "Agent licence number exists. Please change it.";
  //
  //
  // /**
  // * Module : /user-management Interface : /agents/search Module number : 1
  // * Interface number : 009
  // */
  // /**
  // * 状态码：1009100.
  // */
  // public static final int RESULT_CODE_1009100 = 1009100;
  //
  // /**
  // * 状态消息：Missing status.
  // */
  // public static final String RESULT_MSG_1009100 = "Missing status";
  //
  // /**
  // * Module : /user-management Interface : /query/user-agent/info Module
  // number
  // * : 1 Interface number : 010
  // */
  // /**
  // * 状态码：1001011.
  // */
  // public static final int RESULT_CODE_1001011 = 1001011;
  //
  // /**
  // * 状态消息：Invalid status.
  // */
  // public static final String RESULT_MSG_1001011 = "Invalid uid";
  //
  // /**
  // * 状态码：1001012.
  // */
  // public static final int RESULT_CODE_1001012 = 1001012;
  //
  // /**
  // * 状态消息：Invalid status.
  // */
  // public static final String RESULT_MSG_1001012 =
  // "User information does not exist";
  //
  //
  // /**
  // * Module : /user-management Interface : /agents/froze Module number : 1
  // * Interface number : 011
  // */
  // /**
  // * 状态码：1011100.
  // */
  // public static final int RESULT_CODE_1011100 = 1011100;
  //
  // /**
  // * 状态消息：Missing agentList.
  // */
  // public static final String RESULT_MSG_1011100 = "Missing agentList";
  //
  //
  // /**
  // * Module : /user-management Interface : /agents/unfroze Module number : 1
  // * Interface number : 012
  // */
  // /**
  // * 状态码：1012100.
  // */
  // public static final int RESULT_CODE_1012100 = 1012100;
  //
  // /**
  // * 状态消息：Missing agentList.
  // */
  // public static final String RESULT_MSG_1012100 = "Missing agentList";
  // /**
  // * 状态码：1012101.
  // */
  // public static final int RESULT_CODE_1012101 = 1012101;
  //
  // /**
  // * 状态消息：Missing DaysNumber.
  // */
  // public static final String RESULT_MSG_1012101 = "Missing DaysNumber";
  //
  //
  // /**
  // * Module : /user-management Interface : /agents/{uid} Module number : 1
  // * Interface number : 013
  // */
  // /**
  // * 状态码：1013100.
  // */
  // public static final int RESULT_CODE_1013100 = 1013100;
  //
  // /**
  // * 状态消息：Missing request body.
  // */
  // public static final String RESULT_MSG_1013100 = "Missing request body";
  //
  // /**
  // * 状态码：1013101.
  // */
  // public static final int RESULT_CODE_1013101 = 1013101;
  //
  // /**
  // * 状态消息：Missing uagName.
  // */
  // public static final String RESULT_MSG_1013101 = "Missing uagName";
  //
  // /**
  // * 状态码：1013102.
  // */
  // public static final int RESULT_CODE_1013102 = 1013102;
  //
  // /**
  // * 状态消息：Missing uagEn.
  // */
  // public static final String RESULT_MSG_1013102 = "Missing uagEn";
  //
  // /**
  // * 状态码：1013103.
  // */
  // public static final int RESULT_CODE_1013103 = 1013103;
  //
  // /**
  // * 状态消息：Missing uagLicenseCode.
  // */
  // public static final String RESULT_MSG_1013103 = "Missing uagLicenseCode";
  //
  // /**
  // * 状态码：1013104.
  // */
  // public static final int RESULT_CODE_1013104 = 1013104;
  //
  // /**
  // * 状态消息：Missing uagLincenseNumber.
  // */
  // public static final String RESULT_MSG_1013104 = "Missing
  // uagLincenseNumber";
  //
  // /**
  // * 状态码：1013105.
  // */
  // public static final int RESULT_CODE_1013105 = 1013105;
  //
  // /**
  // * 状态消息：Missing uagPosition.
  // */
  // public static final String RESULT_MSG_1013105 = "Missing uagPosition";
  //
  // /**
  // * 状态码：1013106.
  // */
  // public static final int RESULT_CODE_1013106 = 1013106;
  //
  // /**
  // * 状态消息：Missing uagExperience.
  // */
  // public static final String RESULT_MSG_1013106 = "Missing uagExperience";
  //
  // /**
  // * 状态码：1013107.
  // */
  // public static final int RESULT_CODE_1013107 = 1013107;
  //
  // /**
  // * 状态消息：Missing acid.
  // */
  // public static final String RESULT_MSG_1013107 = "Missing acid";
  //
  // /**
  // * 状态码：1013108.
  // */
  // public static final int RESULT_CODE_1013108 = 1013108;
  //
  // /**
  // * 状态消息：Missing aoid.
  // */
  // public static final String RESULT_MSG_1013108 = "Missing aoid";
  //
  // /**
  // * 状态码：1013109.
  // */
  // public static final int RESULT_CODE_1013109 = 1013109;
  //
  // /**
  // * 状态消息：Missing uagArea.
  // */
  // public static final String RESULT_MSG_1013109 = "Missing uagArea";
  //
  // /**
  // * 状态码：1013110.
  // */
  // public static final int RESULT_CODE_1013110 = 1013110;
  //
  // /**
  // * 状态消息：Missing uagTelephone.
  // */
  // public static final String RESULT_MSG_1013110 = "Missing uagTelephone";
  //
  // /**
  // * 状态码：1013200.
  // */
  // public static final int RESULT_CODE_1013200 = 1013200;
  //
  // /**
  // * 状态消息：Invalid uid.
  // */
  // public static final String RESULT_MSG_1013200 = "Invalid uid";
  //
  // /**
  // * 状态码：1013201.
  // */
  // public static final int RESULT_CODE_1013201 = 1013201;
  //
  // /**
  // * 状态消息：Invalid uagExperience.
  // */
  // public static final String RESULT_MSG_1013201 = "Invalid uagExperience";
  //
  // /**
  // * 状态码：1013202.
  // */
  // public static final int RESULT_CODE_1013202 = 1013202;
  //
  // /**
  // * 状态消息：Invalid acid.
  // */
  // public static final String RESULT_MSG_1013202 = "Invalid acid";
  //
  // /**
  // * 状态码：1013203.
  // */
  // public static final int RESULT_CODE_1013203 = 1013203;
  //
  // /**
  // * 状态消息：Invalid aoid.
  // */
  // public static final String RESULT_MSG_1013203 = "Invalid aoid";
  //
  //
  //
  // /**
  // * Module : /user-management Interface : /users/notification-token Method :
  // * post Module number : 1 Interface number : 014
  // */
  // /**
  // * 状态码：1014100.
  // */
  // public static final int RESULT_CODE_1014100 = 1014100;
  //
  // /**
  // * 状态消息：Missing notification-token.
  // */
  // public static final String RESULT_MSG_1014100 = "Missing notification-token
  // ";
  //
  // /**
  // * Module : /user-management Interface :/reset/password Method : post Module
  // * number : 1 Interface number : 015
  // */
  //
  // /**
  // * 状态码：1015100.
  // */
  // public static final int RESULT_CODE_1015100 = 1015100;
  //
  // /**
  // * 状态消息：Missing oAuthCode.
  // */
  // public static final String RESULT_MSG_1015100 = "Missing oAuthCode ";
  //
  // /**
  // * 状态码：1015101.
  // */
  // public static final int RESULT_CODE_1015101 = 1015101;
  //
  // /**
  // * 状态消息：Missing password.
  // */
  // public static final String RESULT_MSG_1015101 = "Missing password ";
  //
  // /**
  // * 状态码：1015102.
  // */
  // public static final int RESULT_CODE_1015102 = 1015102;
  //
  // /**
  // * 状态消息：Missing passport.
  // */
  // public static final String RESULT_MSG_1015102 = "Missing passport ";
  //
  // /**
  // * 状态码：1015301.
  // */
  // public static final int RESULT_CODE_1015301 = 1015301;
  //
  // /**
  // * 状态消息：The old password is the same as the new one..
  // */
  // public static final String RESULT_MSG_1015301 =
  // "The old password is the same as the new one. ";
  //
  // /**
  // * 状态码：1015302.
  // */
  // public static final int RESULT_CODE_1015302 = 1015302;
  //
  // /**
  // * 状态消息： Passport is invalid or expired .
  // */
  // public static final String RESULT_MSG_1015302 =
  // "Passport is invalid or expired ";
  // /**
  // * 状态码：1015303.
  // */
  // public static final int RESULT_CODE_1015303 = 1015303;
  //
  // /**
  // * 状态消息： users do not exist or are frozen .
  // */
  // public static final String RESULT_MSG_1015303 =
  // "users do not exist or are frozen ";
  // /**
  // * 状态码：1015304.
  // */
  // public static final int RESULT_CODE_1015304 = 1015304;
  //
  // /**
  // * 状态消息： For the time being, only proxy password modification is supported .
  // */
  // public static final String RESULT_MSG_1015304 =
  // "For the time being, only proxy password modification is supported ";
  //
  // /**
  // * Module : /user-management Interface :/reset/password Method : post Module
  // * number : 1 Interface number : 016
  // */
  // /**
  // * 状态码：1016100.
  // */
  // public static final int RESULT_CODE_1016100 = 1016100;
  //
  // /**
  // * 状态消息： Missing uid .
  // */
  // public static final String RESULT_MSG_1016100 = "Missing uid ";
  // /**
  // * 状态码：1016101.
  // */
  // public static final int RESULT_CODE_1016101 = 1016101;
  //
  // /**
  // * 状态消息：Missing daysNumber .
  // */
  // public static final String RESULT_MSG_1016101 = "Missing daysNumber";
  // /**
  // * 状态码：1016300.
  // */
  // public static final int RESULT_CODE_1016300 = 1016300;
  //
  // /**
  // * 状态消息：No permission Operation .
  // */
  // public static final String RESULT_MSG_1016300 = "No permission Operation";
  // /**
  // * 状态码：1016301.
  // */
  // public static final int RESULT_CODE_1016301 = 1016301;
  //
  // /**
  // * 状态消息：agent information does not exist. Please check user information. .
  // */
  // public static final String RESULT_MSG_1016301 =
  // "agent information does not exist. Please check user information.";
  //
  // /**
  // * Module : /user-management Interface :/users/web/agent Method : post
  // Module
  // * number : 1 Interface number : 017
  // */
  // /**
  // * 状态码：1017100.
  // */
  // public static final int RESULT_CODE_1017100 = 1017100;
  //
  // /**
  // * 状态消息：Missing uName.
  // */
  // public static final String RESULT_MSG_1017100 = "Missing uName";
  // /**
  // * 状态码：1017101.
  // */
  // public static final int RESULT_CODE_1017101 = 1017101;
  //
  // /**
  // * 状态消息：Missing ueName.
  // */
  // public static final String RESULT_MSG_1017101 = "Missing ueName";
  // /**
  // * 状态码：1017102.
  // */
  // public static final int RESULT_CODE_1017102 = 1017102;
  //
  // /**
  // * 状态消息：Missing UagLincenseNumber.
  // */
  // public static final String RESULT_MSG_1017102 = "Missing
  // UagLincenseNumber";
  // /**
  // * 状态码：1017103.
  // */
  // public static final int RESULT_CODE_1017103 = 1017103;
  //
  // /**
  // * 状态消息：Missing UagLicenseCode.
  // */
  // public static final String RESULT_MSG_1017103 = "Missing UagLicenseCode";
  // /**
  // * 状态码：1017104.
  // */
  // public static final int RESULT_CODE_1017104 = 1017104;
  //
  // /**
  // * 状态消息：Missing UagPosition.
  // */
  // public static final String RESULT_MSG_1017104 = "Missing UagPosition";
  // /**
  // * 状态码：1017105.
  // */
  // public static final int RESULT_CODE_1017105 = 1017105;
  //
  // /**
  // * 状态消息：Missing UagExperience.
  // */
  // public static final String RESULT_MSG_1017105 = "Missing UagExperience";
  // /**
  // * 状态码：1017106.
  // */
  // public static final int RESULT_CODE_1017106 = 1017106;
  //
  // /**
  // * 状态消息：Missing Acid.
  // */
  // public static final String RESULT_MSG_1017106 = "Missing Acid";
  // /**
  // * 状态码：1017107.
  // */
  // public static final int RESULT_CODE_1017107 = 1017107;
  //
  // /**
  // * 状态消息：Missing Aoid.
  // */
  // public static final String RESULT_MSG_1017107 = "Missing Aoid";
  //
  // /**
  // * 状态码： 1017108.
  // */
  // public static final int RESULT_CODE_1017108 = 1017108;
  //
  // /**
  // * 状态消息：Missing phone number.
  // */
  // public static final String RESULT_MSG_1017108 = "Missing phone number";
  // /**
  // * 状态码： 1017109.
  // */
  // public static final int RESULT_CODE_1017109 = 1017109;
  //
  // /**
  // * 状态消息：Missing Mail number.
  // */
  // public static final String RESULT_MSG_1017109 = "Missing Mail number";
  // /**
  // * 状态码： 1017110.
  // */
  // public static final int RESULT_CODE_1017110 = 1017110;
  //
  // /**
  // * 状态消息：Missing password.
  // */
  // public static final String RESULT_MSG_1017110 = "Missing password";
  //
  // /**
  // * 状态码： 1017200.
  // */
  // public static final int RESULT_CODE_1017200 = 1017200;
  //
  // /**
  // * 状态消息：Invalid phone number.
  // */
  // public static final String RESULT_MSG_1017200 = "Invalid phone number";
  //
  // /**
  // * 状态码： 1017201.
  // */
  // public static final int RESULT_CODE_1017201 = 1017201;
  //
  // /**
  // * 状态消息： Invalid email address.
  // */
  // public static final String RESULT_MSG_10187201 = "Invalid email address";
  // /**
  // * 状态码： 1017300.
  // */
  // public static final int RESULT_CODE_1017300 = 1017300;
  //
  // /**
  // * 状态消息： Agent licence number exists. Please change it.
  // */
  // public static final String RESULT_MSG_1017300 =
  // "Agent licence number exists. Please change it.";
  //
  //
  // /**
  // * Module : /user-management Interface :/users/check/info Method : post
  // Module
  // * number : 1 Interface number : 018
  // */
  // /**
  // * 状态码： 1018100.
  // */
  // public static final int RESULT_CODE_1018100 = 1018100;
  //
  // /**
  // * 状态消息：Missing phone number.
  // */
  // public static final String RESULT_MSG_1018100 = "Missing phone number";
  // /**
  // * 状态码： 1018101.
  // */
  // public static final int RESULT_CODE_1018101 = 1018101;
  //
  // /**
  // * 状态消息：Missing Mail number.
  // */
  // public static final String RESULT_MSG_1018101 = "Missing Mail number";
  // /**
  // * 状态码： 1018102.
  // */
  // public static final int RESULT_CODE_1018102 = 1018102;
  //
  // /**
  // * 状态消息：Missing areaCode.
  // */
  // public static final String RESULT_MSG_1018102 = "Missing areaCode";
  // /**
  // * 状态码： 1018200.
  // */
  // public static final int RESULT_CODE_1018200 = 1018200;
  //
  // /**
  // * 状态消息：Invalid phone number.
  // */
  // public static final String RESULT_MSG_1018200 = "Invalid phone number";
  //
  // /**
  // * 状态码： 1018201.
  // */
  // public static final int RESULT_CODE_1018201 = 1018201;
  //
  // /**
  // * 状态消息： Invalid email address.
  // */
  // public static final String RESULT_MSG_1018201 = "Invalid email address";
  //
  // /**
  // * Module : /user-management Interface :/users/check/info Method : post
  // Module
  // * number : 1 Interface number : 019
  // */
  //
  // /**
  // * 状态码： 1019100.
  // */
  // public static final int RESULT_CODE_1019100 = 1019100;
  //
  // /**
  // * 状态消息：Missing user.
  // */
  // public static final String RESULT_MSG_1019100 = "Missing user";
  // /**
  // * 状态码： 1019300.
  // */
  // public static final int RESULT_CODE_1019300 = 1019300;
  //
  // /**
  // * 状态消息：Users do not exist or are frozen.
  // */
  // public static final String RESULT_MSG_1019300 =
  // "Users do not exist or are frozen";
  //
  // /**
  // * Module : /user-management Interface :/users/edit/password Method : post
  // * Module number : 1 Interface number : 020
  // */
  //
  // /**
  // * 状态码： 1020100.
  // */
  // public static final int RESULT_CODE_1020100 = 1020100;
  //
  // /**
  // * 状态消息：Missing password.
  // */
  // public static final String RESULT_MSG_1020100 = "Missing password";
  //
  // /**
  // * 状态码：1020300.
  // */
  // public static final int RESULT_CODE_1020300 = 1020300;
  //
  // /**
  // * 状态消息：新密码与旧密码相同.
  // */
  // public static final String RESULT_MSG_1020300 =
  // "New password can't be the same with the old password";
}
