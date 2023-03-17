package org.example.function

object ExampleFunction extends Serializable {

  val combine = (a: String, b: String) => {
    a.concat(b)
  }

}
