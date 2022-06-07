package com.ruoyi.study.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.study.domain.StudyUpload;
import com.ruoyi.study.mapper.StudyUploadMapper;
import com.ruoyi.study.service.IStudyUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件信息 服务层实现
 * 
 * @author yxgu
 */
@Service
public class StudyUploadServiceImpl implements IStudyUploadService
{
    @Autowired
    private StudyUploadMapper studyUploadMapper;

    /**
     * 查询文件信息
     * 
     * @param uploadId 文件信息
     * @return 文件信息
     */
    @Override
    @DataSource(DataSourceType.MASTER)
    public StudyUpload selectUploadById(Long uploadId) {
        StudyUpload upload = new StudyUpload();
        upload.setUploadId(uploadId);
        return studyUploadMapper.selectUpload(upload);
    }


    /**
     * 查询文件信息列表
     *
     * @param upload 文件信息
     * @return 参数文件信息
     */
    @Override
    public List<StudyUpload> selectUploadList(StudyUpload upload) {
        return studyUploadMapper.selectUploadList(upload);
    }

    /**
     * 新增文件信息
     *
     * @param upload 文件信息
     * @return 结果
     */
    @Override
    public int insertUpload(StudyUpload upload)
    {
        int row = studyUploadMapper.insertUpload(upload);
        return row;
    }

    /**
     * 修改文件信息
     *
     * @param upload 文件信息
     * @return 结果
     */
    @Override
    public int updateUpload(StudyUpload upload)
    {
        int row = studyUploadMapper.updateUpload(upload);
        return row;
    }

    /**
     * 批量删除文件信息
     *
     * @param uploadIds 需要删除的参数ID

     */
    @Override
    public void deleteUploadByIds(Long[] uploadIds)
    {
        studyUploadMapper.deleteUploadByIds(uploadIds);
    }


}
