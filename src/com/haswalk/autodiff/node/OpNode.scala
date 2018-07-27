package com.haswalk.autodiff.node

import com.haswalk.autodiff.op.Op

class OpNode(
            input:Array[Node],
            op: Op
            ) extends Node{

  override def compute(map: Map[String, Double]): Double = op.compute(input, map)

  override def derivative(x: Variable): Node = op.derivative(input, x)

}
