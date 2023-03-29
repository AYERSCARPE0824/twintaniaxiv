package com.ayerscarpe.xivstratz.controller;

import com.ayerscarpe.xivstratz.entity.Editor;
import com.ayerscarpe.xivstratz.service.imp.EditorServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:9528")// 允许跨域来源为前端端口号
@RestController
public class EditorController {

    final
    EditorServiceImpl editorService;

    public EditorController(EditorServiceImpl editorService) {
        this.editorService = editorService;
    }

    @ApiOperation("获取文章")
    @GetMapping("/editor/get")
    @ResponseBody
    public Editor get(@RequestParam("id")Integer id){
        //TODO-获取数据库中的数据
        return editorService.query(id);
    }

    @ApiOperation("保存文章到数据库")
    @PostMapping("/editor/add")
    @ResponseBody
    public int add(@RequestBody Editor editor){
        //TODO-保存文章到数据库
        return editorService.add(editor);
    }
}
