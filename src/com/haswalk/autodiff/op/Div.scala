package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

class Div extends Op{

  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    input(0).compute(map) / input(1).compute(map)
  }

  override def derivative(input: Array[Node], x: Variable): Node = {
    val fx = input(0)
    val hx = input(1)
    (fx.derivative(x) * hx - fx * hx.derivative(x)) / (hx * hx)
  }
}
