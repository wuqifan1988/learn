package com.example.learn.search.service;

import com.example.learn.search.Settings;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class IndexService {

    // 创建索引
    public void createIndex(String indexName) {

        try {
            String indexDir = Settings.DATA_DIR + File.separator + indexName;

            // 准备目录
            Directory dir = FSDirectory.open(Paths.get(indexDir));

            // 准备分词器
            Analyzer analyzer = new StandardAnalyzer();

            // 准备config
            IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);

            // 创建索引
            IndexWriter writer = new IndexWriter(dir, writerConfig);

            // 关闭索引
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 删除索引
    public void deleteIndex(String indexName) {
        throw new InvalidUseOfMatchersException();
    }
}
