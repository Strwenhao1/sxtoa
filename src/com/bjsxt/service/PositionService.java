package com.bjsxt.service;

import com.bjsxt.entity.Position;

import java.util.List;

public interface PositionService {
    public int insert(Position position);

    public List<Position> findAll();

    public int deleteByPosid( int posid);

    public Position findByPosid(int posid);

    public int updatePosition(Position position);
}
