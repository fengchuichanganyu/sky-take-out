package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sky.entity.SetmealDish;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 批量插入套餐菜品关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

}
