package com.swwan.research.common.pojo.vo;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;

/**
 * 下拉框值对象
 *
 * @author swwan
 */
public class SelectOptionDto implements Serializable {
    private static final long serialVersionUID = 3501580850682459680L;
    private String id;
    private String text;
    private String col;
    private String parentId;
    private String institutionCode;
    private Object object;

    public SelectOptionDto() {
    }

    public String getInstitutionCode() {
        return this.institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode == null ? null : institutionCode.trim();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCol() {
        return this.col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + (this.id == null ? 0 : this.id.hashCode());
        hashCode = 31 * hashCode + (this.parentId == null ? 0 : this.parentId.hashCode());
        hashCode = 31 * hashCode + (this.text == null ? 0 : this.text.hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            SelectOptionDto other = (SelectOptionDto) obj;
            if (!StrUtil.equals(this.id, other.id)) {
                return false;
            } else if (!StrUtil.equals(this.parentId, other.parentId)) {
                return false;
            } else {
                return StrUtil.equals(this.text, other.text);
            }
        } else {
            return false;
        }
    }
}