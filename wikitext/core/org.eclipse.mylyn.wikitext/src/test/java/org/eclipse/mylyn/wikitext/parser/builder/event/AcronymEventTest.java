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

import org.eclipse.mylyn.wikitext.parser.builder.event.AcronymEvent;
import org.junit.Test;

public class AcronymEventTest {

	@Test
	public void testToString() {
		assertEquals("acronym(one,two)", new AcronymEvent("one", "two").toString());
	}

	@Test
	public void equals() {
		assertEquality(new AcronymEvent("one", "two"), new AcronymEvent("one", "two"));
		assertInequality(new AcronymEvent("one", "two"), new AcronymEvent("three", "two"));
		assertInequality(new AcronymEvent("one", "two"), new AcronymEvent("one", "three"));
	}
}
