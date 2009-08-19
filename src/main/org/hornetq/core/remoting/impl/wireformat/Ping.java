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

package org.hornetq.core.remoting.impl.wireformat;

import org.hornetq.core.remoting.spi.MessagingBuffer;
import org.hornetq.utils.DataConstants;

/**
 * 
 * A Ping
 * 
 * @author <a href="mailto:tim.fox@jboss.com">Tim Fox</a>
 *
 */
public class Ping extends PacketImpl
{
   // Constants -----------------------------------------------------

   // Attributes ----------------------------------------------------

   private long connectionTTL;

   // Static --------------------------------------------------------

   // Constructors --------------------------------------------------

   public Ping(final long connectionTTL)
   {
      super(PING);

      this.connectionTTL = connectionTTL;
   }

   public Ping()
   {
      super(PING);
   }

   // Public --------------------------------------------------------

   public boolean isWriteAlways()
   {
      return true;
   }

   public long getConnectionTTL()
   {
      return connectionTTL;
   }

   public int getRequiredBufferSize()
   {
      return BASIC_PACKET_SIZE + DataConstants.SIZE_LONG;
   }

   public void encodeBody(final MessagingBuffer buffer)
   {
      buffer.writeLong(connectionTTL);
   }

   public void decodeBody(final MessagingBuffer buffer)
   {
      connectionTTL = buffer.readLong();
   }

   @Override
   public String toString()
   {
      StringBuffer buf = new StringBuffer(getParentString());
      buf.append(", connectionTTL=" + connectionTTL);
      buf.append("]");
      return buf.toString();
   }

   public boolean equals(Object other)
   {
      if (other instanceof Ping == false)
      {
         return false;
      }

      Ping r = (Ping)other;

      return super.equals(other) && this.connectionTTL == r.connectionTTL;
   }

   public final boolean isRequiresConfirmations()
   {
      return false;
   }

   // Package protected ---------------------------------------------

   // Protected -----------------------------------------------------

   // Private -------------------------------------------------------

   // Inner classes -------------------------------------------------
}