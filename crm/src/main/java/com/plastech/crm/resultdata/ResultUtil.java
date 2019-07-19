package com.plastech.crm.resultdata;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;
import com.plastech.crm.resultcode.ResultCodeCommodity;
import com.plastech.crm.resultcode.ResultCodeContract;
import com.plastech.crm.resultcode.ResultCodeCustomer;
import com.plastech.crm.resultcode.ResultCodeGrade;
import com.plastech.crm.resultcode.ResultCodeGroups;
import com.plastech.crm.resultcode.ResultCodeImport15;
import com.plastech.crm.resultcode.ResultCodeLogin;
import com.plastech.crm.resultcode.ResultCodeLoyalty;
import com.plastech.crm.resultcode.ResultCodeManufacturer;
import com.plastech.crm.resultcode.ResultCodePermission;
import com.plastech.crm.resultcode.ResultCodeSaCommodityAnalysis;
import com.plastech.crm.resultcode.ResultCodeSaGroups25;
import com.plastech.crm.resultcode.ResultCodeSaManufacturer12;
import com.plastech.crm.resultcode.ResultCodeSalesAnalysis16;
import com.plastech.crm.resultcode.ResultCodeSupplier;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultcode.ResultCodeUser;

/**
 * response util.
 *
 * @author yemin
 *
 */
public final class ResultUtil {

  private ResultUtil() {}

  /**
   * 日志类.
   */
  private static Logger logger = LoggerFactory.getLogger(ResultUtil.class);

  // ======================================================


  /**
   * codeMpa.
   */
  private static Map<Integer, String> msgCodeMap = null; // key:error_code ,
                                                         // value:error_msg

  /**
   * 获取结果.
   *
   * @param resultCode resultCode
   * @return ResultJson
   */
  public static final <T> ResultJson<T> getResult(final int resultCode) {
    return getResult(resultCode, null, null);
  }

  /**
   * 获取结果.
   *
   * @param resultCode resultCode
   * @param data data
   * @param message message
   * @returnResultJson
   */
  public static final <T> ResultJson<T> getResult(int resultCode, final T data,
      String message) {
    if (msgCodeMap == null) {
      initializeMsgcodeMap();
    }

    // Automatic complete resultCode
    if (resultCode < 0) {
      resultCode =
          (!Strings.isNullOrEmpty(message) && message.indexOf("success") != -1)
              ? ResultCodeSystem.RESULT_CODE_0
              : ResultCodeSystem.RESULT_CODE_50;
    }

    // Automatic complete message
    if (Strings.isNullOrEmpty(message)) {
      if (resultCode == 0) {
        message = ResultCodeSystem.OPERATE_SUCCESS;
      } else if (resultCode == 50) {
        message = ResultCodeSystem.OPERATE_FAIL;
      } else if (resultCode == 2) {
        message = ResultCodeSystem.NO_PRIVILEGE;
      } else if (resultCode == 3) {
        message = ResultCodeSystem.PARAM_ERROR;
      } else if (resultCode == 9) {
        message = ResultCodeSystem.INVALID_TOKEN;
      } else if (resultCode == 10) {
        message = ResultCodeSystem.FROZEN_ACCOUNT;
      } else if (resultCode == 500) {
        message = ResultCodeSystem.INNER_ERROR;
      } else if (msgCodeMap.containsKey(resultCode)) {
        message = msgCodeMap.get(resultCode);
      }
    }

    return new ResultJson<>(resultCode, data, message);
  }

  /**
   * read errorCodes info by JavaReflect,put them into map
   */
  private static void initializeMsgcodeMap() {
    msgCodeMap = new HashMap<>();
    readMsgCode(ResultCodeCommodity.class);
    readMsgCode(ResultCodeContract.class);
    readMsgCode(ResultCodeCustomer.class);
    readMsgCode(ResultCodeGrade.class);
    readMsgCode(ResultCodeGroups.class);
    readMsgCode(ResultCodeImport15.class);
    readMsgCode(ResultCodeLogin.class);
    readMsgCode(ResultCodeLoyalty.class);
    readMsgCode(ResultCodeManufacturer.class);
    readMsgCode(ResultCodePermission.class);
    readMsgCode(ResultCodeSaCommodityAnalysis.class);
    readMsgCode(ResultCodeSaGroups25.class);
    readMsgCode(ResultCodeSalesAnalysis16.class);
    readMsgCode(ResultCodeSaManufacturer12.class);
    readMsgCode(ResultCodeSupplier.class);
    readMsgCode(ResultCodeSystem.class);
    readMsgCode(ResultCodeUser.class);
  }

  @SuppressWarnings("rawtypes")
  private static void readMsgCode(final Class clazz) {
    final Field[] fields = clazz.getDeclaredFields();
    try {
      final Map<String, String> map = new HashMap<>();
      if (fields != null && fields.length > 0) {
        for (final Field field : fields) {
          field.setAccessible(true);
          if (field.getType().toString().endsWith("java.lang.String")
              && Modifier.isStatic(field.getModifiers())) {
            final String fieldName = field.getName();
            final String fieldValue =
                (String) field.get(ResultCodeSystem.class);
            final String fieldNameCode = fieldName.replace("MSG", "CODE");
            map.put(fieldNameCode, fieldValue);
          }
        }

        for (final Field field : fields) {
          field.setAccessible(true);
          if (field.getType().toString().endsWith("int")
              && Modifier.isStatic(field.getModifiers())) {
            final String fieldName = field.getName();
            final int fieldValue = (Integer) field.get(ResultCodeSystem.class);
            if (map.containsKey(fieldName)) {
              msgCodeMap.put(fieldValue, map.get(fieldName));
            }
          }
        }
      }
    } catch (final Exception e) {
      logger.error("Error ", e);
    }
  }

  public static String getSelectMsg(final Object obj) {
    return obj != null ? ResultCodeSystem.SELECT_SUCCESS
        : ResultCodeSystem.SELECT_FAIL;
  }

  public static String getDeleteMsg(final Object obj) {
    return obj != null ? ResultCodeSystem.DELETE_SUCCESS
        : ResultCodeSystem.DELETE_FAIL;
  }

  public static String getSaveMsg(final Object obj) {
    return obj != null ? ResultCodeSystem.SAVE_SUCCESS
        : ResultCodeSystem.SAVE_FAIL;
  }

  public static ResultJson<Boolean> getSaveResult(final boolean updateRes) {
    return ResultUtil.getResult(
        updateRes ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        null,
        updateRes ? ResultCodeSystem.SAVE_SUCCESS : ResultCodeSystem.SAVE_FAIL);
  }

  public static ResultJson<Boolean> getAddResult(final boolean addRes) {
    return ResultUtil.getResult(
        addRes ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        addRes,
        addRes ? ResultCodeSystem.ADD_SUCCESS : ResultCodeSystem.ADD_FAIL);
  }

  public static ResultJson<Boolean> getOperateResult(final boolean updateRes) {
    return ResultUtil.getResult(
        updateRes ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        null, updateRes ? ResultCodeSystem.OPERATE_SUCCESS
            : ResultCodeSystem.OPERATE_FAIL);
  }

}
