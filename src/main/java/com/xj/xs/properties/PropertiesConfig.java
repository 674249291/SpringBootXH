package com.xj.xs.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 2017/9/26.
 */
public class PropertiesConfig {


    @Value("${file_path}")
    private String filePath;

    @Value("${random_number}")
    private Integer number;

    @Value("${server.port}")
    private String serverPort;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

}
