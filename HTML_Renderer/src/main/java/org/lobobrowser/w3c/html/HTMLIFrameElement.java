// Generated by esidl 0.2.1.

package org.lobobrowser.w3c.html;

import org.lobobrowser.html.js.Window;
import org.w3c.dom.Document;

public interface HTMLIFrameElement extends HTMLElement {
	// HTMLIFrameElement
	public String getSrc();

	public void setSrc(String src);

	public String getSrcdoc();

	public void setSrcdoc(String srcdoc);

	public String getName();

	public void setName(String name);

	public DOMSettableTokenList getSandbox();

	public void setSandbox(String sandbox);

	public boolean getSeamless();

	public void setSeamless(boolean seamless);

	public String getWidth();

	public void setWidth(String width);

	public String getHeight();

	public void setHeight(String height);

	public Document getContentDocument();

	public Window getContentWindow();

	// HTMLIFrameElement-15
	public String getAlign();

	public void setAlign(String align);

	public String getFrameBorder();

	public void setFrameBorder(String frameBorder);

	public String getLongDesc();

	public void setLongDesc(String longDesc);

	public String getMarginHeight();

	public void setMarginHeight(String marginHeight);

	public String getMarginWidth();

	public void setMarginWidth(String marginWidth);

	public String getScrolling();

	public void setScrolling(String scrolling);
}
