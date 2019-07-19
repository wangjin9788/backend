package com.plastech.crm.resultcode;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 下午3:25:28
 *
 */
public class ResultCodeGrade {

  private ResultCodeGrade() {}
  // Module :/grade-management
  // Module number : 5
  // Interface : /grade
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_5001200 = 5001200;
  public static final String RESULT_MSG_5001200 = "Invalid Grade Number";

  public static final int RESULT_CODE_5001201 = 5001201;
  public static final String RESULT_MSG_5001201 = "Invalid ctId";

  public static final int RESULT_CODE_5001202 = 5001202;
  public static final String RESULT_MSG_5001202 = "Invalid mfId";

  public static final int RESULT_CODE_5001300 = 5001300;
  public static final String RESULT_MSG_5001300 =
      "grade information exists";


  // Module :/grade-management
  // Module number : 5
  // Interface : /grade/{geId}
  // Interface number : 002
  // Method : put

  public static final int RESULT_CODE_5002200 = 5002200;
  public static final String RESULT_MSG_5002200 = "Invalid geId";

  public static final int RESULT_CODE_5002201 = 5002201;
  public static final String RESULT_MSG_5002201 = "Invalid mfId";

  public static final int RESULT_CODE_5002202 = 5002202;
  public static final String RESULT_MSG_5002202 = "Invalid ctId";

  public static final int RESULT_CODE_5002203 = 5002203;
  public static final String RESULT_MSG_5002203 = "Invalid Grade Number";

  public static final int RESULT_CODE_5002300 = 5002300;
  public static final String RESULT_MSG_5002300 =
      "grade information exists";

  public static final int RESULT_CODE_5002301 = 5002301;
  public static final String RESULT_MSG_5002301 =
      "grade information does not exist";


  // Module :/grade-management
  // Module number : 5
  // Interface : /grade/{geId}
  // Interface number : 003
  // Method : delete

  public static final int RESULT_CODE_5003200 = 5003200;
  public static final String RESULT_MSG_5003200 = "Invalid geId";

  public static final int RESULT_CODE_5003300 = 5003300;
  public static final String RESULT_MSG_5003300 =
      "grade information does not exist";

  public static final int RESULT_CODE_5003301 = 5003301;
  public static final String RESULT_MSG_5003301 =
      "The grade between category change and contract can not be deleted.";


  // Module :/grade-management
  // Module number : 5
  // Interface : /grade/contract/number
  // Interface number : 004
  // Method : get

  public static final int RESULT_CODE_5004200 = 5004200;
  public static final String RESULT_MSG_5004200 = "Invalid geId";
}
