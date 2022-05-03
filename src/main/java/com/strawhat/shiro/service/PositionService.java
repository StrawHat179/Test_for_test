package com.strawhat.shiro.service;

import com.strawhat.shiro.pojo.Position;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 15:19
 */
public interface PositionService {
    List<Position> findAllPosition();
    boolean addPosition(Position position);
    boolean removePosition(String positionNo);
    boolean modifyPosition(Position position);
    Position findOne(String positionNo);

}
