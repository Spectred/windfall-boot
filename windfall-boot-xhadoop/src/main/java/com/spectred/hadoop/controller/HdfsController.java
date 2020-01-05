package com.spectred.hadoop.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author SWD
 */
@Slf4j
@RestController
@RequestMapping("/hdfs")
public class HdfsController {

    @Resource
    private FileSystem fileSystem;

    @PostMapping("/mkdir")
    public boolean mkdir(@RequestParam("path") String path) throws IOException {
        return fileSystem.mkdirs(new Path(path));
    }

    @PostMapping("create")
    public String create(@RequestParam("path") String path, @RequestParam("content") String content) throws IOException {
        FSDataOutputStream out = fileSystem.create(new Path(path), true, 1 << 12);
        out.write(content.getBytes());
        out.flush();
        out.close();
        return content;
    }

    @GetMapping("/exists")
    public boolean exists(@RequestParam("path") String path) throws IOException {
        log.info(path);
        return fileSystem.exists(new Path(path));
    }

    @GetMapping("/open")
    public String open(@RequestParam("path") String path) throws IOException {
        FSDataInputStream open = fileSystem.open(new Path(path));
        return inputStreamToString(open, "UTF-8");
    }

    @DeleteMapping("delete")
    public boolean delete(@RequestParam("path") String path) throws Exception {
        return fileSystem.delete(new Path(path), true);
    }

    @GetMapping("/listStatus")
    public FileStatus[] listStatus(@RequestParam("path") String path) throws IOException {
        return fileSystem.listStatus(new Path(path));
    }


    /**
     * 把输入流转换为指定编码的字符
     *
     * @param inputStream 输入流
     * @param encode      指定编码类型
     */
    private static String inputStreamToString(InputStream inputStream, String encode) {
        try {
            if (encode == null || ("".equals(encode))) {
                encode = "utf-8";
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encode));
            StringBuilder builder = new StringBuilder();
            String str = "";
            while ((str = reader.readLine()) != null) {
                builder.append(str).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
