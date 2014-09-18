package com.qifun.haxeUnit

import org.scalatools.testing.Runner2
import org.scalatools.testing.Fingerprint
import org.scalatools.testing.EventHandler
import org.scalatools.testing.Logger
import haxe.unit.TestRunner
import haxe.unit.TestCase
import org.scalatools.testing.Event
import org.scalatools.testing.Result

final class HaxeUnitRunner(
  private val testClassLoader: ClassLoader,
  private val loggers: Array[Logger]) extends Runner2 {

  final override def run(
    testClassName: String,
    fingerprint: Fingerprint,
    eventHandler: EventHandler,
    args: Array[String]): Unit = {
    val haxeUnitLogger = new HaxeUnitLogger(loggers)
    val haxeUnitEventHandler = new HaxeUnitEventHandler(eventHandler, haxeUnitLogger)
    try {
      val testRunner = new TestRunner {
        haxe.unit.TestRunner.print = haxeUnitLogger
      }
      Class.forName(testClassName, true, testClassLoader).newInstance match {
        case testInstance: TestCase =>
          testRunner.add(testInstance)
          if (testRunner.run()) {
            haxeUnitEventHandler.testSuccess(testClassName)
          } else {
            haxeUnitLogger.error(testRunner.result.toString)
            haxeUnitEventHandler.testFail(testClassName, new Exception)
          }
      }
    } catch {
      case e: Exception =>
        haxeUnitLogger.error(e.getMessage())
        haxeUnitEventHandler.testFail(testClassName, e)
    }
  }

}