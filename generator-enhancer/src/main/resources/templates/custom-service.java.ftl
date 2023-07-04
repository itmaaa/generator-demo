package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${reqFilePath}.${table.entityName}DTO;
import ${respFilePath}.${table.entityName}VO;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

  void update(${table.entityName}DTO req);

  void add(${table.entityName}DTO req);

  List<${table.entityName}VO> list(${table.entityName}DTO req);

}
</#if>
