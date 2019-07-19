package com.plastech.crm.resultcode;

/**
 * @author 王进
 *
 */
public class ResultCodeManufacturer {

  private ResultCodeManufacturer() {}
  // Module :/manufacturer-management
  // Module number : 4
  // Interface : /manufacturer
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_4001200 = 4001200;
  public static final String RESULT_MSG_4001200 = "Invalid name";

  public static final int RESULT_CODE_4001300 = 4001300;
  public static final String RESULT_MSG_4001300 = "Producer name exists";

  // Module :/manufacturer-management
  // Module number : 3
  // Interface : /manufacturer/{mfId}
  // Interface number : 002
  // Method : put

  public static final int RESULT_CODE_4002200 = 4002200;
  public static final String RESULT_MSG_4002200 = "Invalid name";

  public static final int RESULT_CODE_4002201 = 4002201;
  public static final String RESULT_MSG_4002201 = "Invalid ctId";

  public static final int RESULT_CODE_4002300 = 4002300;
  public static final String RESULT_MSG_4002300 = "Producer name exists";

  public static final int RESULT_CODE_4002301 = 4002301;
  public static final String RESULT_MSG_4002301 = "Producer does not exist";

  // Module :/manufacturer-management
  // Module number : 3
  // Interface : /manufacturer/{mfId}
  // Interface number : 003
  // Method : delete

  public static final int RESULT_CODE_4003200 = 4003200;
  public static final String RESULT_MSG_4003200 = "Invalid name";

  public static final int RESULT_CODE_4003300 = 4003300;
  public static final String RESULT_MSG_4003300 = "Manufacturer does not exist";
  public static final int RESULT_CODE_4003301 = 4003301;
  public static final String RESULT_MSG_4003301 =
      " Manufacturer Relevant relationships";


}
