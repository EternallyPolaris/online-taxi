package com.polaris.cloudzuul.entity;

import java.io.Serializable;

/**
 * common_gray_rule
 * @author 
 */
public class CommonGrayRule implements Serializable {
    private Integer id;

    private Integer userId;

    private String serverName;

    private String metaVersion;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getMetaVersion() {
        return metaVersion;
    }

    public void setMetaVersion(String metaVersion) {
        this.metaVersion = metaVersion;
    }
}