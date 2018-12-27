package app.service;

import app.bo.SysUserQueryBo;
import app.bo.UserBo;
import app.model.SysUserPo;
import app.model.User;
import app.vo.AddSysUserVo;
import app.vo.SysUserVo;
import util.JsonPage;

import java.util.List;

/**
 * @Auther: lxb
 * @Date: 2018/12/27 0027
 * @Description:
 */
public interface ISysUserService {


    /**
     * 获取某个用户的基本信息
     *
     * @param userName
     * @return
     */
    User getUserInfo(String userName);
    /**
     * 获取某个用户的基本信息
     *
     * @param moblie
     * @return
     */
    User getUserInfoBy(String moblie);
    /**
     * 获取某个用户的基本信息
     *
     * @param userId
     * @return
     */
    User getUserInfoByUserId(String userId);

    /**
     * 获取所有新系统用户的信息
     *
     * @param request
     * @return
     */
    JsonPage<SysUserVo> getSysUserVos(SysUserQueryBo request);

    /**
     * 给用户分配角色
     *
     * @param userId   用户id
     * @param roleIds  角色id列表
     * @param modifyBy
     */
    void updateUserRoles(String userId, List<String> roleIds, String modifyBy);

    /**
     * 重置用户的密码
     *
     * @param userId   用户id
     * @param passWord
     */
    void resetUserPwd(String userId, String passWord);


    /**
     * 删除用户
     *
     * @param userId   用户id
     * @param modifyBy 修改人
     */
    void deleteUser(String userId, String modifyBy);


    /**
     * @param newSysUser 新增用户的信息
     * @param createBy   新增人
     */
    void addNewUser(AddSysUserVo newSysUser, String createBy);


    /**
     * 判断用户是否存在
     *
     * @param userId
     * @param mobile
     * @return
     */
    boolean uniMobile(String userId, String mobile);


    /**
     * 更新用户
     *
     * @param userS 用户
     * @return 返回值含义的说明
     */
    void modify(SysUserPo userS) throws Exception;



}