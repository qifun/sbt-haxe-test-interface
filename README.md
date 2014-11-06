sbt-haxe-test-interface
=======================

An implementation of [sbt's test interface](https://github.com/sbt/test-interface) for haXe unit. This allows you to run haXe unit tests from [sbt](http://www.scala-sbt.org/).

## Usage

### Step 1: Install [sbt-haxe](https://github.com/qifun/sbt-haxe)

  You shoud first Install `sbt-haxe`. Just follow the guilds to install `sbt-haxe`.

  And then add the following line to your `build.sbt`:

    libraryDependencies += "com.qifun.sbt-haxe" %% "test-interface" % "0.1.0" % Test

### Step 2: Put your test sources at src/test-haxe/yourPackage/YourHaxeClassTest.hx

```haxe
package yourPackage;
import haxe.unit.TestCase;
class YourHaxeClassTest extends TestCase
{
  public function testYourClass()
	{
		assertTrue(true);
	}
}
```

### Step 3: Run it!

```
$ sbt
[info] Loading global plugins from C:\Users\Dennis.Deng\.sbt\0.13\staging\b479b818d45e59945587\sbteclipse\project
[info] Loading global plugins from C:\Users\Dennis.Deng\.sbt\0.13\plugins
[info] Loading project definition from D:\workspace\test\project\sbt-haxe\project
[info] Loading project definition from D:\workspace\test\project
[info] Set current project to test (in build file:/D:/workspace/test/)
> test
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[success] Total time: 0 s, completed 2014-11-6 19:12:47
>
```

## Filter test
  `sbt-haxe-test-interface` has two methods to filter tests.
  
### method 1:
  
  Use the `--tests` flag to select the unit tests you need to test. For example, just add the following lines to your project's `build.sbt`: 
    testOptions += Tests.Argument(com.qifun.sbtHaxe.HaxePlugin.HaxeUnit, "--tests=<<Your Unit Test Class Name Regex>>")
    
### method 2:
  
  Use the `Filter.excludeTestByMeta` macros to exclude the test method you don't need to test. For example:

```haxe
package yourPackage;
import haxe.unit.TestCase;
@:build(com.qifun.sbtHaxe.testInterface.Filter.excludeTestByMeta(":excludeTest"))
class FilterTest extends TestCase
{
  @:excludeTest
  public function testTest()
  {
    assertTrue(false);
  }
}
```

  And then the `testTest()` method will not be run!
