package app.web.common;

import app.bo.AuthRequestBo;
import app.config.JwtTokenUtil;
import app.model.SysUserPo;
import app.model.User;
import app.service.ISysUserService;
import app.vo.AuthResponseVo;
import app.vo.UserTokenVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.MyConstants;
import util.QiniuUtil;
import util.web.WebResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import static app.vo.SysUserVo.transfer;

/**
 * @author 1
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "获取用户token", tags = "公共")
    @PostMapping(value = "token")
    public WebResponse<UserTokenVo> getUserToken(@Valid @RequestBody AuthRequestBo authRequest) {

        User user = sysUserService.getUserInfo(authRequest.getUserName());

        if (user == null || user.getDeleteStatus() == null || user.getDeleteStatus() != 0) {
            return new WebResponse(-1, "账号不存在", null);
        }
        if (!user.getPassword().equals(authRequest.getPassword())) {
            return new WebResponse(-1, "密码错误", null);
        }

        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
        return WebResponse.success(UserTokenVo.builder()
                .authResponse(AuthResponseVo.builder()
                        .randomKey(randomKey)
                        .token(token)
                        .build())
                .sysUser(transfer(user))
                .build());

    }

    @RequestMapping(value = "/uniMobile", method = RequestMethod.GET)
    @ApiOperation(value = "验证手机号", tags = "公共")
    public WebResponse uniMobile(@RequestParam(required = false) String userId, @RequestParam String mobile) {
        boolean result = sysUserService.uniMobile(userId, mobile);
        return new WebResponse(0, "操作成功", result);
    }

    /**
     * 上传头像
     *
     * @param request
     * @param file
     * @return
     */
    @ApiOperation(value = "图片上传", tags = "公共")
    @PostMapping(value = "/upload")
    public WebResponse uploadHeadImg(HttpServletRequest request, MultipartFile file, String userId) {
        boolean flag = false;
        StringBuffer imgName = new StringBuffer();
        if (null != file) {
            String name = MyConstants.idWorkerUtil.nextId() + ".png";
            System.out.println(name);
            if (MyConstants.ifDebug) {
                name = "test_" + name;
            }
            try {
                flag = QiniuUtil.uploadFile(name, file.getBytes());
                if (flag) {
                    //  userInter.uploadImg(name,userId);
                    imgName.append(name);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String headUrl=MyConstants.IMAGE_URL+imgName;
        return WebResponse.success(headUrl);
    }

    @ApiOperation(value = "图片批量上传", tags = "公共")
    @PostMapping(value = "/uploads")
    public boolean uploadHeadImgList(MultipartFile[] file) {
        boolean flag = false;
        String suffix[] = new String[]{".jpg", ".png", ".bmp"};
        if (file.length == 0) return false;
        for (MultipartFile mfile : file) {

            String fileName = mfile.getOriginalFilename();
            if (FilenameUtils.isExtension(fileName, suffix)) {
                return false;//文件必须是jpg png bmp 结尾的
            }
            if (mfile.getSize() / 1024 > 2000) {
                return false;//文件大小不能超过20M
            }
            String name = MyConstants.idWorkerUtil.nextId() + ".png";
            System.out.println(name);
            if (MyConstants.ifDebug) {
                name = "test_" + name;
            }
            try {
                flag = QiniuUtil.uploadFile(name, mfile.getBytes());
                if (!flag) {
                    //  userInter.uploadImg(name,userId);
                    return flag;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
