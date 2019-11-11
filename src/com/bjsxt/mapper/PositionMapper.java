package com.bjsxt.mapper;

import com.bjsxt.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    public int insert(Position position);

    public List<Position> findAll();

    public int deleteByPosid(@Param("posid") int posid);

    public Position findByPosid(@Param("posid") int posid);

    public int updatePosition(Position position);
}
