package com.example.learn.search.service;

import com.example.learn.search.Settings;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class SearchService {

    // 搜索文档
    public String query(String indexName, String queryStr) {
        String result = "";

        try {
            String indexDir = Settings.DATA_DIR + File.separator + indexName;
            // 准备目录
            Directory dir = FSDirectory.open(Paths.get(indexDir));

            // 拿到indexReader实例
            IndexReader reader = DirectoryReader.open(dir);
            IndexSearcher searcher = new IndexSearcher(reader);
            Analyzer analyzer = new StandardAnalyzer();

            QueryParser parser = new QueryParser("songName", analyzer);
            Query query = parser.parse(queryStr);

            TopDocs hits = searcher.search(query, 10);

            for (ScoreDoc scoreDoc : hits.scoreDocs) {
                // 拿到文档
                Document doc = searcher.doc(scoreDoc.doc);
                List<IndexableField> fields = doc.getFields();

                for (IndexableField f : fields) {
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
