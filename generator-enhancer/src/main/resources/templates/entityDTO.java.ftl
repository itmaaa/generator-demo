package  ${reqFilePath};

<#list table.importPackages as pkg>
    <#if !pkg?contains("mybatisplus.annotation")>
import ${pkg};
    </#if>
</#list>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#if entityLombokModel>
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
    <#if chainModel>
import lombok.experimental.Accessors;
    </#if>
</#if>

/**
 * ${entity}DTO 请求参数对象
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Getter
@Setter
    <#if chainModel>
@Accessors(chain = true)
    </#if>
</#if>
@ApiModel(value = "${entity}DTO请求参数对象")
<#if superEntityClass??>
public class ${entity} extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity} extends Model<${entity}> {
<#elseif entitySerialVersionUID>
public class ${entity}DTO implements Serializable {
<#else>
public class ${entity}DTO {
</#if>
<#if entitySerialVersionUID>

    private static final long serialVersionUID = 1L;

</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
     <#if !(field.propertyName?contains("Time") || field.propertyName?contains("Date")
     || field.propertyName?contains("updateBy")   || field.propertyName?contains("createBy")) >
     <#if field.comment!?length gt 0>
     @ApiModelProperty(value = "${field.comment}",required = true)
     </#if>
     <#if field.propertyType="String">
     @NotBlank(message = "${field.comment} ${field.propertyName} 字段不能为空")
     <#else>
     @NotNull(message = "${field.comment} ${field.propertyName}  字段不能为空")
     </#if>
     private ${field.propertyType} ${field.propertyName};

     </#if>
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>

    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

    <#if chainModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if chainModel>
        return this;
        </#if>
    }
    </#list>
</#if>
<#if entityColumnConstant>
    <#list table.fields as field>

    public static final String ${field.name?upper_case} = "${field.name}";
    </#list>
</#if>
<#if activeRecord>

    @Override
    public Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }
</#if>
<#if !entityLombokModel>

    @Override
    public String toString() {
        return "${entity}{" +
    <#list table.fields as field>
        <#if field_index==0>
            "${field.propertyName} = " + ${field.propertyName} +
        <#else>
            ", ${field.propertyName} = " + ${field.propertyName} +
        </#if>
    </#list>
        "}";
    }
</#if>
}
