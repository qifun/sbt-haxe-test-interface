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
