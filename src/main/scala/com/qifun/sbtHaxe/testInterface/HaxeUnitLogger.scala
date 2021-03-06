/*
 * sbt-haxe
 * Copyright 2014 深圳岂凡网络有限公司 (Shenzhen QiFun Network Corp., LTD)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qifun.sbtHaxe.testInterface

import org.scalatools.testing.Logger

final class HaxeUnitLogger(private val loggers: Array[Logger]) extends haxe.lang.Function(0, 1) {

  final override def __hx_invoke1_o(__fn_float1: Double, __fn_dyn1: java.lang.Object): java.lang.Object = {
    return null
  }

  final def error(message: String): Unit = {
    for (logger <- loggers) {
      logger.error(message)
    }
  }

  final def info(message: String): Unit = {
    for (logger <- loggers) {
      logger.info(message)
    }
  }

  final def debug(message: String): Unit = {
    for (logger <- loggers) {
      logger.debug(message)
    }
  }

  final def warn(message: String): Unit = {
    for (logger <- loggers) {
      logger.warn(message)
    }
  }
}
