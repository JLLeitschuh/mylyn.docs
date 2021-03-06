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
package org.eclipse.mylyn.wikitext.textile.internal.block;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.mylyn.wikitext.parser.markup.block.GlossaryBlock;

/**
 * @author David Green
 */
public class TextileGlossaryBlock extends GlossaryBlock {

	static final Pattern startPattern = Pattern.compile("\\s*\\{glossary(?::([^\\}]+))?\\}\\s*"); //$NON-NLS-1$

	private Matcher matcher;

	@Override
	public int processLineContent(String line, int offset) {
		if (blockLineNumber == 0) {
			String options = matcher.group(1);
			if (options != null) {
				String[] optionPairs = options.split("\\s*\\|\\s*"); //$NON-NLS-1$
				for (String optionPair : optionPairs) {
					String[] keyValue = optionPair.split("\\s*=\\s*"); //$NON-NLS-1$
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();

						if (key.equals("style")) { //$NON-NLS-1$
							setStyle(value);
						}
					}
				}
			}
		}
		return super.processLineContent(line, offset);
	}

	@Override
	public boolean canStart(String line, int lineOffset) {
		if (lineOffset == 0 && !markupLanguage.isFilterGenerativeContents()) {
			matcher = startPattern.matcher(line);
			return matcher.matches();
		} else {
			matcher = null;
			return false;
		}
	}
}
