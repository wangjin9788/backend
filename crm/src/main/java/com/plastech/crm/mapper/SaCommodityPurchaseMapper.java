package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaCommodityPurchase;
import com.plastech.crm.model.vo.SaCommodityAnalysisView;
import com.plastech.crm.model.vo.SaCommodityPurchaseDetail;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaCommodityPurchaseMapper
    extends BaseTkMapper<SaCommodityPurchase> {

  List<SaCommodityPurchase> getSaCommodityPurchaseStatisticsInfoByMonth(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid,
      @Param(value = "gid") Long gid);

  List<SaCommodityPurchase> getSaCommodityPurchaseStatisticsInfoByYear(
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid);

  /**
   * 总购买量
   *
   * @param year
   * @param month
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  SalesAnalysisView getSaCommodityPurchaseTotal(Map<String, Object> map);

  /**
   * 根据条件查询对应生产商和供应商
   *
   * @param year
   * @param month
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  List<SaCommodityAnalysisView> getSaCommodityPurchaseTotalById(
      Map<String, Object> map);

  /**
   * 获取表中数据
   *
   * @return
   */
  SaCommodityPurchase getTableData();

  /**
   * 根据id进行查询
   */
  SaCommodityPurchase getSacommodityPurchaseInfoById(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "gid") Long gid, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid);

  /**
   * 获取详情页面参数
   *
   * @param year
   * @param month
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  SaManufacturerTotalDataView getSaCommodityPurchaseDetailTotal(
      Map<String, Object> map);

  /**
   * 搜索客户分析品类详情中的客户
   *
   * @param year
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  List<SaCommodityPurchaseDetail> searchCommodityPurchaseDetailCustomer(
      Map<String, Object> map);


  void deleteSaCommodityPurchaseDetailByYearAndMonth(
      @Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid);

  // 根据年月删除与id不相同的数据
  void deleteSaCommodityPurchaseByScdid(@Param(value = "year") Integer year,
      @Param(value = "month") Integer month,
      @Param(value = "list") List<Long> list);

}
