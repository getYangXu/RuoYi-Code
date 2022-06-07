package com.ruoyi.study.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 项目表 study_item
 * 
 * @author yxgu
 */
public class StudyItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目主键 */
    @Excel(name = "项目主键", cellType = ColumnType.NUMERIC)
    private Long itemId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String itemName;

    /** 项目费用 */
    @Excel(name = "项目费用")
    private String itemExpense;

    /** 项目类型 */
    @Excel(name = "项目类型",readConverterExp = "1=食物,2=衣服," +
            "3=家庭设备和维修服务,4=医疗,5=交通,6=娱乐,7=通讯,8=教育,9=住房以及其他商品和服务,10=家用")
    private String itemType;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @NotBlank(message = "项目名称不能为空")
    @Size(min = 0, max = 200, message = "项目名不能超过200个字符")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemExpense() {
        return itemExpense;
    }

    public void setItemExpense(String itemExpense) {
        this.itemExpense = itemExpense;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemExpense", getItemExpense())
            .append("itemType", getItemType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
