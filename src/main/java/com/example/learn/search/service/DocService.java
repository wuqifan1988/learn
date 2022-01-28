package com.example.learn.search.service;

import com.alibaba.fastjson.JSONObject;
import com.example.learn.search.Settings;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Set;

public class DocService {

    // 索引文档
    public void indexDoc(String indexName, String jsonDoc) {
        try {
            // 准备目录
            String indexDir = Settings.DATA_DIR + File.separator + indexName;
            Directory dir = FSDirectory.open(Paths.get(indexDir));

            // 准备分词器
            Analyzer analyzer = new StandardAnalyzer();

            // 准备config
            IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);

            // 创建索引
            IndexWriter writer = new IndexWriter(dir, writerConfig);

            // 创建文档
//            Document doc = new Document();
//            doc.add(new TextField(key,value, Field.Store.YES));
//            writer.addDocument(doc);
            Document doc = json2Doc(jsonDoc);
            writer.addDocument(doc);

            // 关闭索引
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Document json2Doc(String strDoc) {
        Document doc = new Document();
        JSONObject jsonDoc = JSONObject.parseObject(strDoc);

        Set<String> keys = jsonDoc.keySet();

        for (String key : keys) {
            doc.add(new TextField(key, jsonDoc.getString(key), Field.Store.YES));
        }
        return doc;
    }

    //
    public void deleteDoc(String indexName, String  docId) {
        throw new UnsupportedOperationException();
    }
}
