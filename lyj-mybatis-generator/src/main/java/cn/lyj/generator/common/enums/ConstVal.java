package cn.lyj.generator.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 10:39
 */
public interface ConstVal
{

    //    String PROJECT_PATH = "/Users/wanbo";
    String PROJECT_PATH = "/opt/jar-project/generator";

    /**
     * <br>
     * 数据库相关常量值
     */
    String COLUMN_PK_val = "PRI";
    String COLUMN_PK_AUTO = "auto_increment";


    String VM_LOAD_PATH_KEY = "file.resource.loader.class";
    String VM_LOAD_PATH_VALUE = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";


    String TEMPLATE_ENTITY_JAVA = "templates/entity.java.vm";
    String TEMPLATE_MAPPER = "templates/mapper.java.vm";
    String TEMPLATE_XML = "templates/mapper.xml.vm";
    String TEMPLATE_SERVICE = "templates/service.java.vm";
    String TEMPLATE_SERVICE_IMPL = "templates/serviceImpl.java.vm";
    String TEMPLATE_CONTROLLER = "templates/controller.java.vm";
    String TEMPLATE_APP = "templates/app.java.vm";
    String TEMPLATE_POM_XML = "templates/pom.xml.vm";
    String TEMPLATE_IML = "templates/iml.iml.vm";
    String TEMPLATE_APPLICATION_YML = "templates/application.yml.vm";
    String TEMPLATE_ERROR = "templates/error.java.vm";
    String TEMPLATE_BASECONTROLLER = "templates/BaseController.java.vm";
    String TEMPLATE_MYEXCEPTION = "templates/MyException.java.vm";
    String TEMPLATE_GLOBAL_EXCEPTION = "templates/GlobalExceptionHandler.java.vm";
    String TEMPLATE_R = "templates/R.java.vm";
    String TEMPLATE_ORDERBY = "templates/OrderBy.java.vm";
    String TEMPLATE_SERVLETUTILS = "templates/ServletUtils.java.vm";
    String TEMPLATE_MP_CONFIG = "templates/MpConfig.java.vm";
    String TEMPLATE_NOT_FOUND = "templates/NotFoundException.java.vm";

    String TEMPLATE_FILTERNULL = "templates/FilterNull.java.vm";
    String TEMPLATE_STRINGUTILS = "templates/StringUtils.java.vm";
    String TEMPLATE_WEBCOFIG = "templates/WebConfig.java.vm";
    String TEMPLATE_ASPECT = "templates/SysAspect.java.vm";
    String TEMPLATE_DATETIME_UTILS = "templates/DateTimeUtils.java.vm";

    String JAVA_FILE_SUFFIX = ".java";
    String XML_FILE_SUFFIX = ".xml";
    String DOWNLOAD_PROJECT_SUFFIX = ".zip";

    /**
     * <br>
     * 项目文件夹
     */
    String SRC_MAIN_JAVA = "src/main/java";
    String SRC_MAIN = "src/main";
    String COMMON = "common";
    String CONFIG = "config";
    String EXCEPTION = "exception";
    String UTILS = "utils";
    String WEB = "web";
    String CORE = "core";

    String ENTITY = "entity";
    String RESOURCES = "resources";
    String MAPPER = "mapper";
    String SERVICE = "service";
    String SERVICE_IMPL = "impl";
    String CONTROLLER = "controller";
    String TEST = "test/java";
    String TEMPLATES = "templates";

    /**
     * <br>
     * 项目固定文件
     */
    String APP_JAVA = "App.java";
    String APP_POM_XML = "pom.xml";
    String APP_TEST_JAVA = "AppTest.java";
    String APPLICATION_YML = "application.yml";
    String ERROR_JAVA = "Error.java";
    String R_JAVA = "R.java";
    String BASECONTROLLER_JAVA = "BaseController.java";
    String GLOBALEXCEPTIONHANDLER_JAVA = "GlobalExceptionHandler.java";
    String MYEXCEPTION_JAVA = "MyException.java";
    String ORDERBY_JAVA = "OrderBy.java";

    String SERVLETUTILS_JAVA = "ServletUtils.java";
    String MP_CONFIG_JAVA = "MpConfig.java";
    String NOT_FOUND_EXCEPTIOPN_JAVA = "NotFoundException.java";

    String FILTERNULL_JAVA = "FilterNull.java";
    String STRINGUTILS_JAVA = "StringUtils.java";
    String WEBCONFIG_JAVA = "WebConfig.java";
    String SYSASPECT_JAVA = "SysAspect.java";
    String DATETIMEUTILS_JAVA = "DateTimeUtils.java";

}
