package app.service.impl;

import app.bo.SysUserQueryBo;
import app.bo.UserBo;
import app.model.SysUserPo;
import app.model.User;
import app.repository.UserRepository;
import app.service.ISysUserService;
import app.vo.AddSysUserVo;
import app.vo.SysUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import util.DeleteStatus;
import util.JsonPage;
import util.ex.CmctError;
import util.ex.Exceptions;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: lxb
 * @Date: 2018/12/27 0027
 * @Description:
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Value("${user.default-pwd}")
    private String defaultPwd;

    private String CODE;
@Autowired
private UserRepository mapper;
    @Override
    public User getUserInfo(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
      //  return sysUserMapper.findSysUserByUserName(userName);
       return mapper.findByUsername(userName);
    }

    @Override
    public User getUserInfoBy(String moblie) {
        if (StringUtils.isEmpty(moblie)) {
            return null;
        }
        return mapper.findAllByMobile(moblie);
    }

    @Override
    public User getUserInfoByUserId(String userId) {
        return mapper.findByUsername(userId);
    }

    //TODO
    @Override
    public JsonPage<SysUserVo> getSysUserVos(SysUserQueryBo pageReq) {

     //   if (pageReq == null) {
        //    pageReq = new SysUserQueryBo();
     //   }
      //  Page<SysUserVo> page = PageHelper.startPage(pageReq.getPage(), pageReq.getRows());
      //  sysUserMapper.findAllSysUsers(pageReq);

      //  return new JsonPage(page);
        return  null;
    }

    //TODO
    @Override
    public void updateUserRoles(String userId, List<String> roleIds, String modifyBy) {

        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }
        if (CollectionUtils.isEmpty(roleIds)) {

        }
    }

    @Override
    public void resetUserPwd(String userId, String passWord) {
        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }
        mapper.save(User.builder()
                .password(passWord)
                .userId(userId)
                .modifyBy(userId)
                .modifyDate(new Date())
                .build());
    }


    @Override
    public void deleteUser(String userId, String modifyBy) {
        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }
         mapper.save(User.builder()
                 .deleteStatus(DeleteStatus.NO.ordinal())
                 .modifyDate(new Date())
                 .modifyBy(modifyBy)
                 .userId(userId)
                 .build());

    }

    //todo
    @Override
    public void addNewUser(AddSysUserVo newSysUser, String modifyBy) {
        if (newSysUser == null) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "用户信息不能为空");
        }
        String userId= UUID.randomUUID().toString();
        newSysUser.setPassword(newSysUser.getPassword());
        User sysUserTargetPo = User.builder().build();
        BeanUtils.copyProperties(newSysUser, sysUserTargetPo);
        sysUserTargetPo.setCreateBy(modifyBy);
        sysUserTargetPo.setCreateDate(new Date());
        sysUserTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
        sysUserTargetPo.setUserId(userId);
        mapper.save(sysUserTargetPo);
    }


    @Override
    public boolean uniMobile(String userId, String mobile) {
       List<User> users= mapper.findAllByUsernameAndDeleteStatus(mobile,DeleteStatus.YES.ordinal());
        return users.size() <= 0;
    }

    @Override
    public void modify(SysUserPo userS) throws Exception {

    }

}
