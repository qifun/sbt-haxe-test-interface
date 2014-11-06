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

package com.qifun.sbtHaxe.testInterface;

#if macro
import haxe.macro.Context;
import haxe.macro.Type;
import haxe.macro.Expr;
#end

@:final
class Filter
{
  #if haxe3 macro #else @:macro #end
  public static function excludeTestByMeta(metaName: String): Array<Field>
  {
    var buildFields = Context.getBuildFields();
    var tempBuildFields = buildFields.copy();
    for (field in tempBuildFields)
    {
      switch (field.kind)
      {
        case FFun(f):
        {
          for (m in field.meta)
          {
            if (m.name == metaName)
            {
              buildFields.remove(field);
            }
            break;
          }
        }
        default:
        {
          continue;
        }
      }
    }
    return buildFields;
  }
}
