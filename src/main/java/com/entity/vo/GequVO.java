package com.entity.vo;

import com.entity.GequEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 音乐信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gequ")
public class GequVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 歌曲编号
     */

    @TableField(value = "gequ_uuid_number")
    private String gequUuidNumber;


    /**
     * 歌曲名称
     */

    @TableField(value = "gequ_name")
    private String gequName;


    /**
     * 歌曲类型
     */

    @TableField(value = "gequ_types")
    private Integer gequTypes;


    /**
     * 歌曲封面
     */

    @TableField(value = "gequ_photo")
    private String gequPhoto;


    /**
     * 歌手
     */

    @TableField(value = "gequ_geshou")
    private String gequGeshou;


    /**
     * 歌曲
     */

    @TableField(value = "gequ_music")
    private String gequMusic;


    /**
     * 时长
     */

    @TableField(value = "gequ_shizhang")
    private String gequShizhang;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 歌手详情
     */

    @TableField(value = "gequ_content")
    private String gequContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：歌曲编号
	 */
    public String getGequUuidNumber() {
        return gequUuidNumber;
    }


    /**
	 * 获取：歌曲编号
	 */

    public void setGequUuidNumber(String gequUuidNumber) {
        this.gequUuidNumber = gequUuidNumber;
    }
    /**
	 * 设置：歌曲名称
	 */
    public String getGequName() {
        return gequName;
    }


    /**
	 * 获取：歌曲名称
	 */

    public void setGequName(String gequName) {
        this.gequName = gequName;
    }
    /**
	 * 设置：歌曲类型
	 */
    public Integer getGequTypes() {
        return gequTypes;
    }


    /**
	 * 获取：歌曲类型
	 */

    public void setGequTypes(Integer gequTypes) {
        this.gequTypes = gequTypes;
    }
    /**
	 * 设置：歌曲封面
	 */
    public String getGequPhoto() {
        return gequPhoto;
    }


    /**
	 * 获取：歌曲封面
	 */

    public void setGequPhoto(String gequPhoto) {
        this.gequPhoto = gequPhoto;
    }
    /**
	 * 设置：歌手
	 */
    public String getGequGeshou() {
        return gequGeshou;
    }


    /**
	 * 获取：歌手
	 */

    public void setGequGeshou(String gequGeshou) {
        this.gequGeshou = gequGeshou;
    }
    /**
	 * 设置：歌曲
	 */
    public String getGequMusic() {
        return gequMusic;
    }


    /**
	 * 获取：歌曲
	 */

    public void setGequMusic(String gequMusic) {
        this.gequMusic = gequMusic;
    }
    /**
	 * 设置：时长
	 */
    public String getGequShizhang() {
        return gequShizhang;
    }


    /**
	 * 获取：时长
	 */

    public void setGequShizhang(String gequShizhang) {
        this.gequShizhang = gequShizhang;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：歌手详情
	 */
    public String getGequContent() {
        return gequContent;
    }


    /**
	 * 获取：歌手详情
	 */

    public void setGequContent(String gequContent) {
        this.gequContent = gequContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
