/*******************************************************************************
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 * 
 * None of the name of the Regents of the University of California, or the names of its
 * contributors may be used to endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package calico.uuid;

import calico.COptions;
import calico.CalicoServer;
import calico.networking.netstuff.*;

import it.unimi.dsi.fastutil.longs.*;

import org.apache.log4j.*;

public class UUIDAllocator
{
	private static LongArrayList uuidlist = new LongArrayList();
	
	private static long nextid = 0L;
	

	private static Logger logger = Logger.getLogger(UUIDAllocator.class.getName());//Logger.getLogger("server");
	
	/**
	 * This initializes the allocator and stuff
	 */
	public static void setup()
	{
		allocateMore();
	}
	
	public static void restoreUUIDAllocator(long startingID)
	{
		uuidlist.clear();
		uuidlist.trim();
		
		nextid = startingID+1;

		allocateMore();
		allocateMore();
		
	}
	
	public static int getUUIDPoolSize()
	{
		return uuidlist.size();
	}
	
	/**
	 * We need to replenish the uuid pool
	 */
	public static void allocateMore()
	{
		logger.debug("Allocating more UUIDs");
		for(int i=0;i<COptions.uuid.allocation_increment;i++)
		{
			uuidlist.add(++nextid);
		}
	}

	/**
	 * We need a new UUID
	 * @return new uuid
	 */
	public synchronized static long getUUID()
	{
		if(uuidlist.size()<=COptions.uuid.min_size)
		{
			allocateMore();
		}
		return uuidlist.removeLong(0);
	}

	/**
	 * This creates a new packet for the UUID allocation for a client
	 * @return
	 */
	public synchronized static CalicoPacket getClientUUIDBlock()
	{
		int size = ByteUtils.SIZE_OF_INT + ByteUtils.SIZE_OF_INT + (ByteUtils.SIZE_OF_LONG*COptions.uuid.block_size);
		
		CalicoPacket p = new CalicoPacket(NetworkCommand.UUID_BLOCK, size);
		p.putInt(COptions.uuid.block_size);// The number of UIDs to get
		for(int i=0;i<COptions.uuid.block_size;i++)
		{
			p.putLong(getUUID());
		}
		
		return p;
	}
		

}



