package org.example.procedure

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.funspec.AnyFunSpec
import org.example.util.LocalSession

class AppTest extends AnyFunSpec {

  describe("The App procedure") {
    describe("Given a connection to Snowflake") {
      val conn = LocalSession.getLocalSession()

      it("Should return 2") {
        val expected: Long = 2
        val actual = App.run(conn)
        assert(expected == actual)
      }
    }
  }

}
