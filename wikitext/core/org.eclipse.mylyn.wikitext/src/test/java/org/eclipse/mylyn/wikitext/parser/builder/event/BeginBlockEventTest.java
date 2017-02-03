/*******************************************************************************
 * Copyright (c) 2013 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.parser.builder.event;

import static org.eclipse.mylyn.internal.wikitext.test.EqualityAsserts.assertEquality;
import static org.eclipse.mylyn.internal.wikitext.test.EqualityAsserts.assertInequality;
import static org.junit.Assert.assertEquals;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder.BlockType;
import org.eclipse.mylyn.wikitext.parser.builder.event.BeginBlockEvent;
import org.junit.Test;

public class BeginBlockEventTest {

	@Test
	public void testToString() {
		assertEquals("beginBlock(CODE)", new BeginBlockEvent(BlockType.CODE, new Attributes()).toString());
	}

	@Test
	public void equals() {
		assertEquality(new BeginBlockEvent(BlockType.CODE, new Attributes()), new BeginBlockEvent(BlockType.CODE,
				new Attributes()));
		assertInequality(new BeginBlockEvent(BlockType.CODE, new Attributes()), new BeginBlockEvent(
				BlockType.BULLETED_LIST, new Attributes()));
		assertInequality(new BeginBlockEvent(BlockType.CODE, new Attributes()), new BeginBlockEvent(
				BlockType.PREFORMATTED, new Attributes()));
	}
}
