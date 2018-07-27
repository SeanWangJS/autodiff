package com.haswalk.autodiff

import com.haswalk.autodiff.node.{Constant, Node, Variable}

object Ad {

  def constant(value: Double): Constant = Constant(value)

  def variable(name: String): Variable = new Variable(name)

  def compute(node: Node, map: Map[String, Double]): Double = node.compute(map)

  def d(node: Node, x: Variable, map: Map[String, Double]): Double = node.d(x).compute(map)

  def grad(node: Node, xs: Array[Variable], map: Map[String, Double]): Array[Double] = {
    xs.map(x => node.d(x).compute(map))
  }
}
