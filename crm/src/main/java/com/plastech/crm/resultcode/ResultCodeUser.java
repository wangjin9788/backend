package com.plastech.crm.resultcode;

/**
 * @author wangJin
 *
 */
public class ResultCodeUser {
  private ResultCodeUser() {}

  // Module : /user-management
  // Module number : 2
  // Interface : /user
  // Interface number : 001
  // Method : post
  public static final int RESULT_CODE_2001200 = 2001200;
  public static final String RESULT_MSG_2001200 = "Invalid name";

  public static final int RESULT_CODE_2001201 = 2001201;
  public static final String RESULT_MSG_2001201 = "Invalid mail";

  public static final int RESULT_CODE_2001202 = 2001202;
  public static final String RESULT_MSG_2001202 = "Invalid RoleId";

  public static final int RESULT_CODE_2001203 = 2001203;
  public static final String RESULT_MSG_2001203 = "Invalid RoleName";

  public static final int RESULT_CODE_2001204 = 2001204;
  public static final String RESULT_MSG_2001204 = "Invalid phone number";

  public static final int RESULT_CODE_2001300 = 2001300;
  public static final String RESULT_MSG_2001300 =
      "Telephone number or mailbox exists";

  public static final int RESULT_CODE_2001301 = 2001301;
  public static final String RESULT_MSG_2001301 = "mail format is not correct";

  // Module : /user-management
  // Module number : 2
  // Interface : /user/{uid}
  // Interface number : 002
  // Method : put
  public static final int RESULT_CODE_2002200 = 2002200;
  public static final String RESULT_MSG_2002200 = "Invalid name";

  public static final int RESULT_CODE_2002201 = 2002201;
  public static final String RESULT_MSG_2002201 = "Invalid mail";

  public static final int RESULT_CODE_2002202 = 2002202;
  public static final String RESULT_MSG_2002202 = "Invalid RoleId";

  public static final int RESULT_CODE_2002203 = 2002203;
  public static final String RESULT_MSG_2002203 = "Invalid RoleName";

  public static final int RESULT_CODE_2002204 = 2002204;
  public static final String RESULT_MSG_2002204 = "Invalid uid";

  public static final int RESULT_CODE_2002205 = 2001205;
  public static final String RESULT_MSG_2002205 = "Invalid phone number";


  public static final int RESULT_CODE_2002300 = 2002300;
  public static final String RESULT_MSG_2002300 = "user does not exist";

  public static final int RESULT_CODE_2002301 = 2002301;
  public static final String RESULT_MSG_2002301 =
      "Telephone number or mailbox exists";

  public static final int RESULT_CODE_2002302 = 2002302;
  public static final String RESULT_MSG_2002302 = "mail format is not correct";

  // Module :/user-management
  // Module number : 2
  // Interface : /user/status/{uid}
  // Interface number : 003
  // Method : put
  public static final int RESULT_CODE_2003100 = 2003100;
  public static final String RESULT_MSG_2003100 = "Missing status";

  public static final int RESULT_CODE_2003200 = 2003200;
  public static final String RESULT_MSG_2003200 = "Invalid uid";

  public static final int RESULT_CODE_2003300 = 2003300;
  public static final String RESULT_MSG_2003300 = "user does not exist";

  // Module :/user-management
  // Module number : 2
  // Interface : /user/password/change
  // Interface number : 004
  // Method : put
  public static final int RESULT_CODE_2004100 = 2004100;
  public static final String RESULT_MSG_2004100 = "Missing OldPassword";

  public static final int RESULT_CODE_2004101 = 2004101;
  public static final String RESULT_MSG_2004101 = "Invalid NewPassword";

  public static final int RESULT_CODE_2004300 = 2003300;
  public static final String RESULT_MSG_2004300 = "The old password is incorrect";


}
