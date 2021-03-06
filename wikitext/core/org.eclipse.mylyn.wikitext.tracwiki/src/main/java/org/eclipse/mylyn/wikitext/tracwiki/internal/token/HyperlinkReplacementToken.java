/*******************************************************************************
 * Copyright (c) 2007, 2008 David Green and others.
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
package org.eclipse.mylyn.wikitext.tracwiki.internal.token;

import org.eclipse.mylyn.wikitext.parser.markup.PatternBasedElement;
import org.eclipse.mylyn.wikitext.parser.markup.PatternBasedElementProcessor;
import org.eclipse.mylyn.wikitext.tracwiki.TracWikiLanguage;

/**
 * recognizes explicit hyperlink syntax that uses '[' and ']' delimiters
 * 
 * @author David Green
 */
public class HyperlinkReplacementToken extends PatternBasedElement {

	@Override
	protected String getPattern(int groupOffset) {
		return "\\[\\s*(wiki:)?([^\\]\\s]+)\\s*([^\\]]+)?\\s*\\]"; //$NON-NLS-1$
	}

	@Override
	protected int getPatternGroupCount() {
		return 3;
	}

	@Override
	protected PatternBasedElementProcessor newProcessor() {
		return new HyperlinkReplacementTokenProcessor();
	}

	private static class HyperlinkReplacementTokenProcessor extends PatternBasedElementProcessor {
		@Override
		public void emit() {
			String wikiUrl = group(1);
			String href = group(2);
			String text = group(3);
			if (text == null) {
				text = href;
			} else {
				text = text.trim();
				if (text.length() == 0) {
					text = href;
				}
			}
			if (wikiUrl != null) {
				href = ((TracWikiLanguage) markupLanguage).toInternalHref(href);
			}
			builder.link(href, text);
		}
	}

}
