package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * 
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     *
     * @param employee
     */
    @AutoFill(OperationType.INSERT)
    @Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) "
            +
            "values (#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);

    /**
     * 分页查询员工
     *
     * @param name 员工姓名
     * @return
     */
    List<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 动态更新员工信息
     *
     * @param employee
     */
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);

}
