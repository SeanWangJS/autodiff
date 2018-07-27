package com.haswalk.autodiff

import com.haswalk.autodiff.node.Node
import com.haswalk.autodiff.op.{Ln, Sqrt}

object Main {
  def main(args: Array[String]): Unit = {

    implicit def doubleWrapper(d: Double): Node = Ad.constant(d)
    implicit def intWrapper(i: Int): Node = Ad.constant(i)
    // x + 3

    val x = Ad.variable("x")
    val y = Ad.variable("y")

    val node = Ln(Sqrt(x)) * x + 20 * (x pow 2) - 10 - y

    val d = Ad.d(node, x, Map("x" -> 10))
    println(d)

    val grad = Ad.grad(node, Array(x, y), Map("x" -> 10, "y" -> 20))
    println(grad.mkString(","))
  }
}
