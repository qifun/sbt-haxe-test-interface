package com.qifun.haxeUnit

import org.scalatools.testing.Runner2
import org.scalatools.testing.Fingerprint
import org.scalatools.testing.EventHandler
import org.scalatools.testing.Logger

final class HaxeUnitRunner(
  private val testClassLoader: ClassLoader,
  private val loggers: Array[Logger]) extends Runner2 {

  final override def run(
    testClassName: String,
    fingerprint: Fingerprint,
    eventHandler: EventHandler,
    args: Array[String]): Unit = {
    println("########################: " + testClassName)
  }

}