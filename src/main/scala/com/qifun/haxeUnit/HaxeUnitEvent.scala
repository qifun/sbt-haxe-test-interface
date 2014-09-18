package com.qifun.haxeUnit

import org.scalatools.testing.Event
import org.scalatools.testing.Result

final class HaxeUnitEvent(
  private val haxeUnitTestName: String,
  private val haxeUnitDescription: String,
  private val haxeUnitResult: Result,
  private val haxeUnitException: Throwable = new Exception) extends Event {

  final def testName(): String = {
    return haxeUnitTestName
  }

  final def description(): String = {
    return haxeUnitDescription
  }

  final def result(): Result = {
    return haxeUnitResult
  }

  final def error(): Throwable = {
    return haxeUnitException
  }

}