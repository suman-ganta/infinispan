/*
 * Copyright 2011 Red Hat, Inc. and/or its affiliates.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA
 */
package org.infinispan.configuration.cache;

import org.infinispan.remoting.ReplicationQueue;
import org.infinispan.remoting.ReplicationQueueImpl;

/**
 * If configured all communications are asynchronous, in that whenever a thread sends a message sent
 * over the wire, it does not wait for an acknowledgment before returning. Asynchronous configuration is mutually
 * exclusive with synchronous configuration.
 *
 */
public class AsyncConfiguration {

   private final boolean asyncMarshalling;
   private final ReplicationQueue replicationQueue;
   private final long replicationQueueInterval;
   private final int replicationQueueMaxElements;
   private final boolean useReplicationQueue;

   AsyncConfiguration(boolean asyncMarshalling, ReplicationQueue replicationQueue, long replicationQueueInterval,
         int replicationQueueMaxElements, boolean useReplicationQueue) {
      this.asyncMarshalling = asyncMarshalling;
      this.replicationQueue = replicationQueue;
      this.replicationQueueInterval = replicationQueueInterval;
      this.replicationQueueMaxElements = replicationQueueMaxElements;
      this.useReplicationQueue = useReplicationQueue;
   }

   /**
    * Asynchronous marshalling allows the caller to return even quicker, but it can
    * suffer from reordering of operations. You can find more information at <a
    * href="https://docs.jboss.org/author/display/ISPN/Asynchronous+Options"
    * >https://docs.jboss.org/author/display/ISPN/Asynchronous+Options</a>.
    */
   public boolean asyncMarshalling() {
      return asyncMarshalling;
   }

   /**
    * The replication queue in use, by default {@link ReplicationQueueImpl}.
    */
   public ReplicationQueue replQueue() {
      return replicationQueue;
   }

   /**
    * If useReplQueue is set to true, this attribute controls how often the asynchronous thread
    * used to flush the replication queue runs.
    */
   public long replQueueInterval() {
      return replicationQueueInterval;
   }

   /**
    * If useReplQueue is set to true, this attribute can be used to trigger flushing of the queue
    * when it reaches a specific threshold.
    */
   public int replQueueMaxElements() {
      return replicationQueueMaxElements;
   }

   /**
    * If true, this forces all async communications to be queued up and sent out periodically as a
    * batch.
    */
   public boolean useReplQueue() {
      return useReplicationQueue;
   }

}
