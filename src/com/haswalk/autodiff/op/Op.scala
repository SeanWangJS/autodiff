package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Node, Variable}

trait Op {

  def compute(input: Array[Node], map: Map[String, Double]): Double

  def derivative(input: Array[Node], x: Variable): Node

}
