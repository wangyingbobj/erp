package com.erp.main.entity.generator;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.hutool.setting.dialect.Props;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    public static void main(String[] args) {
        // 不覆盖service、serviceImpl、controller
        boolean overwrite = true;

        // 1、解析本地配置文件bootstrap-local.properties， 从本地配置文件中获取远程数据库连接配置。
        // 解析本地配置文件中内容，获取配置中心的URL
        Props props = new Props("bootstrap-local.properties");
        String config_uri = props.getStr("spring.cloud.config.uri");
        String application_name = props.getStr("spring.cloud.config.name");
        String config_profile = props.getStr("spring.cloud.config.profile");
        String config_label = props.getStr("spring.cloud.config.label");
//        String url = config_uri+"/" + application_name+"/" + config_profile+"/" + config_label;
        String url = config_uri+"/"  + application_name+"/" + config_profile;
        //HTTP请求配置中心的URL，获取配置的数据
        String rs = HttpUtil.get(url);
        System.out.println(rs);

        //解析 JSON 数据
        JSONObject propertySources = JSONUtil.parseObj(rs).getJSONArray("propertySources").toList(JSONObject.class).get(0);
        JSONObject source = propertySources.getJSONObject("source");

        //从JSON数据中获取数据库连接配置
        String datasource_driver = source.getStr("spring.datasource.driver-class-name");
        String datasource_url = source.getStr("spring.datasource.url");
        String datasource_username = source.getStr("spring.datasource.username");
        String datasource_password = source.getStr("spring.datasource.password");

        // 2、生成Model
        // 代码生成器

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("帅帅");
        //配置文件输出路径
        gc.setOutputDir(System.getProperty("user.dir") + "/main/src/main/java");
        gc.setOpen(false);
        gc.setActiveRecord(true);
        gc.setSwagger2(true);
        gc.setXmlName(null);
        gc.setFileOverride(true);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);
        gc.setDateType(DateType.ONLY_DATE);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(datasource_url);
        dsc.setDriverName(datasource_driver);
        dsc.setUsername(datasource_username);
        dsc.setPassword(datasource_password);
        mpg.setDataSource(dsc);

        // 包配置=>(配置包名)=>指定生成的model里面的package包名
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.erp.main");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/main/src/main/resources/mapper/"
//                        + pc.getModuleName()+ "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        templateConfig.setXml(null);
        if(!overwrite) {
            templateConfig.setController(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.erp.common.dto.BaseEntity");
        strategy.setSuperControllerClass("com.erp.common.dto.BaseController");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("bzj_erp_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StrUtil.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}