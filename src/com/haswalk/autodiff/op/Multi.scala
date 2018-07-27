package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

class Multi extends Op{

  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    input(0).compute(map) * input(1).compute(map)
  }

  override def derivative(input: Array[Node], x: Variable): Node = {
    input(0) * input(1).derivative(x) + input(1) * input(0).derivative(x)
  }
}
