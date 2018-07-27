package com.haswalk.autodiff.op

import com.haswalk.autodiff.node.{Constant, Node}

object Sqrt{
  def apply(node: Node): Node = node pow Constant(0.5)
}
