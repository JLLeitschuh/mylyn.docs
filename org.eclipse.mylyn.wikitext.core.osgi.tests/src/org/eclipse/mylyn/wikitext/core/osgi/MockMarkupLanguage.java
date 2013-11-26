/*******************************************************************************
 * Copyright (c) 2013 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.core.osgi;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import org.eclipse.mylyn.wikitext.core.parser.markup.Block;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

class MockMarkupLanguage extends MarkupLanguage {
	public MockMarkupLanguage(String name) {
		checkArgument(!Strings.isNullOrEmpty(name));
		setName(name);
	}

	public MockMarkupLanguage() {
		this(MockMarkupLanguage.class.getSimpleName());
	}

	@Override
	public List<Block> getBlocks() {
		return Lists.newArrayList();
	}

	@Override
	protected void initializeSyntax() {
		// ignore
	}

	@Override
	protected PatternBasedSyntax getPhraseModifierSyntax() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected PatternBasedSyntax getReplacementTokenSyntax() {
		throw new UnsupportedOperationException();
	}

}