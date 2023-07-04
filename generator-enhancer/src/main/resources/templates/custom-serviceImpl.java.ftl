package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.hutool.core.bean.BeanUtil;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ${reqFilePath}.${table.entityName}DTO;
import ${respFilePath}.${table.entityName}VO;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
   @Resource
   private ${table.mapperName} ${table.mapperName?uncap_first};


    @Override
    public void add(${table.entityName}DTO  req) {
         ${table.entityName} ${table.entityName?uncap_first} = BeanUtil.copyProperties(req, ${table.entityName}.class);
         ${table.mapperName?uncap_first}.insert(${table.entityName?uncap_first});
    }

    @Override
    public void update(${table.entityName}DTO req) {
        LambdaQueryWrapper<${table.entityName}> wrapper = Wrappers.<${table.entityName}>lambdaQuery();
       // .eq(${table.entityName}::getBabyId, req.getBabyId());
        ${table.entityName} ${table.entityName?uncap_first} = BeanUtil.copyProperties(req, ${table.entityName}.class);
        ${table.mapperName?uncap_first}.update( ${table.entityName?uncap_first} ,wrapper);

    }

    @Override
    public List<${table.entityName}VO> list(${table.entityName}DTO req) {
        LambdaQueryWrapper<${table.entityName}> wrapper = Wrappers.<${table.entityName}>lambdaQuery();
        // .eq(${table.entityName}::getBabyId, req.getBabyId());
        List<${table.entityName}> ${table.entityName?uncap_first}List = ${table.mapperName?uncap_first}.selectList(wrapper);
        List<${table.entityName}VO> list = BeanUtil.copyToList(${table.entityName?uncap_first}List, ${table.entityName}VO.class);
        return list;
    }

}
</#if>
