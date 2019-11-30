package cn.lyj.generator.core.entity;

import cn.lyj.generator.common.enums.ConstVal;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-07 17:30
 */
public class JavaClass
{
    private String appJava = ConstVal.APP_JAVA;
    private String pomXml = ConstVal.APP_POM_XML;
    private String appTestJava = ConstVal.APP_TEST_JAVA;
    private String aplicationYml = ConstVal.APPLICATION_YML;
    private String error = ConstVal.ERROR_JAVA;
    private String r = ConstVal.R_JAVA;
    private String baseController = ConstVal.BASECONTROLLER_JAVA;
    private String globalExceptionHandler = ConstVal.GLOBALEXCEPTIONHANDLER_JAVA;
    private String myException = ConstVal.MYEXCEPTION_JAVA;
    private String orderBy = ConstVal.ORDERBY_JAVA;
    private String servletUtils = ConstVal.SERVLETUTILS_JAVA;
    private String mpConfig = ConstVal.MP_CONFIG_JAVA;
    private String notFoundException = ConstVal.NOT_FOUND_EXCEPTIOPN_JAVA;
    private String filterNull = ConstVal.FILTERNULL_JAVA;
    private String stringUtils = ConstVal.STRINGUTILS_JAVA;
    private String webConfig = ConstVal.WEBCONFIG_JAVA;
    private String dateTimeUtils = ConstVal.DATETIMEUTILS_JAVA;
    private String sysAspect = ConstVal.SYSASPECT_JAVA;
    private String appIml;

    public String getOrderBy()
    {
        return orderBy;
    }

    public JavaClass(String appIml)
    {
        this.appIml = appIml + ".iml";
    }

    public String getAppJava()
    {
        return appJava;
    }

    public void setAppJava(String appJava)
    {
        this.appJava = appJava;
    }

    public String getPomXml()
    {
        return pomXml;
    }

    public void setPomXml(String pomXml)
    {
        this.pomXml = pomXml;
    }

    public String getAppTestJava()
    {
        return appTestJava;
    }

    public void setAppTestJava(String appTestJava)
    {
        this.appTestJava = appTestJava;
    }

    public String getAppIml()
    {
        return appIml;
    }

    public String getAplicationYml()
    {
        return aplicationYml;
    }

    public void setAplicationYml(String aplicationYml)
    {
        this.aplicationYml = aplicationYml;
    }

    public void setAppIml(String appIml)
    {
        this.appIml = appIml;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public String getR()
    {
        return r;
    }

    public void setR(String r)
    {
        this.r = r;
    }

    public String getBaseController()
    {
        return baseController;
    }

    public void setBaseController(String baseController)
    {
        this.baseController = baseController;
    }

    public String getGlobalExceptionHandler()
    {
        return globalExceptionHandler;
    }

    public String getMyException()
    {
        return myException;
    }

    public String getServletUtils()
    {
        return servletUtils;
    }

    public String getMpConfig()
    {
        return mpConfig;
    }

    public String getNotFoundException()
    {
        return notFoundException;
    }

    public String getFilterNull()
    {
        return filterNull;
    }

    public String getStringUtils()
    {
        return stringUtils;
    }

    public String getWebConfig()
    {
        return webConfig;
    }

    public String getSysAspect()
    {
        return sysAspect;
    }

    public String getDateTimeUtils()
    {
        return dateTimeUtils;
    }
}
