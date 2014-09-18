package com.qifun.haxeUnit

import org.scalatools.testing.EventHandler
import org.scalatools.testing.Result

final class HaxeUnitEventHandler(
  private val eventHandler: EventHandler,
  private val haxeUnitLogger: HaxeUnitLogger) {
 
  final def testFail(testName: String, exception: Throwable): Unit = {
    eventHandler.handle(new HaxeUnitEvent(testName, "The Haxe unit test failed!", Result.Failure, exception))
  }
  
  final def testSuccess(testName: String): Unit = {
    eventHandler.handle(new HaxeUnitEvent(testName, "The Haxe unit test success!", Result.Success))
  }

}