package com.plastech.crm.resultcode;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月14日 下午2:54:43
 *
 */
public final class ResultCodeSupplier {

  private ResultCodeSupplier() {}

  // Module : /supplier-management
  // Module number : 10
  // Interface : /suppliers
  // Interface number : 001
  // Method : post
  public static final int RESULT_CODE_10001100 = 10001100;
  public static final String RESULT_MSG_10001100 = "Missing param data";

  public static final int RESULT_CODE_10001101 = 10001101;
  public static final String RESULT_MSG_10001101 = "Missing suName";

  public static final int RESULT_CODE_10001102 = 10001102;
  public static final String RESULT_MSG_10001102 = "Missing Full Name";

  public static final int RESULT_CODE_10001201 = 10001201;
  public static final String RESULT_MSG_10001201 = "Invalid linkmanName";

  public static final int RESULT_CODE_10001300 = 10001300;
  public static final String RESULT_MSG_10001300 =
      "Supplier name is already exists";

  public static final int RESULT_CODE_10001302 = 10001302;
  public static final String RESULT_MSG_10001302 =
      "Incorrect mobile phone number format";

  public static final int RESULT_CODE_10001303 = 10001303;
  public static final String RESULT_MSG_10001303 =
      "Incorrect mailbox number format";


  // Module : /supplier-management
  // Module number : 10
  // Interface : /suppliers
  // Interface number : 002
  // Method : put
  public static final int RESULT_CODE_10002100 = 10002100;
  public static final String RESULT_MSG_10002100 = "Missing param data";

  public static final int RESULT_CODE_10002101 = 10002101;
  public static final String RESULT_MSG_10002101 = "Missing suName";

  public static final int RESULT_CODE_10002102 = 10002102;
  public static final String RESULT_MSG_10002102 = "Missing full Name";

  public static final int RESULT_CODE_10002201 = 10002201;
  public static final String RESULT_MSG_10002201 = "Invalid linkmanName";


  public static final int RESULT_CODE_10002203 = 10002203;
  public static final String RESULT_MSG_10002203 = "Invalid suid";

  public static final int RESULT_CODE_10002300 = 10002300;
  public static final String RESULT_MSG_10002300 =
      "Supplier name already exists";

  public static final int RESULT_CODE_10002301 = 10002301;
  public static final String RESULT_MSG_10002301 =
      "The Supplier you operate does Not exists";

  public static final int RESULT_CODE_10002302 = 10002302;
  public static final String RESULT_MSG_10002302 =
      "Incorrect mobile phone number format";

  public static final int RESULT_CODE_10002303 = 10002303;
  public static final String RESULT_MSG_10002303 =
      "Incorrect mailbox number format";

  // Module : /supplier-management
  // Module number : 10
  // Interface : /suppliers
  // Interface number : 003
  // Method : delete
  public static final int RESULT_CODE_10003200 = 10003200;
  public static final String RESULT_MSG_10003200 = "Invalid suid";

  public static final int RESULT_CODE_10003300 = 10003300;
  public static final String RESULT_MSG_10003300 =
      "The Supplier you delete does Not exists";

  // Module : /supplier-management
  // Module number : 10
  // Interface : /suppliers/basedetail/{suid}
  // Interface number : 004
  // Method : get
  public static final int RESULT_CODE_10004200 = 10004200;
  public static final String RESULT_MSG_10004200 = "Invalid suid";
}
