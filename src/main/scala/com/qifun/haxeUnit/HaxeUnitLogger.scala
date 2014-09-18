package com.qifun.haxeUnit

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