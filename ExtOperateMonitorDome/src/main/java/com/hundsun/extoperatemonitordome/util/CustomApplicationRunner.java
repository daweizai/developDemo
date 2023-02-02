package com.hundsun.extoperatemonitordome.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * 功能说明:
 * 用于生成外部数据库地址
 * @author daweizai36273
 * @date 2022/10/14 16:36
 */
@Slf4j
public class CustomApplicationRunner {
    /**
     * 功能描述:
     * 生成数据库路径
     */
    public static void generateDatabasePath() {
        String filePath = "sqllite" + File.separator;
        String filename = "web_manage.db";
        String root = System.getProperty("user.dir") + File.separator + filePath;
        File file = new File(root);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                log.error("创建数据库根路径失败");
                return;
            }
        }
        String fullPath = root + filename;
        File file1 = new File(fullPath);
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                log.error("创建数据库路径失败！");
                throw new RuntimeException(e);
            }
        }

    }
}
