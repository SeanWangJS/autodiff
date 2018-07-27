package com.haswalk.autodiff.op
import com.haswalk.autodiff.node.{Node, Variable}

class Exp extends Op{

  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    scala.math.pow(input(0).compute(map), input(1).compute(map))
  }

  override def derivative(input: Array[Node], x: Variable): Node = {
    val fx = input(0)
    val hx = input(1)
    (fx pow hx) * (hx * fx.derivative(x) / fx + Ln(fx) * hx.derivative(x))
  }
}
