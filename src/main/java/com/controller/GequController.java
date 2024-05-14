
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 音乐信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gequ")
public class GequController {
    private static final Logger logger = LoggerFactory.getLogger(GequController.class);

    @Autowired
    private GequService gequService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gequService.queryPage(params);

        //字典表数据转换
        List<GequView> list =(List<GequView>)page.getList();
        for(GequView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GequEntity gequ = gequService.selectById(id);
        if(gequ !=null){
            //entity转view
            GequView view = new GequView();
            BeanUtils.copyProperties( gequ , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GequEntity gequ, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gequ:{}",this.getClass().getName(),gequ.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GequEntity> queryWrapper = new EntityWrapper<GequEntity>()
            .eq("gequ_uuid_number", gequ.getGequUuidNumber())
            .eq("gequ_name", gequ.getGequName())
            .eq("gequ_types", gequ.getGequTypes())
            .eq("gequ_geshou", gequ.getGequGeshou())
            .eq("gequ_music", gequ.getGequMusic())
            .eq("gequ_shizhang", gequ.getGequShizhang())
            .eq("zan_number", gequ.getZanNumber())
            .eq("cai_number", gequ.getCaiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GequEntity gequEntity = gequService.selectOne(queryWrapper);
        if(gequEntity==null){
            gequ.setCreateTime(new Date());
            gequService.insert(gequ);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GequEntity gequ, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gequ:{}",this.getClass().getName(),gequ.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GequEntity> queryWrapper = new EntityWrapper<GequEntity>()
            .notIn("id",gequ.getId())
            .andNew()
            .eq("gequ_uuid_number", gequ.getGequUuidNumber())
            .eq("gequ_name", gequ.getGequName())
            .eq("gequ_types", gequ.getGequTypes())
            .eq("gequ_geshou", gequ.getGequGeshou())
            .eq("gequ_music", gequ.getGequMusic())
            .eq("gequ_shizhang", gequ.getGequShizhang())
            .eq("zan_number", gequ.getZanNumber())
            .eq("cai_number", gequ.getCaiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GequEntity gequEntity = gequService.selectOne(queryWrapper);
        if("".equals(gequ.getGequPhoto()) || "null".equals(gequ.getGequPhoto())){
                gequ.setGequPhoto(null);
        }
        if(gequEntity==null){
            gequService.updateById(gequ);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GequEntity> gequList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GequEntity gequEntity = new GequEntity();
//                            gequEntity.setGequUuidNumber(data.get(0));                    //歌曲编号 要改的
//                            gequEntity.setGequName(data.get(0));                    //歌曲名称 要改的
//                            gequEntity.setGequTypes(Integer.valueOf(data.get(0)));   //歌曲类型 要改的
//                            gequEntity.setGequPhoto("");//照片
//                            gequEntity.setGequGeshou(data.get(0));                    //歌手 要改的
//                            gequEntity.setGequMusic(data.get(0));                    //歌曲 要改的
//                            gequEntity.setGequShizhang(data.get(0));                    //时长 要改的
//                            gequEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            gequEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            gequEntity.setGequContent("");//照片
//                            gequEntity.setCreateTime(date);//时间
                            gequList.add(gequEntity);


                            //把要查询是否重复的字段放入map中
                                //歌曲编号
                                if(seachFields.containsKey("gequUuidNumber")){
                                    List<String> gequUuidNumber = seachFields.get("gequUuidNumber");
                                    gequUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gequUuidNumber = new ArrayList<>();
                                    gequUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gequUuidNumber",gequUuidNumber);
                                }
                        }

                        //查询是否重复
                         //歌曲编号
                        List<GequEntity> gequEntities_gequUuidNumber = gequService.selectList(new EntityWrapper<GequEntity>().in("gequ_uuid_number", seachFields.get("gequUuidNumber")));
                        if(gequEntities_gequUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GequEntity s:gequEntities_gequUuidNumber){
                                repeatFields.add(s.getGequUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [歌曲编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gequService.insertBatch(gequList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = gequService.queryPage(params);

        //字典表数据转换
        List<GequView> list =(List<GequView>)page.getList();
        for(GequView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GequEntity gequ = gequService.selectById(id);
            if(gequ !=null){


                //entity转view
                GequView view = new GequView();
                BeanUtils.copyProperties( gequ , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GequEntity gequ, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gequ:{}",this.getClass().getName(),gequ.toString());
        Wrapper<GequEntity> queryWrapper = new EntityWrapper<GequEntity>()
            .eq("gequ_uuid_number", gequ.getGequUuidNumber())
            .eq("gequ_name", gequ.getGequName())
            .eq("gequ_types", gequ.getGequTypes())
            .eq("gequ_geshou", gequ.getGequGeshou())
            .eq("gequ_music", gequ.getGequMusic())
            .eq("gequ_shizhang", gequ.getGequShizhang())
            .eq("zan_number", gequ.getZanNumber())
            .eq("cai_number", gequ.getCaiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GequEntity gequEntity = gequService.selectOne(queryWrapper);
        if(gequEntity==null){
            gequ.setCreateTime(new Date());
        gequService.insert(gequ);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
