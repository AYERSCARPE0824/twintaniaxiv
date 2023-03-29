package com.ayerscarpe.xivstratz.service;

import com.ayerscarpe.xivstratz.entity.Editor;
import com.ayerscarpe.xivstratz.service.imp.EditorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EditorTest {

    @Resource
    private EditorServiceImpl editorService;

    @Test
    public void editorTest(){
        Editor editor = new Editor();
        editor.setMarkdown("## a markdown ##");
        editor.setHtml("<h1>a markdown</h1>");

        int id = editorService.add(editor);
        System.out.println(editorService.query(id));
    }
}