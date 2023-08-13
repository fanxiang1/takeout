package com.fan.reggie.dto;

import com.fan.reggie.entity.Setmeal;
import com.fan.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
