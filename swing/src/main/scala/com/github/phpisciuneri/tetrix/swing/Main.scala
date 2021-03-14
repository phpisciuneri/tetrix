package com.github.phpisciuneri.tetrix.swing

import com.github.phpisciuneri.tetrix.AbstractUI

import java.awt.{Color, Dimension, Graphics2D}
import scala.swing.event.Key.{Down, Left, Right, Space, Up, Value}
import scala.swing.event.KeyPressed
import scala.swing.{MainFrame, Panel, SimpleSwingApplication}

object Main extends SimpleSwingApplication {

  val bluishGray = new Color(48, 99, 99)
  val bluishSilver = new Color(210, 255, 255)

  val ui = new AbstractUI

  def onKeyPress(keyCode: Value) = keyCode match {
    case Left => ui.left()
    case Right => ui.right()
    case Up => ui.up()
    case Down => ui.down()
    case Space => ui.space()
    case _ =>
  }

  def onPaint(g: Graphics2D): Unit = {
    g.setColor(bluishSilver)
    g.drawString(ui.last, 20, 20)
  }

  def top: MainFrame = new MainFrame {
    title = "tetrix"
    contents = mainPanel
  }

  def mainPanel = new Panel {
    preferredSize = new Dimension(700, 400)
    focusable = true
    listenTo(keys)
    reactions += {
      case KeyPressed(_, key, _, _) =>
        onKeyPress(key)
        repaint
    }
    override def paint(g: Graphics2D): Unit = {
      g.setColor(bluishGray)
      g.fillRect(0, 0, size.width, size.height)
      onPaint(g)
    }
  }





}