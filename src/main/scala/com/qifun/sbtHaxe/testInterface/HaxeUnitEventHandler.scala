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
