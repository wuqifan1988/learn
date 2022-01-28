package com.example.learn.search.controller;

import com.example.learn.search.service.DocService;
import com.example.learn.search.service.SearchService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @RequestMapping("/{index}/doc_create")
    public String createDocument(@PathVariable("index") String index,
                                 @RequestParam(value = "doc", required = true) String doc) {
        DocService ds = new DocService();
        ds.indexDoc(index, doc);
        return "success";
    }

    @RequestMapping("/{index}/_search")
    public String searchDocument(@PathVariable("index") String index,
                                 @RequestParam(value = "q", required = true) String queryStr) {
        SearchService service = new SearchService();
        return service.query(index,queryStr);
    }

}
