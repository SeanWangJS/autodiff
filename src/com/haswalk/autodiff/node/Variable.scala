package com.haswalk.autodiff.node

class Variable(
              val name: String
               ) extends Node{

  override def compute(map: Map[String, Double]): Double = map(name)

  override def d(x: Variable): Node = {
    if(name == x.name)
      Constant(1)
    else
      Constant(0)
  }
}
