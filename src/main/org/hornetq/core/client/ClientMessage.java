/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005-2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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

package org.hornetq.core.client;

import java.io.OutputStream;

import org.hornetq.core.exception.MessagingException;
import org.hornetq.core.message.Message;

/**
 * 
 * A ClientMessage
 * 
 * @author <a href="mailto:tim.fox@jboss.com">Tim Fox</a>
 * @author <a href="mailto:clebert.suconic@jboss.com">Clebert Suconic</a>
 *
 */
public interface ClientMessage extends Message
{
   int getDeliveryCount();
   
   void setDeliveryCount(int deliveryCount);
   
  /** Sets the OutputStream that will receive the content of a message received in a non blocking way
    * @throws MessagingException */
   void setOutputStream(OutputStream out) throws MessagingException;
   
   /** Save the content of the message to the OutputStream. It will block until the entire content is transfered to the OutputStream. */
   void saveToOutputStream(OutputStream out) throws MessagingException;

   /**
    * Wait the outputStream completion of the message.
    * @param timeMilliseconds - 0 means wait forever
    * @return true if it reached the end
    * @throws MessagingException
    */
   boolean waitOutputStreamCompletion(long timeMilliseconds) throws MessagingException;

   void acknowledge() throws MessagingException;   
}