package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.example.demo.common.CommonResp;
import ${package.Service}.${table.serviceName};
import ${reqFilePath}.${table.entityName}DTO;
import ${respFilePath}.${table.entityName}VO;
import java.util.List;
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@Api(tags = "${table.comment!}")
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName}  ${table.serviceName?uncap_first};

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public CommonResp<Void> add(@RequestBody @Validated ${table.entityName}DTO req) {
       ${table.serviceName?uncap_first}.add(req);
       return CommonResp.success();
     }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public CommonResp<Void> update(@RequestBody @Validated ${table.entityName}DTO req) {
        ${table.serviceName?uncap_first}.update(req);
        return CommonResp.success();
     }

     @ApiOperation(value = "列表")
     @PostMapping("/list")
     public CommonResp<List<${table.entityName}VO>> list(@RequestBody @Validated ${table.entityName}DTO req) {
       List<${table.entityName}VO> list = ${table.serviceName?uncap_first}.list(req);
       return CommonResp.success(list);
    }

}
</#if>
