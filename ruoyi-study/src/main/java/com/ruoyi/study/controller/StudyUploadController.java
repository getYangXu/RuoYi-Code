package com.ruoyi.study.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.study.domain.StudyUpload;
import com.ruoyi.study.service.IStudyUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 自由发挥（文件管理）
 * 
 * @author yxgu
 */
@RestController
@RequestMapping("/study/upload")
public class StudyUploadController extends BaseController
{
    @Autowired
    private IStudyUploadService uploadService;

    /**
     * 获取文件信息列表
     */
    @PreAuthorize("@ss.hasPermi('study:upload:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudyUpload upload)
    {
        startPage();
        List<StudyUpload> list = uploadService.selectUploadList(upload);
        return getDataTable(list);
    }

    @Log(title = "文件信息", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('study:upload:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudyUpload upload)
    {
        List<StudyUpload> list = uploadService.selectUploadList(upload);
        ExcelUtil<StudyUpload> util = new ExcelUtil<StudyUpload>(StudyUpload.class);
        util.exportExcel(response, list, "文件信息");
    }

    /**
     * 根据参数编号文件信息列表
     */
    @PreAuthorize("@ss.hasPermi('study:upload:query')")
    @GetMapping(value = "/{uploadId}")
    public AjaxResult getInfo(@PathVariable Long uploadId)
    {
        return AjaxResult.success(uploadService.selectUploadById(uploadId));
    }
    /**
     * 新增参数配置
     */
    @PreAuthorize("@ss.hasPermi('study:upload:add')")
    @Log(title = "参数管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody StudyUpload upload)
    {
        upload.setCreateBy(getUsername());
        return toAjax(uploadService.insertUpload(upload));
    }

    /**
     * 修改文件信息
     */
    @PreAuthorize("@ss.hasPermi('study:upload:edit')")
    @Log(title = "文件信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody StudyUpload upload)
    {
        return toAjax(uploadService.updateUpload(upload));
    }

    /**
     * 删除参数配置
     */
    @PreAuthorize("@ss.hasPermi('study:upload:remove')")
    @Log(title = "参数管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{uploadIds}")
    public AjaxResult remove(@PathVariable Long[] uploadIds)
    {
        uploadService.deleteUploadByIds(uploadIds);
        return success();
    }

}
