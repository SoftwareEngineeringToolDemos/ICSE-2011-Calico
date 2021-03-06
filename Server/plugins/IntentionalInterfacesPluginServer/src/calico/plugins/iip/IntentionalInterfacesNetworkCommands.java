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
package calico.plugins.iip;

import calico.networking.netstuff.CalicoPacket;
import calico.networking.netstuff.NetCommandFormat;
import calico.networking.netstuff.NetworkCommand;

public class IntentionalInterfacesNetworkCommands
{
	public static final int CIC_CREATE = Command.CIC_CREATE.id;
	public static final int CIC_MOVE = Command.CIC_MOVE.id;
	public static final int CIC_SET_TITLE = Command.CIC_SET_TITLE.id;
	public static final int CIC_TAG = Command.CIC_TAG.id;
	public static final int CIC_UNTAG = Command.CIC_UNTAG.id;
	public static final int CIC_TOPOLOGY = Command.CIC_TOPOLOGY.id;
	public static final int CIC_CLUSTER_GRAPH = Command.CIC_CLUSTER_GRAPH.id;
	public static final int CIC_DELETE = Command.CIC_DELETE.id;
	public static final int CIT_CREATE = Command.CIT_CREATE.id;
	public static final int CIT_RENAME = Command.CIT_RENAME.id;
	public static final int CIT_SET_COLOR = Command.CIT_SET_COLOR.id;
	public static final int CIT_DELETE = Command.CIT_DELETE.id;
	public static final int CLINK_CREATE = Command.CLINK_CREATE.id;
	public static final int CLINK_MOVE_ANCHOR = Command.CLINK_MOVE_ANCHOR.id;
	public static final int CLINK_LABEL = Command.CLINK_LABEL.id;
	public static final int CLINK_DELETE = Command.CLINK_DELETE.id;
	public static final int CIC_UPDATE_FINISHED = Command.CIC_UPDATE_FINISHED.id;
	public static final int II_PERSPECTIVE_ACTIVATED = Command.II_PERSPECTIVE_ACTIVATED.id;
	public static final int WALL_BOUNDS = Command.WALL_BOUNDS.id;
	public static final int CIC_SET_PIN = Command.CIC_SET_PIN.id;
	public static final int EXECUTE_II_EVENT_DISPATCHER_EVENTS = Command.EXECUTE_II_EVENT_DISPATCHER_EVENTS.id;
	public static final int CIT_SET_DESCRIPTION = Command.CIT_SET_DESCRIPTION.id;

	static {
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_CREATE.id, 
				new NetCommandFormat("CIC_CREATE", "LLIIS"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_MOVE.id, 
				new NetCommandFormat("CIC_MOVE", "LII"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_SET_TITLE.id, 
				new NetCommandFormat("CIC_SET_TITLE", "LS"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_TAG.id, 
				new NetCommandFormat("CIC_TAG", "LL"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_UNTAG.id, 
				new NetCommandFormat("CIC_UNTAG", "LL"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_TOPOLOGY.id, 
				new NetCommandFormat("CIC_TOPOLOGY", ""));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_CLUSTER_GRAPH.id, 
				new NetCommandFormat("CIC_CLUSTER_GRAPH", "S"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_DELETE.id, 
				new NetCommandFormat("CIC_DELETE", ""));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIT_RENAME.id, 
				new NetCommandFormat("CIT_RENAME", "LS"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIT_SET_COLOR.id, 
				new NetCommandFormat("CIT_SET_COLOR", "LI"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIT_DELETE.id, 
				new NetCommandFormat("CIT_DELETE", "L"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIT_CREATE.id, 
				new NetCommandFormat("CIT_CREATE", "LSI"));		
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CLINK_CREATE.id, 
				new NetCommandFormat("CLINK_CREATE", "L"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CLINK_MOVE_ANCHOR.id, 
				new NetCommandFormat("CLINK_MOVE_ANCHOR", "LLIII"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CLINK_LABEL.id, 
				new NetCommandFormat("CLINK_LABEL", "LS"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CLINK_DELETE.id, 
				new NetCommandFormat("CLINK_DELETE", "L"));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIC_UPDATE_FINISHED.id, 
				new NetCommandFormat("CIC_UPDATE_FINISHED", ""));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.II_PERSPECTIVE_ACTIVATED.id, 
				new NetCommandFormat("II_PERSPECTIVE_ACTIVATED", ""));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.EXECUTE_II_EVENT_DISPATCHER_EVENTS.id, 
				new NetCommandFormat("EXECUTE_II_EVENT_DISPATCHER_EVENTS", ""));
		NetworkCommand.formats.put(IntentionalInterfacesNetworkCommands.Command.CIT_SET_DESCRIPTION.id, 
				new NetCommandFormat("CIT_SET_DESCRIPTION", ""));
	}
	
	public enum Command
	{
		/**
		 * Create a new CIntentionCell. This command is not supported by the server, since all CIC's are created here on
		 * IIP plugin init.
		 */
		CIC_CREATE,
		/**
		 * Move a CIntentionCell's (x,y) position
		 */
		CIC_MOVE,
		/**
		 * Change the title of a CIntentionCell
		 */
		CIC_SET_TITLE,
		/**
		 * Tag a CIntentionCell with a CIntentionType
		 */
		CIC_TAG,
		/**
		 * Untag a CIntentionCell with a CIntentionType
		 */
		CIC_UNTAG,
		/**
		 * Delete a CIntentionCell
		 */
		CIC_DELETE,
		/**
		 * Describe the topology of the CIC clusters
		 */
		CIC_TOPOLOGY,
		/**
		 * Describe the graph of the CIC clusters. This is not used on the client, only for backup and restore.
		 */
		CIC_CLUSTER_GRAPH,
		/**
		 * Create a new CIntentionType
		 */
		CIT_CREATE,
		/**
		 * Rename a new CIntentionType
		 */
		CIT_RENAME,
		/**
		 * Set the color of a new CIntentionType
		 */
		CIT_SET_COLOR,
		/**
		 * Delete a CIntentionType
		 */
		CIT_DELETE,
		/**
		 * Create a new CCanvasLink
		 */
		CLINK_CREATE,
		/**
		 * Move one enpoint of a CCanvasLink
		 */
		CLINK_MOVE_ANCHOR,
		/**
		 * Set the label of a CCanvasLink
		 */
		CLINK_LABEL,
		/**
		 * Delete a CCanvasLink
		 */
		CLINK_DELETE,
		/**
		 * Alerts the client that the IntentionalInterfaceState update has been sent successfully
		 */
		CIC_UPDATE_FINISHED,
		/**
		 * Alerts the server that the intention
		 */
		II_PERSPECTIVE_ACTIVATED,
		WALL_BOUNDS,
		CIC_SET_PIN,
		EXECUTE_II_EVENT_DISPATCHER_EVENTS,
		CIT_SET_DESCRIPTION;

		public final int id;

		private Command()
		{
			this.id = ordinal() + OFFSET;
		}

		public boolean verify(CalicoPacket p)
		{
			int type = p.getInt();
			boolean verified = forId(type) == this;
			if (!verified)
			{
				System.out.println("Warning: incorrect processing path for packet of type " + type);
			}
			return verified;
		}

		private static final int OFFSET = 2300;

		public static Command forId(int id)
		{
			return Command.values()[id - OFFSET];
		}

		public static boolean isInDomain(int id)
		{
			return (id >= OFFSET) && (id < (OFFSET + 100));
		}
	}
}
