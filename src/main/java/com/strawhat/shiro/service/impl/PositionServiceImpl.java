package com.strawhat.shiro.service.impl;

import com.strawhat.shiro.dao.PositionDao;
import com.strawhat.shiro.pojo.Position;
import com.strawhat.shiro.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 15:20
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionDao positionDao;
    @Override
    public List<Position> findAllPosition() {
        return positionDao.selectAllPosition();
    }

    @Override
    public boolean addPosition(Position position) {
        return positionDao.insertPosition(position)>0;
    }

    @Override
    public boolean removePosition(String positionNo) {
        return positionDao.deletePosition(positionNo)>0;
    }

    @Override
    public boolean modifyPosition(Position position) {
        return positionDao.updatePosition(position)>0;
    }

    @Override
    public Position findOne(String positionNo) {
        return positionDao.selectOne(positionNo);
    }
}
