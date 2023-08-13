package com.fan.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.reggie.entity.Dish;
import com.fan.reggie.entity.DishFlavor;
import com.fan.reggie.mapper.DishFlavorMapper;
import com.fan.reggie.mapper.DishMapper;
import com.fan.reggie.service.DishFlavorService;
import com.fan.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {

}
