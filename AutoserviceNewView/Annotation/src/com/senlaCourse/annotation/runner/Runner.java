package com.senlaCourse.annotation.runner;

import com.senlaCourse.annotation.config.AutoConfigurationProgramm;

public class Runner {

      public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

          System.out.println(AutoConfigurationProgramm.getInstance().configureObject("com.senlaCourse.autoservice.entity.Master"));
      }
}
