package com.plastech.crm.resultcode;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 上午9:45:14
 *
 */
public class ResultCodeCustomer {

  private ResultCodeCustomer() {}
  // Module :/customer-management
  // Module number : 7
  // Interface : /loyalty
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_7001200 = 7001200;
  public static final String RESULT_MSG_7001200 = "Invalid CuName";

  public static final int RESULT_CODE_7001201 = 7001201;
  public static final String RESULT_MSG_7001201 = "Invalid gid";

  public static final int RESULT_CODE_7001202 = 7001202;
  public static final String RESULT_MSG_7001202 = "Invalid linkmanName";

  public static final int RESULT_CODE_7001302 = 7001302;
  public static final String RESULT_MSG_7001302 = "The customer branch exists";

  public static final int RESULT_CODE_7001303 = 7001303;
  public static final String RESULT_MSG_7001303 =
      "Incorrect mobile phone number format";

  public static final int RESULT_CODE_7001304 = 10001304;
  public static final String RESULT_MSG_10001304 =
      "Incorrect mailbox number format";

  // Module :/customer-management
  // Module number : 7
  // Interface : /customer/{cuid}
  // Interface number : 002
  // Method : put

  public static final int RESULT_CODE_7002200 = 7002200;
  public static final String RESULT_MSG_7002200 = "Invalid CuName";

  public static final int RESULT_CODE_7002201 = 7001201;
  public static final String RESULT_MSG_7002201 = "Invalid gid";

  public static final int RESULT_CODE_7002202 = 7002202;
  public static final String RESULT_MSG_7002202 = "Invalid cuid";

  public static final int RESULT_CODE_7002203 = 7002203;
  public static final String RESULT_MSG_7002203 = " Invalid linkmanName";

  public static final int RESULT_CODE_7002302 = 7002302;
  public static final String RESULT_MSG_7002302 = "The customer branch exists";

  public static final int RESULT_CODE_7002303 = 7002303;
  public static final String RESULT_MSG_7002303 =
      "Incorrect mobile phone number format";

  public static final int RESULT_CODE_7002304 = 10002304;
  public static final String RESULT_MSG_10002304 =
      "Incorrect mailbox number format";

  // Module :/customer-management
  // Module number : 7
  // Interface : /customer
  // Interface number : 003
  // Method : delete

  public static final int RESULT_CODE_7003200 = 7003200;
  public static final String RESULT_MSG_7003200 = "Invalid cuid";

  public static final int RESULT_CODE_7003300 = 7003300;
  public static final String RESULT_MSG_7003300 = "The customer branch exists";

  // Module :/customer-management
  // Module number : 7
  // Interface : /customer/basedetail/{cuid}
  // Interface number : 004
  // Method : get

  public static final int RESULT_CODE_7004200 = 7004200;
  public static final String RESULT_MSG_7004200 = "Invalid cuid";


  // Module :/customer-management
  // Module number : 7
  // Interface : /customer/contract/number
  // Interface number : 005
  // Method : get

  public static final int RESULT_CODE_7005200 = 7005200;
  public static final String RESULT_MSG_7005200 = "Invalid cuid";


}
