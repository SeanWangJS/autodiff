package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

class Minus extends Op{

  def compute(input: Array[Node], map: Map[String, Double]): Double = {
    input(0).compute(map) - input(1).compute(map)
  }

  def derivative(input: Array[Node], x: Variable): Node = {
    input(0).d(x) - input(1).d(x)
  }
}
