package com.ruoyi.study.service;

import com.ruoyi.study.domain.StudyItem;

import java.util.List;

/**
 * 项目信息 服务层
 * 
 * @author yxgu
 */
public interface IStudyItemService
{
    /**
     * 查询项目信息
     * 
     * @param itemId 项目信息ID
     * @return 项目信息
     */
    StudyItem selectItemById(Long itemId);

    /**
     * 查询项目信息列表
     * 
     * @param item 项目信息
     * @return 参数项目信息
     */
     List<StudyItem> selectItemList(StudyItem item);

    /**
     * 新增项目信息
     *
     * @param item 项目信息
     * @return 结果
     */
     int insertItem(StudyItem item);

    /**
     * 修改项目信息
     *
     * @param item 项目信息
     * @return 结果
     */
    int updateItem(StudyItem item);

    /**
     * 批量删除项目信息
     *
     * @param itemIds 需要删除的参数ID
     * @return 结果
     */
    void deleteItemByIds(Long[] itemIds);




}
