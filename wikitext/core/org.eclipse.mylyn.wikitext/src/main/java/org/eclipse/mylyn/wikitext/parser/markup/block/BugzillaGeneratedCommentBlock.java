/*******************************************************************************
 * Copyright (c) 2007, 2011 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.wikitext.parser.markup.block;

import java.util.regex.Pattern;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder.BlockType;
import org.eclipse.mylyn.wikitext.parser.markup.Block;

/**
 * A block for detecting bugzilla-generated text such as: *** This bug has been marked as a duplicate of bug 1234 ***
 *
 * @author David Green
 * @since 3.0
 */
public class BugzillaGeneratedCommentBlock extends Block {
	private static Pattern pattern = Pattern
			.compile("\\s*\\*\\*\\*\\s+((This bug has been)|(Bug \\d+ has been)).*?\\*\\*\\*\\s*"); //$NON-NLS-1$

	@Override
	public boolean canStart(String line, int lineOffset) {
		if (lineOffset == 0 && line.length() > 0 && pattern.matcher(line).matches()) {
			return true;
		}
		return false;
	}

	@Override
	protected int processLineContent(String line, int offset) {
		Attributes attributes = new Attributes();
		attributes.setCssStyle("color: Blue;");// FIXME: hard-coded color? //$NON-NLS-1$
		builder.beginBlock(BlockType.PARAGRAPH, attributes);
		getMarkupLanguage().emitMarkupLine(getParser(), state, line, offset);
		setClosed(true);
		return -1;
	}

	@Override
	public void setClosed(boolean closed) {
		if (closed && !isClosed()) {
			builder.endBlock(); // para
		}
		super.setClosed(closed);
	}

}
