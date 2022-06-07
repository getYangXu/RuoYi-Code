package com.ruoyi.study.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 文件上传 study_upload
 * 
 * @author yxgu
 */
public class StudyUpload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件主键 */
    @Excel(name = "项目主键", cellType = ColumnType.NUMERIC)
    private Long uploadId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String uploadName;

    /** 文件描述信息 */
    @Excel(name = "文件描述信息")
    private String uploadInfo;

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    @NotBlank(message = "文件名称不能为空")
    @Size(min = 0, max = 500, message = "文件名称不能超过500个字符")
    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public String getUploadInfo() {
        return uploadInfo;
    }

    public void setUploadInfo(String uploadInfo) {
        this.uploadInfo = uploadInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uploadId", getUploadId())
            .append("uploadName", getUploadName())
            .append("uplaodInfo", getUploadInfo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
