package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Groups;
import com.plastech.crm.model.parameter.AddOrUpdateGroupsParameters;
import com.plastech.crm.model.vo.GroupsView;
import com.plastech.crm.resultcode.ResultCodeGroups;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.GroupsService;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月15日 上午10:01:31
 *
 */
@Service
public class GroupsServiceImpl extends BaseService implements GroupsService {

  @Override
  public int addOrUpdateGroups(final AddOrUpdateGroupsParameters param,
      final Long currentUid) {
    try {
      final Long gid = param.getGid();
      if (gid != null && gid > 0) {// 更新
        final Groups groups = groupsMapper.selectByPrimaryKey(gid);
        if (groups == null) {
          return 2;
        }
        if (param.getCode() == 0 && !groups.getName().equals(param.getName())) {// 如果是集团，需要做重名校验
          final Groups esGroups = groupsMapper
              .selectByNameAndType(param.getName(), param.getType());
          if (esGroups != null) {
            return 1;
          }
        }

        groups.setName(param.getName());
        groups.setType(param.getType());
        groups.setCode(param.getCode());
        groups.setStatus(0);
        groups.setNote(param.getNote());
        groupsMapper.updateByPrimaryKey(groups);
      } else {// 新建
        if (param.getCode() == 0) {// 如果是集团，需要做重名校验
          final Groups esGroups = groupsMapper
              .selectByNameAndType(param.getName(), param.getType());
          if (esGroups != null) {
            return 1;
          }
        }

        final Groups groups = new Groups();
        groups.setName(param.getName());
        groups.setType(param.getType());
        groups.setCode(param.getCode());
        groups.setStatus(0);
        groups.setNote(param.getNote());
        groups.setCreatorId(currentUid);
        groups.setCreatorTime(new Date());
        groupsMapper.insertSelective(groups);
      }
      return 0;
    } catch (final Exception e) {
      logger.error("Add or update groups error , {}", e);
    }
    return -1;
  }

  @Override
  public List<GroupsView> searchGroupsList(final String searchkey) {
    String searchKey = null;
    if (!Strings.isNullOrEmpty(searchkey)) {
      searchKey = "%" + searchkey + "%";
    }
    return groupsMapper.searchGroupsList(searchKey);
  }

  @Override
  public ResultJson<Boolean> updateGroupsName(final Long gid,
      final AddOrUpdateGroupsParameters param, final Long uid) {
    try {
      final Groups groupsInfo = groupsMapper.selectByPrimaryKey(gid);
      if (groupsInfo == null) {
        return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11002300);
      }
      if (param.getName().equals(groupsInfo.getName())) {
        return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11002301);
      }
      groupsInfo.setName(param.getName());
      groupsMapper.updateByPrimaryKeySelective(groupsInfo);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.SAVE_SUCCESS);
    } catch (final Exception e) {
      logger.info("groups Update Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.SAVE_FAIL);
  }


  @Override
  public ResultJson<Boolean> deleteGroups(final Long gid) {
    try {
      final Groups groupsInfo = groupsMapper.selectByPrimaryKey(gid);
      if (groupsInfo == null) {
        return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11003300);
      }
      // 检查客户与客户分公司是否有关联
      final Boolean isExist = customerMapper.checkBranchDoesItExist(null, gid);
      if (isExist) {
        return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11003301);
      }
      groupsInfo.setStatus(-1);
      groupsMapper.updateByPrimaryKeySelective(groupsInfo);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info("groups delete Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.DELETE_FAIL);
  }

  @Override
  public List<GroupsView> getGroupsChooseList() {
    return groupsMapper.getGroupsChooseList();
  }



}
