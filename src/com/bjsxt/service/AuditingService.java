package com.bjsxt.service;

import com.bjsxt.entity.Auditing;

import java.util.List;

public interface AuditingService {
    public int addAuditing(Auditing auditing);

    public List<Auditing> selectAuditing(Integer expid);

}
