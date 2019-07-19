package com.plastech.crm.resultcode;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 下午2:01:45
 *
 */
public class ResultCodeLoyalty {
  private ResultCodeLoyalty() {}
  // Module :/loyalty-management
  // Module number : 6
  // Interface : /loyalty
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_6001200 = 6001200;
  public static final String RESULT_MSG_6001200 = "Invalid name";

  public static final int RESULT_CODE_6001100 = 6001100;
  public static final String RESULT_MSG_6001100 = "Missing minFrequency";

  public static final int RESULT_CODE_6001101 = 6001101;
  public static final String RESULT_MSG_6001101 = "Missing maxFrequency";

  public static final int RESULT_CODE_6001102 = 6001102;
  public static final String RESULT_MSG_6001102 = "Missing Duration";

  public static final int RESULT_CODE_6001300 = 6001300;
  public static final String RESULT_MSG_6006300 = "Loyalty name repetition";

  // Module :/loyalty-management
  // Module number : 6
  // Interface : /loyalty/{lid}
  // Interface number : 002
  // Method : delete

  public static final int RESULT_CODE_6002200 = 6002200;
  public static final String RESULT_MSG_6002200 = "Invalid lid";

  public static final int RESULT_CODE_6002300 = 6002300;
  public static final String RESULT_MSG_6002300 =
      "Loyalty information does not exist";


  // Module :/loyalty-management
  // Module number : 6
  // Interface :/loyalty/order/exchange
  // Interface number : 003
  // Method :patch

  public static final int RESULT_CODE_6003200 = 6003200;
  public static final String RESULT_MSG_6003200 = "Invalid ccidA";

  public static final int RESULT_CODE_6003201 = 6003201;
  public static final String RESULT_MSG_6003201 = "Invalid ccidB";

  public static final int RESULT_CODE_6003300 = 6003300;
  public static final String RESULT_MSG_6003300 =
      "Sorting information does not exist";
}
