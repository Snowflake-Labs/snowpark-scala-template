package org.example.procedure

import com.snowflake.snowpark.functions.col
import com.snowflake.snowpark.types._
import com.snowflake.snowpark.{Row, Session}
import org.example.function.ExampleFunction
import org.example.util.LocalSession

object App {

  def run(session: Session): Long = {
    val schema = StructType(
      Seq(StructField("Hello", StringType), StructField("World", StringType))
    )

    val data = Seq(
      Row.fromSeq(Seq("Welcome to ", "Snowflake!")),
      Row.fromSeq(Seq("Learn more: ", "https://www.snowflake.com/snowpark/"))
    )

    val df = session.createDataFrame(data, schema)

    val func = session.udf.registerTemporary(ExampleFunction.combine)

    val df2 = df
      .select(func.apply(col("Hello"), col("World")).as("Hello world"))
      .sort(col("Hello world").desc)

    df2.show

    df2.count()
  }

  def main(args: Array[String]): Unit = {
    val session = LocalSession.getLocalSession()

    run(session)
  }
}
