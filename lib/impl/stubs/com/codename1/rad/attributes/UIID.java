/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  Attribute used to provide a UIID for a view.  This can be added to any {@link com.codename1.rad.nodes.Node}, but there is no guarantee that it will be used.  Views
 *  are free to use this attribute or not.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#uiid(java.lang.String) 
 */
public class UIID extends com.codename1.rad.models.Attribute {

	public UIID(String value) {
	}

	public UIID(String value, com.codename1.rad.models.StringProvider provider) {
	}

	public String getValue(com.codename1.rad.models.Entity context) {
	}
}
