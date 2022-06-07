package com.ruoyi.study.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.study.domain.StudyItem;
import com.ruoyi.study.mapper.StudyItemMapper;
import com.ruoyi.study.service.IStudyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目信息 服务层实现
 * 
 * @author yxgu
 */
@Service
public class StudyItemServiceImpl implements IStudyItemService
{
    @Autowired
    private StudyItemMapper studyItemMapper;

    /**
     * 查询项目信息
     * 
     * @param itemId 项目信息
     * @return 项目信息
     */
    @Override
    @DataSource(DataSourceType.MASTER)
    public StudyItem selectItemById(Long itemId) {
        StudyItem item = new StudyItem();
        item.setItemId(itemId);
        return studyItemMapper.selectItem(item);
    }


    /**
     * 查询项目信息列表
     *
     * @param item 项目信息
     * @return 参数项目信息
     */
    @Override
    public List<StudyItem> selectItemList(StudyItem item) {
        return studyItemMapper.selectItemList(item);
    }

    /**
     * 新增项目信息
     *
     * @param item 项目信息
     * @return 结果
     */
    @Override
    public int insertItem(StudyItem item)
    {
        int row = studyItemMapper.insertItem(item);
        return row;
    }

    /**
     * 修改项目信息
     *
     * @param item 项目信息
     * @return 结果
     */
    @Override
    public int updateItem(StudyItem item)
    {
        int row = studyItemMapper.updateItem(item);
        return row;
    }

    /**
     * 批量删除项目信息
     *
     * @param itemIds 需要删除的参数ID

     */
    @Override
    public void deleteItemByIds(Long[] itemIds)
    {
        studyItemMapper.deleteItemByIds(itemIds);
    }


}
