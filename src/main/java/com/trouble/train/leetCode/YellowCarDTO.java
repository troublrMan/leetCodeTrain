package com.trouble.train.leetCode;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author troubleMan
 * @description 小黄车 实体类
 * @Date 2022/11/11 15:49
 * @Version 1.0
 **/
@Getter
@Setter
public class YellowCarDTO implements Serializable {

  /**
   * car 车运输  cycling  骑行
   */
  private String type;

  private String start;

  private String tager;

  // 剩余里程
  private  Integer mileage;

  private  Integer sum = 1;

}
