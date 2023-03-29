package com.ayerscarpe.xivstratz.service.imp;

import com.ayerscarpe.xivstratz.entity.Editor;
import com.ayerscarpe.xivstratz.mapper.EditorMapper;
import com.ayerscarpe.xivstratz.service.EditorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EditorServiceImpl extends ServiceImpl<EditorMapper, Editor> implements EditorService {

    final
    EditorMapper editorMapper;

    public EditorServiceImpl(EditorMapper editorMapper) {
        this.editorMapper = editorMapper;
    }
    //  查询文章
    public Editor query(int id){
        QueryWrapper<Editor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return editorMapper.selectOne(queryWrapper);
    }
    //  添加文章
    public int add(Editor editor){
        editorMapper.insert(editor);
        return editor.getId();
    }
}
