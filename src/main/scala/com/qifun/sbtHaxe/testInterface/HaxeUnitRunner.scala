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

import org.scalatools.testing.Runner2
import org.scalatools.testing.Fingerprint
import org.scalatools.testing.EventHandler
import org.scalatools.testing.Logger
import haxe.unit.TestRunner
import haxe.unit.TestCase
import org.scalatools.testing.Event
import org.scalatools.testing.Result
import scala.util.matching.Regex

final class HaxeUnitRunner(
  private val testClassLoader: ClassLoader,
  private val loggers: Array[Logger]) extends Runner2 {

  final override def run(
    testClassName: String,
    fingerprint: Fingerprint,
    eventHandler: EventHandler,
    args: Array[String]): Unit = {
    if (testClassName.equals("haxe.unit.TestCase")) {
      return
    }
    val haxeUnitLogger = new HaxeUnitLogger(loggers)
    val haxeUnitEventHandler = new HaxeUnitEventHandler(eventHandler, haxeUnitLogger)
    for (arg <- args) {
      if (arg.startsWith("--tests=")) {
        val testFilters = arg.substring(8).split("\\,")
        if (testFilters.length > 0) {
          for (testPatern <- testFilters) {
            val testRegex = new Regex(testPatern)
            if (!testRegex.findAllIn(testClassName).hasNext) {
              haxeUnitEventHandler.testSkip(testClassName)
              return
            }
          }
        }
      } else if(arg.startsWith("--include-categories=")) {
        val includeCategories = arg.substring(21).split("\\,")
        println(includeCategories)
        Filter.isInIncludeCategory(includeCategories.asInstanceOf[haxe.root.Array[String]])
      }
    }
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
