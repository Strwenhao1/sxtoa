package com.bjsxt.mapper;

import com.bjsxt.entity.Auditing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditingMapper {
    public int addAuditing(Auditing auditing);

    public List<Auditing> selectAuditing(@Param("expid") Integer expid);
}
