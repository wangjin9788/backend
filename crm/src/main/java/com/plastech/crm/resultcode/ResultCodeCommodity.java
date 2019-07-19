package com.plastech.crm.resultcode;

/**
 * @author 王进
 *
 */
public class ResultCodeCommodity {

  private ResultCodeCommodity() {}
  // Module :/commodity-management
  // Module number : 3
  // Interface : /commodity
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_3001200 = 3001200;
  public static final String RESULT_MSG_3001200 = "Invalid name";

  public static final int RESULT_CODE_3001300 = 3001300;
  public static final String RESULT_MSG_3001300 = "Brand type name exists";

  // Module :/commodity-management
  // Module number : 3
  // Interface : /commodity/{ctId}
  // Interface number : 002
  // Method : delete

  public static final int RESULT_CODE_3002200 = 3002200;
  public static final String RESULT_MSG_3002200 = "Invalid ctId";

  public static final int RESULT_CODE_3002300 = 3002300;
  public static final String RESULT_MSG_3002300 = "Brand type does not exist";

  public static final int RESULT_CODE_3002301 = 3002301;
  public static final String RESULT_MSG_3002301 =
      " Commodity Relevant relationships";


}
