package com.lss.sharefile.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * @Author: lss
 * @Date: 2023/09/21/21:10
 * @Description:
 */
@Data
public class ShareFile {
    // 状态
    private Integer state;

    // 修改时间
    private Date lastModifyTime;

    // 修改人员
    private String user;

    // 判断文件是否被修改,修改文件后值发生变化
    private String filemd5;

    // 上传的文件
    private byte[] file;
}
