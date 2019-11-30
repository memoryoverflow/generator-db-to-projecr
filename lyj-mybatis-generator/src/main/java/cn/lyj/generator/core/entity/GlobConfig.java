package cn.lyj.generator.core.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-05 18:53
 */
public class GlobConfig
{
    /**
     * <br>
     * 类 作者
     */
    private String classAuthor;

    @NotBlank(message = "项目的包名不能为空")
    private String groupId;

    @NotBlank(message = "项目的包名不能为空")
    private String artifactId;

    /**
     * <br>
     * 项目包名
     */
    @NotBlank(message = "项目的包名不能为空")
    private String packageName;


    /**
     * <br>
     * 统一表明前缀
     */
    private String tablePrefix;

    /**
     * <br>
     * 项目名
     */
    @NotBlank(message = "项目名不能为空")
    private String projectName;

    /**
     * <br>
     * 需要生成的表实体
     */
    @NotEmpty(message = "请选择表表")
    private String[] includeTableName;

    /**
     * <br>
     * 是否驼峰
     */
    private boolean isHump;


    /**
     * <br>
     * 是否开启 Lombok
     */
    private boolean isLombok;


    /**
     * <br>
     * 父类
     */
    private boolean superClass;


    /**
     * <br>
     * 排除的表名字
     */
    private String[] excludeTableName;


    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId(String artifactId)
    {
        this.artifactId = artifactId;
    }

    public boolean isLombok()
    {
        return isLombok;
    }

    public void setLombok(boolean lombok)
    {
        isLombok = lombok;
    }

    public boolean isSuperClass()
    {
        return superClass;
    }

    public void setSuperClass(boolean superClass)
    {
        this.superClass = superClass;
    }

    public String getClassAuthor()
    {
        return classAuthor;
    }

    public void setClassAuthor(String classAuthor)
    {
        this.classAuthor = classAuthor;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public String getTablePrefix()
    {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix)
    {
        this.tablePrefix = tablePrefix;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String[] getIncludeTableName()
    {
        return includeTableName;
    }

    public void setIncludeTableName(String[] includeTableName)
    {
        this.includeTableName = includeTableName;
    }

    public String[] getExcludeTableName()
    {
        return excludeTableName;
    }

    public void setExcludeTableName(String[] excludeTableName)
    {
        this.excludeTableName = excludeTableName;
    }

    public boolean isHump()
    {
        return isHump;
    }

    public void setHump(boolean hump)
    {
        isHump = hump;
    }
}
