/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.hornetq.ra;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.hornetq.core.logging.Logger;

/**
 * A wrapper for a message
 *
 * @author <a href="mailto:adrian@jboss.com">Adrian Brock</a>
 * @author <a href="mailto:jesper.pedersen@jboss.org">Jesper Pedersen</a>
 * @version $Revision: $
 */
public class JBMTextMessage extends JBMMessage implements TextMessage
{
   /** The logger */
   private static final Logger log = Logger.getLogger(JBMTextMessage.class);

   /** Whether trace is enabled */
   private static boolean trace = log.isTraceEnabled();

   /**
    * Create a new wrapper
    * @param message the message
    * @param session the session
    */
   public JBMTextMessage(final TextMessage message, final JBMSession session)
   {
      super(message, session);

      if (trace)
      {
         log.trace("constructor(" + message + ", " + session + ")");
      }
   }

   /**
    * Get text
    * @return The text
    * @exception JMSException Thrown if an error occurs
    */
   public String getText() throws JMSException
   {
      if (trace)
      {
         log.trace("getText()");
      }

      return ((TextMessage)message).getText();
   }

   /**
    * Set text
    * @param string The text
    * @exception JMSException Thrown if an error occurs
    */
   public void setText(final String string) throws JMSException
   {
      if (trace)
      {
         log.trace("setText(" + string + ")");
      }

      ((TextMessage)message).setText(string);
   }
}