package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

class DivOp extends Op{

  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    input(0).compute(map) / input(1).compute(map)
  }

  override def derivative(input: Array[Node], variable: Variable): Node = {
    val x = input(0)
    val y = input(1)
    (x.derivative(variable) * y - x * y.derivative(variable)) / (y * y)
  }
}
