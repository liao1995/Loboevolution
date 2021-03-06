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
package org.lobobrowser.clientlet;

import java.awt.Component;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.lobobrowser.http.HttpRequest;
import org.lobobrowser.io.ManagedStore;
import org.lobobrowser.ua.NavigatorFrame;
import org.lobobrowser.ua.NavigatorProgressEvent;
import org.lobobrowser.ua.UserAgent;

/**
 * The context in which a clientlet processes a web or file response.
 *
 * @see ClientletAccess#getCurrentClientletContext()
 */
public interface ClientletContext {
    /**
     * Sets a data item for later retrieval.
     *
     * @param name
     *            The item name.
     * @param value
     *            The item value.
     */
    void setItem(String name, Object value);

    /**
     * Gets a data item.
     *
     * @param name
     *            The item name.
     * @return The item value.
     */
    Object getItem(String name);

    /** Gets the request.
	 *
	 * @return the request
	 */
    ClientletRequest getRequest();

    /** Gets the response.
	 *
	 * @return the response
	 */
    ClientletResponse getResponse();

    /** Gets the user agent.
	 *
	 * @return the user agent
	 */
    UserAgent getUserAgent();

    /**
     * Undocumented.
     *
     * @param contentType
     *            the content type
     * @param content
     *            the content
     * @return the org.lobobrowser.clientlet. content buffer
     */
    org.lobobrowser.clientlet.ContentBuffer createContentBuffer(
            String contentType, byte[] content);

    /**
     * Undocumented.
     *
     * @param contentType
     *            the content type
     * @param content
     *            the content
     * @param encoding
     *            the encoding
     * @return the org.lobobrowser.clientlet. content buffer
     * @throws UnsupportedEncodingException
     *             the unsupported encoding exception
     */
    org.lobobrowser.clientlet.ContentBuffer createContentBuffer(
            String contentType, String content, String encoding)
                    throws UnsupportedEncodingException;

    /** Gets the managed store.
	 *
	 * @return the managed store
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
    ManagedStore getManagedStore() throws IOException;

    /**
     * Gets a managed store instance (a small file system restricted by a quota)
     * for the host name provided.
     *
     * @param hostName
     *            A host whose cookies the caller is allowed to access. For
     *            example, if the response host name is
     *            <code>test.acme.com</code>, then the <code>hostName</code>
     *            parameter can be <code>acme.com</code> but not
     *            <code>com</code>.
     * @return the managed store
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    ManagedStore getManagedStore(String hostName) throws IOException;

    /** Gets the navigator frame.
	 *
	 * @return the navigator frame
	 */
    NavigatorFrame getNavigatorFrame();

    /** Sets the resulting content.
	 *
	 * @param content
	 *            the new resulting content
	 */
    void setResultingContent(ComponentContent content);

    /** Sets the resulting content.
	 *
	 * @param content
	 *            the new resulting content
	 */
    void setResultingContent(Component content);

    /** Gets the resulting content.
	 *
	 * @return the resulting content
	 */
    ComponentContent getResultingContent();

    /**
     * Navigates to the URI provided, which may be absolute or relative to the
     * response URL.
     *
     * @param uri
     *            The target URI.
     * @throws MalformedURLException
     *             the malformed url exception
     * @throws IOException 
     * @see NavigatorFrame#navigate(String)
     */
    void navigate(String uri) throws MalformedURLException, IOException;

    /**
     * For documents requested in order to open a new window, this method may be
     * invoked to override window properties. To take effect, this method should
     * be invoked before content is set.
     *
     * @param properties
     *            A properties object following JavaScript Window.open()
     *            conventions.
     */
    void overrideWindowProperties(java.util.Properties properties);

    /** Gets the overridding window properties.
	 *
	 * @return the overridding window properties
	 */
    java.util.Properties getOverriddingWindowProperties();

    /** Checks if is resulting content set.
	 *
	 * @return true, if is resulting content set
	 */
    boolean isResultingContentSet();

    /**
     * Requests the frame to update its progress bar if any.
     *
     * @param progressType
     *            The type of progress action.
     * @param value
     *            The current progress value.
     * @param max
     *            The maximum progress value, which may be <code>-1</code> to
     *            indicate it is unknown.
     * @see NavigatorFrame#setProgressEvent(NavigatorProgressEvent)
     */
    void setProgressEvent(org.lobobrowser.ua.ProgressType progressType,
            int value, int max);

    /**
     * Requests the frame to update its progress bar if any.
     *
     * @param progressType
     *            The type of progress action.
     * @param value
     *            The current progress value.
     * @param max
     *            The maximum progress value, which may be <code>-1</code> to
     *            indicate it is unknown.
     * @param url
     *            The URL to be shown in progress messages.
     * @see NavigatorFrame#setProgressEvent(NavigatorProgressEvent)
     */
    void setProgressEvent(org.lobobrowser.ua.ProgressType progressType,
            int value, int max, URL url);

    /** Sets the progress event.
	 *
	 * @param event
	 *            the new progress event
	 */
    void setProgressEvent(NavigatorProgressEvent event);

    /** Gets the progress event.
	 *
	 * @return the progress event
	 */
    NavigatorProgressEvent getProgressEvent();

    /**
     * Creates a {@link HttpRequest} object that can be used to load data
     * over HTTP and other network protocols.
     *
     * @return the network request
     */
    HttpRequest createNetworkRequest();

    /**
     * Opens an alert message dialog.
     *
     * @param message
     *            An alert message.
     */
    void alert(String message);

    /**
     * Creates a lose navigator frame that may be added to GUI components.
     *
     * @return the navigator frame
     * @see NavigatorFrame#getComponent()
     * @see NavigatorFrame#navigate(String)
     */
    NavigatorFrame createNavigatorFrame();
}
