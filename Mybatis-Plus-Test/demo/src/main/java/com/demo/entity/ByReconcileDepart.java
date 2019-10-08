package com.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lyh
 * @since 2019-10-08
 */
public class ByReconcileDepart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自动递增的主键
     */
    @TableId(value = "seq", type = IdType.AUTO)
    private Integer seq;

    /**
     * 机构号
     */
    private String organizationCode;

    /**
     * 场景名称
     */
    private String scenesName;

    /**
     * 银行账号
     */
    private String bankId;

    /**
     * 商户号
     */
    private String platformMchId;

    /**
     * 部门名字
     */
    private String departName;

    /**
     * 部门id
     */
    private String departId;

    /**
     * 支付通道id
     */
    private String passageId;
    
    @Version
    private Integer version;

    /**
     * 支付通道名字
     */
    private String passageName;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
    public String getScenesName() {
        return scenesName;
    }

    public void setScenesName(String scenesName) {
        this.scenesName = scenesName;
    }
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public String getPlatformMchId() {
        return platformMchId;
    }

    public void setPlatformMchId(String platformMchId) {
        this.platformMchId = platformMchId;
    }
    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
    public String getPassageId() {
        return passageId;
    }

    public void setPassageId(String passageId) {
        this.passageId = passageId;
    }
    public String getPassageName() {
        return passageName;
    }

    public void setPassageName(String passageName) {
        this.passageName = passageName;
    }

    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
    public String toString() {
        return "ByReconcileDepart{" +
            "seq=" + seq +
            ", organizationCode=" + organizationCode +
            ", scenesName=" + scenesName +
            ", bankId=" + bankId +
            ", platformMchId=" + platformMchId +
            ", departName=" + departName +
            ", departId=" + departId +
            ", passageId=" + passageId +
            ", passageName=" + passageName +
        "}";
    }
}
