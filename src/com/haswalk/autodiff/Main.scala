package com.haswalk.autodiff

import com.haswalk.autodiff.node.Node
import com.haswalk.autodiff.op.{Ln, Sqrt}

object Main {
  def main(args: Array[String]): Unit = {

    implicit def doubleWrapper(d: Double): Node = Ad.constant(d)
    implicit def intWrapper(i: Int): Node = Ad.constant(i)
    // x + 3

    val x = Ad.variable("x")

    val node = Ln(Sqrt(x)) * x + 20 * (x pow 2) - 10
    val d = node.derivative(x).compute(Map("x" -> 2.3))

    println(d)

  }
}
