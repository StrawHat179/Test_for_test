package com.strawhat.shiro.dao;

import com.strawhat.shiro.pojo.Position;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 15:02
 */
public interface PositionDao {
    List<Position> selectAllPosition();
    int insertPosition(Position position);
    int deletePosition(String positionNo);
    int updatePosition(Position position);
    Position selectOne(String positionNo);

}
