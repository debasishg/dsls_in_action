/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch6.trade
package api


object Util {
  val TODAY = java.util.Calendar.getInstance.getTime
}

case class Mailer(user: String) {
  def mail(trade: Trade): Unit =
    println("sending mail to user: " + user)
}

case class Logger {
  def log(trade: Trade): Unit = {
    println("logging trade: " + trade)
  }
}


