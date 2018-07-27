package com.haswalk.autodiff.node

import com.haswalk.autodiff.op._

trait Node{

  def compute(map: Map[String, Double]): Double

  def d(x: Variable): Node

//  def grad(xs: Array[Variable]): Array[Node]

  def * (that: Node): Node = new OpNode(Array(this, that), new Multi)

  def + (that: Node): Node = new OpNode(Array(this, that), new Plus)

  def - (that: Node): Node = new OpNode(Array(this, that), new Minus)

  def / (that: Node): Node = new OpNode(Array(this, that), new Div)

  def pow (that: Node): Node = new OpNode(Array(this, that), new Exp)

}
