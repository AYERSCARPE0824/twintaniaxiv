package com.ayerscarpe.xivstratz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("xeditor")
public class Editor {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String markdown;
    private String html;

    @Override
    public String toString(){
        return "Editor{" +
                "id=" + id +
                ", markdown='" + markdown +'\'' +
                ", html='" + html + '\'' +
                '}';

    }
}
