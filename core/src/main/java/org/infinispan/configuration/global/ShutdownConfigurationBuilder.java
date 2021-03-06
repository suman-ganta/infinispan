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
package org.infinispan.configuration.global;

public class ShutdownConfigurationBuilder extends AbstractGlobalConfigurationBuilder<ShutdownConfiguration> {
   
   private ShutdownHookBehavior shutdownHookBehavior = ShutdownHookBehavior.DEFAULT;
   
   ShutdownConfigurationBuilder(GlobalConfigurationBuilder globalConfig) {
      super(globalConfig);
   }

   public ShutdownConfigurationBuilder hookBehavior(ShutdownHookBehavior hookBehavior) {
      this.shutdownHookBehavior = hookBehavior;
      return this;
   }
   
   @Override
   void validate() {
      // No-op, no validation required
   }
   
   @Override
   ShutdownConfiguration create() {
      return new ShutdownConfiguration(shutdownHookBehavior);
   }
   
   @Override
   ShutdownConfigurationBuilder read(ShutdownConfiguration template) {
      this.shutdownHookBehavior = template.hookBehavior();
      
      return this;
   }
}