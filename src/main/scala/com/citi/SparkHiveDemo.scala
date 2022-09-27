package com.citi

import org.apache.spark.sql.SparkSession

object SparkHiveDemo {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    //val conf = new SparkConf().setAppName(ScalaDemo.getClass.getName)
    var a=3
    var b=5
    var c = a+b
    println("a+b = "+c)
    println("Documentation branch 2nd commit")
    println("Documentation branch conflict check for new branch")
    System.setProperty("hadoop.home.dir","C:\\winutils")
    val spark:SparkSession = SparkSession.builder().master("local[1]")
      .appName("ScalaDemo")
      .enableHiveSupport()
      .getOrCreate()

    println("spark-->"+spark)
    val sampleSeq= Seq((1,"spark"),(2,"big data"))
    val df = spark.createDataFrame(sampleSeq).toDF(colNames = "Course Id","Course Name")
    df.show()
    df.write.format(source = "csv").save(path = "samplesq")
  }
}
