/*
 * Copyright 2014 (C) Stefan Radermacher
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * $Id: RandomNamePlugin.java 24888 2014-08-16 01:57:34Z jdempsey $
 */
package plugin.lsttokens.gamemode;

import java.net.URI;

import pcgen.core.GameMode;
import pcgen.persistence.lst.GameModeLstToken;

/**
 * Class deals with SKILLCOST_CLASS Token
 */
public class CRStepsToken implements GameModeLstToken
{

    @Override
	public String getTokenName()
	{
		return "CRSTEPS";
	}

    @Override
	public boolean parse(GameMode gameMode, String value, URI source)
	{
		gameMode.setCRSteps(value);
		return true;
	}
}
