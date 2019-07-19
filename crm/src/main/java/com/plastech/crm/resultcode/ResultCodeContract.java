package com.plastech.crm.resultcode;

/**
 * @author wangJin
 *
 * @date 2019年2月11日 下午3:38:59
 *
 */
public class ResultCodeContract {

  private ResultCodeContract() {}
  // Module :/contract-management
  // Module number : 8
  // Interface : /contract
  // Interface number : 001
  // Method : post

  public static final int RESULT_CODE_8001200 = 8001200;
  public static final String RESULT_MSG_8001200 = "Invalid Number";

  public static final int RESULT_CODE_8001201 = 8001201;
  public static final String RESULT_MSG_8001201 = "Invalid Cuid";

  public static final int RESULT_CODE_8001202 = 8001202;
  public static final String RESULT_MSG_8001202 = "Invalid Uid";

//  public static final int RESULT_CODE_8001203 = 8001203;
//  public static final String RESULT_MSG_8001203 = "Invalid SigningTime";

  public static final int RESULT_CODE_8001204 = 8001204;
  public static final String RESULT_MSG_8001204 = "Invalid Geid";

  public static final int RESULT_CODE_8001205 = 8001205;
  public static final String RESULT_MSG_8001205 = "Invalid CgSalesVolume";

  public static final int RESULT_CODE_8001206 = 8001206;
  public static final String RESULT_MSG_8001206 = "Invalid CgSalesUnitPrice";

  public static final int RESULT_CODE_8001207 = 8001207;
  public static final String RESULT_MSG_8001207 = "Invalid ContractList";

  public static final int RESULT_CODE_8001300 = 8001300;
  public static final String RESULT_MSG_8001300 = "contract Numbering exists";

  public static final int RESULT_CODE_8001301 = 8001301;
  public static final String RESULT_MSG_8001301 = "Inconsistent currency types";

  // Module :/contract-management
  // Module number : 8
  // Interface : /contract/{coid}
  // Interface number : 002
  // Method : put

  public static final int RESULT_CODE_8002200 = 8002200;
  public static final String RESULT_MSG_8002200 = "Invalid Number";

  public static final int RESULT_CODE_8002201 = 8002201;
  public static final String RESULT_MSG_8002201 = "Invalid Cuid";

  public static final int RESULT_CODE_8002202 = 8002202;
  public static final String RESULT_MSG_8002202 = "Invalid Smid";

//  public static final int RESULT_CODE_8002203 = 8002203;
//  public static final String RESULT_MSG_8002203 = "Invalid SigningTime";

  public static final int RESULT_CODE_8002204 = 8002204;
  public static final String RESULT_MSG_8002204 = "Invalid Geid";

  public static final int RESULT_CODE_8002205 = 8002205;
  public static final String RESULT_MSG_8002205 = "Invalid CgSalesVolume";

  public static final int RESULT_CODE_8002206 = 8002206;
  public static final String RESULT_MSG_8002206 = "Invalid CgSalesUnitPrice";

  public static final int RESULT_CODE_8002207 = 8002207;
  public static final String RESULT_MSG_8002207 = "Invalid coid";

  public static final int RESULT_CODE_8002208 = 8002208;
  public static final String RESULT_MSG_8002208 = "Invalid ContractList";


  public static final int RESULT_CODE_8002300 = 8002300;
  public static final String RESULT_MSG_8002300 = "contract Numbering exists";

  public static final int RESULT_CODE_8002301 = 8002301;
  public static final String RESULT_MSG_8002301 = "nonexistence of contract";

  public static final int RESULT_CODE_8002302 = 8002302;
  public static final String RESULT_MSG_8002302 = "Inconsistent currency types";

  // Module :/contract-management
  // Module number : 8
  // Interface : /contract/list
  // Interface number : 003
  // Method : get
  public static final int RESULT_CODE_8003200 = 8002200;
  public static final String RESULT_MSG_8003200 = "Invalid coid";

  // Module :/contract-management
  // Module number : 8
  // Interface : /contract/expanding
  // Interface number : 004
  // Method : get
  public static final int RESULT_CODE_8004200 = 8002200;
  public static final String RESULT_MSG_8004200 = "Invalid cgid";

  // Module :/contract-management
  // Module number : 8
  // Interface : /contract/expanding
  // Interface number : 005
  // Method : get
  public static final int RESULT_CODE_8005200 = 8005200;
  public static final String RESULT_MSG_8005200 = "Invalid coid";

  // Module :/contract-management
  // Module number : 8
  // Interface : /contract/{coid}
  // Interface number : 006
  // Method : delete
  public static final int RESULT_CODE_8006200 = 8006200;
  public static final String RESULT_MSG_8006200 = "Invalid coid";

  public static final int RESULT_CODE_8006300 = 8006300;
  public static final String RESULT_MSG_8006300 =
      "contracts does not exist";

  // Module :
  // Module number : 8
  // Interface :
  // Interface number : 007
  // Method :
  public static final int RESULT_CODE_8007300 = 8007300;

  public static final String RESULT_MSG_8007300 = "CANNOT_BE_OPERATED_DURING_CONTRACT_IMPORT";
}
