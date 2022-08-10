package de.gie.tool.commontasks.url.alias.model;

import javax.validation.constraints.NotEmpty;

public class AliasDTO {

    @NotEmpty
    private String longUrl;
    @NotEmpty
    private String aliasName;

    private int duration;

    public AliasDTO(String longUrl, String aliasName, int duration) {
        this.longUrl = longUrl;
        this.aliasName = aliasName;
        this.duration = duration;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AliasDTO{" +
                "longUrl='" + longUrl + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", duration=" + duration +
                '}';
    }
}

