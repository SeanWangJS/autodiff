package com.haswalk.autodiff.node

class Variable(
              val name: String
               ) extends Node{

  override def compute(map: Map[String, Double]): Double = map(name)

  override def derivative(variable: Variable): Node = {
    if(name == variable.name)
      Constant(1)
    else
      Constant(0)
  }
}
