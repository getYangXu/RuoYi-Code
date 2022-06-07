package com.ruoyi.study.service;

import com.ruoyi.study.domain.StudyUpload;

import java.util.List;

/**
 * 文件信息 服务层
 * 
 * @author yxgu
 */
public interface IStudyUploadService
{
    /**
     * 查询文件信息
     * 
     * @param uploadId 文件信息ID
     * @return 文件信息
     */
    StudyUpload selectUploadById(Long uploadId);

    /**
     * 查询文件信息列表
     * 
     * @param upload 文件信息
     * @return 参数文件信息
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
    void deleteUploadByIds(Long[] uploadIds);




}
