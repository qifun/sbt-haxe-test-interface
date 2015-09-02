# sbt-haxe-test-interface

<div align="right"><a href="https://travis-ci.org/qifun/sbt-haxe-test-interface"><img alt="Build Status" src="https://travis-ci.org/qifun/sbt-haxe-test-interface.png?branch=master"/></a></div>

=======================

An implementation of [sbt's test interface](https://github.com/sbt/test-interface) for haXe unit test. This allows you to run haXe unit tests from [sbt](http://www.scala-sbt.org/).

## Usage

### Step 1: Install [sbt-haxe](https://github.com/qifun/sbt-haxe)

  You shoud first Install `sbt-haxe`. Just follow the guilds in https://github.com/qifun/sbt-haxe to install `sbt-haxe`.

### Step 2: Add it to your project's `libraryDependencies`

  Add the following line to your `build.sbt`:

``` sbt
libraryDependencies += "com.qifun.sbt-haxe" %% "test-interface" % "0.1.1" % Test

haxeOptions in Test ++= Seq("--macro", "exclude('haxe.unit')")

haxeOptions in Test ++= Seq("-dce", "no")
```

### Step 3: Put your test sources to src/test-haxe/yourPackage/YourHaxeClassTest.hx

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
  Use the `--tests` flag to select the unit tests you need to test. For example, just edit the following lines and then add it to your project's `build.sbt`: 

``` sbt
testOptions += Tests.Argument(com.qifun.sbtHaxe.HaxePlugin.HaxeUnit, "--tests=<<Your Unit Test Class Name Regex>>")
```    
