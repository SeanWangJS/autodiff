package com.haswalk.autodiff

import com.haswalk.autodiff.node.Node

object Main {
  def main(args: Array[String]): Unit = {

    implicit def doubleWrapper(d: Double): Node = Ad.constant(d)
    implicit def intWrapper(i: Int): Node = Ad.constant(i)
    // x + 3

    val x = Ad.variable("x")

    val o = (4 * x * x+ 10 * x + 10) * x
    val d = o.derivative(x).compute(Map("x" -> 1))
    print(d)

  }
}
