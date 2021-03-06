/*******************************************************************************
 * Copyright (c) 2015 David Green.
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

package org.eclipse.mylyn.wikitext.commonmark.internal.inlines;

import org.eclipse.mylyn.wikitext.commonmark.internal.Line;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder;

public class HtmlTag extends Inline {

	private final String content;

	public HtmlTag(Line line, int offset, String content) {
		super(line, offset, content.length());
		this.content = content;
	}

	@Override
	public void emit(DocumentBuilder builder) {
		builder.charactersUnescaped(content);
	}

}
