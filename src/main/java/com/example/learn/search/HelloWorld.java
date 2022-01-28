package com.example.learn.search;

import com.alibaba.fastjson.JSONObject;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class HelloWorld {

    public static void main(String[] args) {
        String indexDir = "/Users/wuqifan/IdeaProjects/learn/src/main/resources/lucene/products";
//        createIndex(indexDir);
//        String jsonDoc = "{\n" +
//                "  \"songName\": \"could this be love\",\n" +
//                "  \"singer\": \"James\",\n" +
//                "  \"lyrics\": \"Woke up this morning,\\n\\nJust sat in my bed,\\n\\n8 a.m first thing in my head,\\n\\nIs a certain someone,\\n\\nWho's always on my mind,\\n\\nHe treats me like a lady in every way,\\n\\nHe smiles and warms me through up the day,\\n\\nShould I tell him I love you,\\n\\nWish I knew what to say!\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you would I ever heal,\\n\\nCould this be love that I feel?\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you would I ever heal,\\n\\nCould this be love that I feel?\\n\\nThe way he looks,\\n\\nSo deep in my eyes,\\n\\nOur hearts are so warm,\\n\\nI just wanna cry,\\n\\nThen he's so hardworking,\\n\\nHe wants to be someone.\\n\\nShould I tell him that I love you,\\n\\nWhat if he doesn't say it too,\\n\\nI'm getting so nervous,\\n\\nWhat should I do\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you would I ever heal,\\n\\nCould this be love that I feel?\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you would I ever heal,\\n\\nCould this be love that I feel?\\n\\nWill it be my turn,\\n\\nTwo hearts beating together as one,\\n\\nNo more loneliness,\\n\\nOnly love, laughter and fun\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you, would I ever heal,\\n\\nCould this be love that I feel?\\n\\nCould this be love that I feel,\\n\\nSo strong, so deep and so real,\\n\\nIf I lost you would I ever heal,\\n\\nCould this be love that I feel?\\n\\nCould this be love that I feel?...\"\n" +
//                "}";
//
//        indexDoc(indexDir, jsonDoc);
        query(indexDir,"could");
    }

    // 创建索引
    public static void createIndex(String indexDir) {

        try {
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

    // 索引文档
    public static void indexDoc(String indexDir, String jsonDoc) {
        try {
            // 准备目录
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

    public static Document json2Doc(String strDoc) {
        Document doc = new Document();
        JSONObject jsonDoc = JSONObject.parseObject(strDoc);

        Set<String> keys = jsonDoc.keySet();

        for (String key : keys) {
            doc.add(new TextField(key, jsonDoc.getString(key), Field.Store.YES));
        }
        return doc;
    }

    // 搜索文档
    public static String query(String indexDir, String queryStr) {
        String result = "";

        try {

            // 准备目录
            Directory dir = FSDirectory.open(Paths.get(indexDir));

            // 拿到indexReader实例
            IndexReader reader = DirectoryReader.open(dir);
            IndexSearcher searcher = new IndexSearcher(reader);
            Analyzer analyzer = new StandardAnalyzer();

            QueryParser parser = new QueryParser("songName",analyzer);
            Query query = parser.parse(queryStr);

            TopDocs hits = searcher.search(query,10);

            for(ScoreDoc scoreDoc: hits.scoreDocs) {
                // 拿到文档
                Document doc = searcher.doc(scoreDoc.doc);
                List<IndexableField> fields = doc.getFields();

                for (IndexableField f: fields) {
                    result += f.name() + ":" + f.stringValue() + ",\r\n";
                }
                System.out.println(result);
            }

            reader.close();


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return result;
    }
}
