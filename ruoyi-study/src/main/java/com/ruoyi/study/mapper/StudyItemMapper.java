package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.StudyItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目信息 数据层
 * 
 * @author yxgu
 */
public interface StudyItemMapper
{
    /**
     * 查询项目信息
     * 
     * @param item 项目信息
     * @return 项目信息
     */
    StudyItem selectItem(StudyItem item);

    /**
     * 查询项目信息
     * 
     * @param item 查询项目信息
     * @return 项目信息
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
     void deleteItemByIds(@Param("itemIds") Long[] itemIds);
}
