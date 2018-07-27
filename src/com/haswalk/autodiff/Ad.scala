package com.haswalk.autodiff

import com.haswalk.autodiff.node.{Constant, Node, Variable}

object Ad {

  def constant(value: Double): Constant = Constant(value)

  def variable(name: String): Variable = new Variable(name)

  def derivative(node: Node, variable: Variable): Node = node.derivative(variable)

}
