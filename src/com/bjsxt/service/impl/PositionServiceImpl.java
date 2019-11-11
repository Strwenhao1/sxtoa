package com.bjsxt.service.impl;

import com.bjsxt.entity.Position;
import com.bjsxt.mapper.PositionMapper;
import com.bjsxt.service.PositionService;
import com.bjsxt.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    @Override
    public int insert(Position position) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int insert = mapper.insert(position);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    @Override
    public List<Position> findAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        List<Position> positions = mapper.findAll();
        sqlSession.commit();
        sqlSession.close();
        return positions;
    }

    @Override
    public int deleteByPosid(int posid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int delete = mapper.deleteByPosid(posid);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }

    @Override
    public Position findByPosid(int posid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        Position position = mapper.findByPosid(posid);
        sqlSession.commit();
        sqlSession.close();
        return position;
    }

    @Override
    public int updatePosition(Position position) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int update = mapper.updatePosition(position);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }
}
