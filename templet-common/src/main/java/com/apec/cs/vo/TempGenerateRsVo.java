package com.apec.cs.vo;

public class TempGenerateRsVo extends RsBaseVo {
    private String filesIp;
    private String filesPath;
    private String httpZip;

    public String getFilesIp() {
        return filesIp;
    }

    public void setFilesIp(String filesIp) {
        this.filesIp = filesIp;
    }

    public String getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }

    public String getHttpZip() {
        return httpZip;
    }

    public void setHttpZip(String httpZip) {
        this.httpZip = httpZip;
    }
}
