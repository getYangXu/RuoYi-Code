package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.StudyUpload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件上传 数据层
 * 
 * @author yxgu
 */
public interface StudyUploadMapper
{
    /**
     * 查询文件信息
     * 
     * @param upload 文件信息
     * @return 文件信息
     */
    StudyUpload selectUpload(StudyUpload upload);

    /**
     * 查询文件信息
     * 
     * @param upload 查询文件信息
     * @return 文件信息
     */
    List<StudyUpload> selectUploadList(StudyUpload upload);

    /**
     * 新增文件信息
     * 
     * @param upload 文件信息
     * @return 结果
     */
     int insertUpload(StudyUpload upload);

    /**
     * 修改文件信息
     * 
     * @param upload 文件信息
     * @return 结果
     */
     int updateUpload(StudyUpload upload);

    /**
     * 批量删除文件信息
     * 
     * @param uploadIds 需要删除的参数ID
     * @return 结果
     */
     void deleteUploadByIds(@Param("uploadIds") Long[] uploadIds);
}
