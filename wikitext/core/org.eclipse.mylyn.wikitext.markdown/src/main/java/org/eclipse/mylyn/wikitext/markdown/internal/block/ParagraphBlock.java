/*******************************************************************************
 * Copyright (c) 2012, 2015 Stefan Seelmann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Stefan Seelmann - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.markdown.internal.block;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder.BlockType;
import org.eclipse.mylyn.wikitext.parser.markup.Block;

/**
 * Markdown default paragraph.
 *
 * @author Stefan Seelmann
 */
public class ParagraphBlock extends NestableBlock {

	private int blockLineCount = 0;

	@Override
	public boolean canStart(String line, int lineOffset) {
		blockLineCount = 0;
		return true;
	}

	@Override
	protected int processLineContent(String line, int offset) {

		// start of block
		if (blockLineCount == 0) {
			builder.beginBlock(BlockType.PARAGRAPH, new Attributes());
		}

		// empty line: start new block
		if (markupLanguage.isEmptyLine(line.substring(offset))) {
			setClosed(true);
			return offset;
		}

		for (Block block : markupLanguage.getParagraphBreakingBlocks()) {
			if (block.canStart(line, offset)) {
				setClosed(true);
				return offset;
			}
		}

		// next line, does not convert to line break
		if (blockLineCount > 0) {
			builder.characters("\n"); //$NON-NLS-1$
		}

		getMarkupLanguage().emitMarkupLine(getParser(), state, line, offset);

		blockLineCount++;
		return -1;
	}

	@Override
	public void setClosed(boolean closed) {
		if (closed && !isClosed()) {
			builder.endBlock();
		}
		super.setClosed(closed);
	}
}
