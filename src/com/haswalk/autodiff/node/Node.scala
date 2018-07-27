package com.haswalk.autodiff.node

import com.haswalk.autodiff.op._

trait Node{

  def compute(map: Map[String, Double]): Double

  def derivative(variable: Variable): Node

  def * (that: Node): Node = new OpNode(Array(this, that), new MultiOp)

  def + (that: Node): Node = new OpNode(Array(this, that), new PlusOp)

  def - (that: Node): Node = new OpNode(Array(this, that), new SubOp)

  def / (that: Node): Node = new OpNode(Array(this, that), new DivOp)

//  def ^ (that: Node): Node = new OpNode(Array(this, that), new ExpOp)

}
