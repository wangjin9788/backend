package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.parameter.AddOrUpdateGradeParameters;
import com.plastech.crm.model.vo.ContractGradeListView;
import com.plastech.crm.model.vo.GradeView;
import com.plastech.crm.model.vo.GroupsView;
import com.plastech.crm.resultcode.ResultCodeGrade;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.GradeService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 上午10:17:54
 *
 */
@Service
public class GradeServiceImpl extends BaseService implements GradeService {

  @Override
  public AppPageModel<List<GradeView>> searchGradeList(
      final Integer currentpage, final Integer perpage,
      final Map<String, Object> map) {
    final AppPage<List<GradeView>> page = new AppPage<>(perpage, currentpage);
    page.start();
    final List<GradeView> searchCommodity = gradeMapper.searchGradeList(map);
    page.setResult(searchCommodity);
    return page.convertToAppPageModel();
  }

  @Override
  public ResultJson<Integer> createGrade(final Long uId,
      final AddOrUpdateGradeParameters param) {
    try {
      final Long ctId = param.getCtId();
      final Long mfId = param.getMfId();
      final String gradeNumber = param.getGradeNumber();

      // 检查牌号是否存在根据（品类 生产商 牌号）
      final Long checkGeId =
          gradeMapper.checkGradePresence(mfId, ctId, gradeNumber);
      if (checkGeId != null) {
        return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5001300);
      }

      final Grade grade = new Grade();
      addOrUpdateGrade(null, uId, ctId, mfId, gradeNumber, grade);

      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 1,
          ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("grade Exception", 0);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.ADD_FAIL);
  }

  private void addOrUpdateGrade(final Long geId, final Long uId,
      final Long ctId, final Long mfId, final String gradeNumber,
      final Grade grade) {
    if (geId == null) {
      grade.setCreatorId(uId == null ? 1L : uId);
      grade.setCreatorTime(new Date());
    }
    grade.setStatus(0);
    grade.setCtid(ctId);
    grade.setMfid(mfId);
    grade.setGradeNumber(gradeNumber);
    grade.setLastUpdateId(uId == null ? 1L : uId);
    grade.setLastUpdateTime(new Date());
    if (geId == null) {
      gradeMapper.insertSelective(grade);
    } else {
      grade.setGeid(geId);
      gradeMapper.updateByPrimaryKey(grade);
    }
  }

  @Override
  public ResultJson<Integer> updateGrade(final Long geId, final Long uId,
      final AddOrUpdateGradeParameters param) {
    try {
      final Long ctId = param.getCtId();
      final Long mfId = param.getMfId();
      final String gradeNumber = param.getGradeNumber();
      // 检查牌号信息
      final Grade grade = gradeMapper.selectByPrimaryKey(geId);
      if (grade == null) {
        return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002301);
      }
      // 检查牌号是否存在根据（品类 生产商 牌号）
      final Long checkGeId =
          gradeMapper.checkGradePresence(mfId, ctId, gradeNumber);
      if (checkGeId != null) {
        if (geId != checkGeId.longValue()) {
          return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002300);
        }
      }
      final Grade cpGradeInfo = CommonTools.deepCloneObject(grade);
      addOrUpdateGrade(geId, uId, ctId, mfId, gradeNumber, cpGradeInfo);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 1,
          ResultCodeSystem.SAVE_SUCCESS);
    } catch (final Exception e) {
      logger.info("update grade Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, 1,
        ResultCodeSystem.SAVE_FAIL);
  }

  @Override
  public ResultJson<Boolean> deleteGrade(final Long geId) {
    try {
      final Grade gradeInfo = gradeMapper.selectByPrimaryKey(geId);
      if (gradeInfo == null || gradeInfo.getStatus() == -1) {
        return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5003300);
      }
      final Boolean checkContractGrade =
          contractGradeMapper.checkContractGrade(geId);
      if (checkContractGrade) {
        return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5003301);
      }
      gradeInfo.setStatus(-1);
      gradeMapper.updateByPrimaryKey(gradeInfo);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info("delete grade Exception", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.DELETE_FAIL);
  }

  @Override
  public List<GroupsView> getGroupsSelectionForSupplier() {
    return groupsMapper.getGroupsSelectionForSupplier();
  }

  @Override
  public List<ContractGradeListView> getContractGradeList() {
    try {
      return gradeMapper.getContractGradeList();
    } catch (final Exception e) {
      logger.info("get Contract Grade List Exception:{}", e);
    }
    return null;
  }

  @Override
  public  List<Map<String,Object>> getContractRelationNumberByGeid(final Long geid) {
    return gradeMapper.getContractRelationNumberByGeid(geid);
  }

  @Override
  public Grade getCtidAndMfidByGeid(final Long geid) {
    return gradeMapper.getCtidAndMfidByGeid(geid);
  }

}
