package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

class PlusOp extends Op{

  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    input(0).compute(map) + input(1).compute(map)
  }

  override def derivative(input: Array[Node], variable: Variable): Node = {
    input(0).derivative(variable) + input(1).derivative(variable)
  }

}
