/*
 * Copyright (c) 2006, 2009.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2.0 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 * 
 * Created on Mar 10, 2006
 */
package pcgen.gui.converter.panel;

import java.awt.Dimension;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pcgen.cdom.base.CDOMObject;
import pcgen.gui.converter.UnstretchingGridLayout;
import pcgen.gui.converter.event.ProgressEvent;

public class MessagePanel extends ConvertSubPanel
{

	private int progress;
	private final JPanel message;

	public MessagePanel(String s, int i)
	{
		message = new JPanel();
		message.setLayout(new UnstretchingGridLayout(0, 1));
		StringTokenizer st = new StringTokenizer(s, "\n\r\f");
		while (st.hasMoreElements())
		{
			message.add(new JLabel(st.nextToken()));
		}
		progress = i;
	}

	@Override
	public boolean performAnalysis(CDOMObject pc)
	{
		fireProgressEvent(progress);
		return true;
	}

	@Override
	public boolean autoAdvance(CDOMObject pc)
	{
		return false;
	}

	@Override
	public void setupDisplay(JPanel panel, CDOMObject pc)
	{
		panel.add(message);
		panel.setPreferredSize(new Dimension(800, 500));
	}

	@Override
	public boolean isLast()
	{
		return ProgressEvent.NOT_ALLOWED == progress;
	}

}
