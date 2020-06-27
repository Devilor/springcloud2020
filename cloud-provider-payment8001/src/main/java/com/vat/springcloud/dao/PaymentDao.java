package com.vat.springcloud.dao;

import com.vat.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 东街浊酒づ
 * @date 2020/6/27
 * <p>
 * 支付业务类 Dao
 */
@Mapper
public interface PaymentDao {

    public int insertPayment(Payment payment);

    public Payment selectById(@Param("id") Long id);
}
