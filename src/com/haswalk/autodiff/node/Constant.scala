package com.haswalk.autodiff.node


class Constant private (val value: Double) extends Node{

  override def compute(map: Map[String, Double]): Double = value

  override def derivative(x: Variable): Node = new Constant(0)
  
  def getValue: Double = value
}

object Constant {
  def apply(value: Double): Constant = new Constant(value)
}

