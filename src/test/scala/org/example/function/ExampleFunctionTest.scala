package org.example.function

import org.example.function.ExampleFunction.combine
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ExampleFunctionTest extends AnyFlatSpec with should.Matchers {

  "ExampleFunction" should "return the concatenated string" in {
    combine("Hello ", "World") should be("Hello World")
    combine("Snowflake ", "Snowpark") should be("Snowflake Snowpark")
  }

}
