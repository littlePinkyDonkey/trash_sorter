package com.trash_sorter.service;

import com.trash_sorter.util.PropertyReader;

public class QrService {
    private PropertyReader reader;
    public QrService() {
        this.reader = new PropertyReader("qrPROP.properties");
    }
    public String getQrUrl(long tankId, int size) {
        String url = reader.getProperty("linkRequest") +
                reader.getProperty("serverPath") +
                "/tank?id=" +
                tankId +
                reader.getProperty("preSizeRequest_1") +
                size +
                reader.getProperty("preSizeRequest_2") +
                size +
                reader.getProperty("endRequest");
        return url;
    }
}
