package com.plastech.crm.resultcode;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月14日 下午2:54:43
 *
 */
public final class ResultCodeGroups {

  private ResultCodeGroups() {}

  // Module : /groups-management
  // Module number : 11
  // Interface : /groups
  // Interface number : 001
  // Method : post
  public static final int RESULT_CODE_11001100 = 11001100;
  public static final String RESULT_MSG_11001100 = "Missing name";

  public static final int RESULT_CODE_11001200 = 11001200;
  public static final String RESULT_MSG_11001200 = "Invalid type";

  public static final int RESULT_CODE_11001300 = 11001300;
  public static final String RESULT_MSG_11001300 =
      "Groups name is already exists";

  // Module : /groups-management
  // Module number : 11
  // Interface : /groups/{gid}
  // Interface number : 002
  // Method : put
  public static final int RESULT_CODE_11002200 = 11002200;
  public static final String RESULT_MSG_11002200 = "Invalid gid";

  public static final int RESULT_CODE_11002201 = 11001201;
  public static final String RESULT_MSG_11002201 = "Invalid name";

  public static final int RESULT_CODE_11002300 = 11002300;
  public static final String RESULT_MSG_11002300 =
      "Groups  does not exist";

  public static final int RESULT_CODE_11002301 = 11002301;
  public static final String RESULT_MSG_11002301 =
      "Groups Name already exists";

  // Module : /groups-management
  // Module number : 11
  // Interface : /groups/{gid}
  // Interface number : 003
  // Method : delete
  public static final int RESULT_CODE_11003200 = 10001100;
  public static final String RESULT_MSG_11003200 = "Missing gid";

  public static final int RESULT_CODE_11003300 = 11003300;
  public static final String RESULT_MSG_11003300 =
      "Groups  does not exist";

  public static final int RESULT_CODE_11003301 = 11003301;
  public static final String RESULT_MSG_11003301 =
      "Groups  Existence of correlation";

}
