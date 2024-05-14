package com.entity.view;

import com.entity.GequCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 歌曲收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gequ_collection")
public class GequCollectionView extends GequCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String gequCollectionValue;



		//级联表 gequ
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
				* 歌曲类型的值
				*/
				private String gequValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public GequCollectionView() {

	}

	public GequCollectionView(GequCollectionEntity gequCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, gequCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getGequCollectionValue() {
				return gequCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setGequCollectionValue(String gequCollectionValue) {
				this.gequCollectionValue = gequCollectionValue;
			}










				//级联表的get和set gequ
					/**
					* 获取： 歌曲编号
					*/
					public String getGequUuidNumber() {
						return gequUuidNumber;
					}
					/**
					* 设置： 歌曲编号
					*/
					public void setGequUuidNumber(String gequUuidNumber) {
						this.gequUuidNumber = gequUuidNumber;
					}
					/**
					* 获取： 歌曲名称
					*/
					public String getGequName() {
						return gequName;
					}
					/**
					* 设置： 歌曲名称
					*/
					public void setGequName(String gequName) {
						this.gequName = gequName;
					}
					/**
					* 获取： 歌曲类型
					*/
					public Integer getGequTypes() {
						return gequTypes;
					}
					/**
					* 设置： 歌曲类型
					*/
					public void setGequTypes(Integer gequTypes) {
						this.gequTypes = gequTypes;
					}


						/**
						* 获取： 歌曲类型的值
						*/
						public String getGequValue() {
							return gequValue;
						}
						/**
						* 设置： 歌曲类型的值
						*/
						public void setGequValue(String gequValue) {
							this.gequValue = gequValue;
						}
					/**
					* 获取： 歌曲封面
					*/
					public String getGequPhoto() {
						return gequPhoto;
					}
					/**
					* 设置： 歌曲封面
					*/
					public void setGequPhoto(String gequPhoto) {
						this.gequPhoto = gequPhoto;
					}
					/**
					* 获取： 歌手
					*/
					public String getGequGeshou() {
						return gequGeshou;
					}
					/**
					* 设置： 歌手
					*/
					public void setGequGeshou(String gequGeshou) {
						this.gequGeshou = gequGeshou;
					}
					/**
					* 获取： 歌曲
					*/
					public String getGequMusic() {
						return gequMusic;
					}
					/**
					* 设置： 歌曲
					*/
					public void setGequMusic(String gequMusic) {
						this.gequMusic = gequMusic;
					}
					/**
					* 获取： 时长
					*/
					public String getGequShizhang() {
						return gequShizhang;
					}
					/**
					* 设置： 时长
					*/
					public void setGequShizhang(String gequShizhang) {
						this.gequShizhang = gequShizhang;
					}
					/**
					* 获取： 赞
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}
					/**
					* 获取： 踩
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}
					/**
					* 获取： 歌手详情
					*/
					public String getGequContent() {
						return gequContent;
					}
					/**
					* 设置： 歌手详情
					*/
					public void setGequContent(String gequContent) {
						this.gequContent = gequContent;
					}













				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
