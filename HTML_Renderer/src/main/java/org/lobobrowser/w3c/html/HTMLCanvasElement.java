/*
    GNU GENERAL LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2016 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 2 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */

package org.lobobrowser.w3c.html;

import org.lobobrowser.w3c.file.FileCallback;


/**
 * The Interface HTMLCanvasElement.
 */
public interface HTMLCanvasElement extends HTMLElement {

	/** The fill. */
	int FILL = 0;

	/** The fill rect. */
	int FILL_RECT = 1;

	/** The fill text. */
	int FILL_TEXT = 2;

	/** The circle. */
	int CIRCLE = 3;

	/** The stroke. */
	int STROKE = 4;

	/** The stroke rect. */
	int STROKE_RECT = 5;

	/** The stroke text. */
	int STROKE_TEXT = 6;

	/** The rect. */
	int RECT = 7;

	/** The image. */
	int IMAGE = 8;

	/** The image clip. */
	int IMAGE_CLIP = 9;

	/** The clear rect. */
	int CLEAR_RECT = 10;

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	// HTMLCanvasElement
	public int getWidth();

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	public void setWidth(int width);

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight();

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	public void setHeight(int height);

	/**
	 * To data url.
	 *
	 * @return the string
	 */
	public String toDataURL();

	/**
	 * To data url.
	 *
	 * @param type the type
	 * @param args the args
	 * @return the string
	 */
	public String toDataURL(String type, Object... args);

	/**
	 * To blob.
	 *
	 * @param callback the callback
	 */
	public void toBlob(FileCallback callback);

	/**
	 * To blob.
	 *
	 * @param callback the callback
	 * @param type the type
	 * @param args the args
	 */
	public void toBlob(FileCallback callback, String type, Object... args);

	/**
	 * Gets the context.
	 *
	 * @param contextId the context id
	 * @return the context
	 */
	public Object getContext(String contextId);
}
