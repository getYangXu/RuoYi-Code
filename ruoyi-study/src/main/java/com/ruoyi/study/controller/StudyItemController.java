package com.ruoyi.study.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.study.domain.StudyItem;
import com.ruoyi.study.service.IStudyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 自由发挥（项目管理）
 * 
 * @author yxgu
 */
@RestController
@RequestMapping("/study/item")
public class StudyItemController extends BaseController
{
    @Autowired
    private IStudyItemService itemService;

    /**
     * 获取项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('study:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudyItem item)
    {
        startPage();
        List<StudyItem> list = itemService.selectItemList(item);
        return getDataTable(list);
    }

    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('study:item:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudyItem item)
    {
        List<StudyItem> list = itemService.selectItemList(item);
        ExcelUtil<StudyItem> util = new ExcelUtil<StudyItem>(StudyItem.class);
        util.exportExcel(response, list, "参数数据");
    }

    /**
     * 根据参数编号项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('study:item:query')")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable Long itemId)
    {
        return AjaxResult.success(itemService.selectItemById(itemId));
    }
    /**
     * 新增参数配置
     */
    @PreAuthorize("@ss.hasPermi('study:item:add')")
    @Log(title = "参数管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody StudyItem item)
    {
        item.setCreateBy(getUsername());
        return toAjax(itemService.insertItem(item));
    }

    /**
     * 修改项目信息
     */
    @PreAuthorize("@ss.hasPermi('study:item:edit')")
    @Log(title = "项目信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody StudyItem item)
    {
        return toAjax(itemService.updateItem(item));
    }

    /**
     * 删除参数配置
     */
    @PreAuthorize("@ss.hasPermi('study:item:remove')")
    @Log(title = "参数管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds)
    {
        itemService.deleteItemByIds(itemIds);
        return success();
    }

}
