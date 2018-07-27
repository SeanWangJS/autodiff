package com.haswalk.autodiff.op
import com.haswalk.autodiff.node.{Node, OpNode, Variable}

class Ln extends Op {
  override def compute(input: Array[Node], map: Map[String, Double]): Double = {
    Math.log(input(0).compute(map))
  }

  override def derivative(input: Array[Node], x: Variable): Node = {
    input(0).d(x) / input(0)
  }
}

object Ln{
  def apply(node: Node): Node = new OpNode(Array(node), new Ln)
}


