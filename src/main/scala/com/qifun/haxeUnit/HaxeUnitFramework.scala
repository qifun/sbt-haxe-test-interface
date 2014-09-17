package com.qifun.haxeUnit

import org.scalatools.testing.Framework
import org.scalatools.testing.Logger
import org.scalatools.testing.Runner
import org.scalatools.testing.Fingerprint

private object HaxeUnitFramework {
  private final val FINGERPRINTS: Array[Fingerprint] = Array((new HaxeUnitFingerprint).asInstanceOf[Fingerprint])
}

final class HaxeUnitFramework extends Framework {
  import HaxeUnitFramework.FINGERPRINTS

  final override def name(): String = {
    return "HaxeUnit"
  }

  final override def testRunner(testClassLoader: ClassLoader, loggers: Array[Logger]): Runner = {
    return new HaxeUnitRunner(testClassLoader, loggers)
  }
  
  final override def tests(): Array[Fingerprint] = {
    return FINGERPRINTS
  }

}