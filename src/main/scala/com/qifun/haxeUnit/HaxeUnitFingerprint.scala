package com.qifun.haxeUnit

import org.scalatools.testing.SubclassFingerprint

final class HaxeUnitFingerprint extends SubclassFingerprint {
  final override def superClassName(): String = {
    return "haxe.unit.TestCase"
  }
  
  final override def isModule(): Boolean = {
    return false;
  }
}