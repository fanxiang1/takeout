package com.fan.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.reggie.common.CustomException;
import com.fan.reggie.entity.Category;
import com.fan.reggie.entity.Dish;
import com.fan.reggie.entity.Setmeal;
import com.fan.reggie.mapper.CategoryMapper;
import com.fan.reggie.service.CategoryService;
import com.fan.reggie.service.DishService;
import com.fan.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper= new LambdaQueryWrapper<>();
        // 添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1=dishService.count(dishLambdaQueryWrapper);

        // 查询当前分类是否关联菜品，
        if(count1>0){
            // 已经关联则抛出异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }
        // 查询当前分类是否关联套餐，若已经关联则抛出异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper= new LambdaQueryWrapper<>();
        // 添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2=setmealService.count(setmealLambdaQueryWrapper);
        if(count2>0){
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        // 正常删除
        super.removeById(id);
    }
}
