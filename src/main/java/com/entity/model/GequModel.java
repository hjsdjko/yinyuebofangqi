package com.entity.model;

import com.entity.GequEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 音乐信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GequModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 歌曲编号
     */
    private String gequUuidNumber;


    /**
     * 歌曲名称
     */
    private String gequName;


    /**
     * 歌曲类型
     */
    private Integer gequTypes;


    /**
     * 歌曲封面
     */
    private String gequPhoto;


    /**
     * 歌手
     */
    private String gequGeshou;


    /**
     * 歌曲
     */
    private String gequMusic;


    /**
     * 时长
     */
    private String gequShizhang;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 歌手详情
     */
    private String gequContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：歌曲编号
	 */
    public String getGequUuidNumber() {
        return gequUuidNumber;
    }


    /**
	 * 设置：歌曲编号
	 */
    public void setGequUuidNumber(String gequUuidNumber) {
        this.gequUuidNumber = gequUuidNumber;
    }
    /**
	 * 获取：歌曲名称
	 */
    public String getGequName() {
        return gequName;
    }


    /**
	 * 设置：歌曲名称
	 */
    public void setGequName(String gequName) {
        this.gequName = gequName;
    }
    /**
	 * 获取：歌曲类型
	 */
    public Integer getGequTypes() {
        return gequTypes;
    }


    /**
	 * 设置：歌曲类型
	 */
    public void setGequTypes(Integer gequTypes) {
        this.gequTypes = gequTypes;
    }
    /**
	 * 获取：歌曲封面
	 */
    public String getGequPhoto() {
        return gequPhoto;
    }


    /**
	 * 设置：歌曲封面
	 */
    public void setGequPhoto(String gequPhoto) {
        this.gequPhoto = gequPhoto;
    }
    /**
	 * 获取：歌手
	 */
    public String getGequGeshou() {
        return gequGeshou;
    }


    /**
	 * 设置：歌手
	 */
    public void setGequGeshou(String gequGeshou) {
        this.gequGeshou = gequGeshou;
    }
    /**
	 * 获取：歌曲
	 */
    public String getGequMusic() {
        return gequMusic;
    }


    /**
	 * 设置：歌曲
	 */
    public void setGequMusic(String gequMusic) {
        this.gequMusic = gequMusic;
    }
    /**
	 * 获取：时长
	 */
    public String getGequShizhang() {
        return gequShizhang;
    }


    /**
	 * 设置：时长
	 */
    public void setGequShizhang(String gequShizhang) {
        this.gequShizhang = gequShizhang;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：歌手详情
	 */
    public String getGequContent() {
        return gequContent;
    }


    /**
	 * 设置：歌手详情
	 */
    public void setGequContent(String gequContent) {
        this.gequContent = gequContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
