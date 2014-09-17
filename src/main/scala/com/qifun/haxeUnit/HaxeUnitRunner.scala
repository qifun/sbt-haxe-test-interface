package com.qifun.haxeUnit

import org.scalatools.testing.Runner2
import org.scalatools.testing.Fingerprint
import org.scalatools.testing.EventHandler
import org.scalatools.testing.Logger
import haxe.unit.TestRunner
import haxe.unit.TestCase

final class HaxeUnitRunner(
  private val testClassLoader: ClassLoader,
  private val loggers: Array[Logger]) extends Runner2 {

  final override def run(
    testClassName: String,
    fingerprint: Fingerprint,
    eventHandler: EventHandler,
    args: Array[String]): Unit = {
    try {
      val testRunner = new TestRunner
      Class.forName(testClassName, true, testClassLoader).newInstance match {
        case testInstance: TestCase =>
          testRunner.add(testInstance)
          testRunner.run()
      }
    } catch {
      case e: ClassNotFoundException =>
        println("The test class not found: " + e)
      case e: Exception =>
        println(e)
    }
  }

}