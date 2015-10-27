/* JCTerm.java
 *
 * Copyright (C) 2015 Raphael Jolly
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public License
 * as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.jcraft.jcterm;

import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import linoleum.application.Application;

public class JCTerm implements Application {

	public JCTerm() {
		JCTermSwing.setCR(new ConfigurationRepositoryFS());

		String s = System.getProperty("jcterm.config.use_ssh_agent");
		if (s != null && s.equals("true")) {
			JSchSession.useSSHAgent(true);
		}
	}

	public String getName() {
		return JCTerm.class.getSimpleName();
	}

	public ImageIcon getIcon() {
		return null;
	}

	public String getMimeType() {
		return null;
	}

	public JInternalFrame open(final URI uri) {
		final JCTermFrame frame = new JCTermFrame(getName());
		frame.setCloseOnExit(false);
		return frame;
	}
}
