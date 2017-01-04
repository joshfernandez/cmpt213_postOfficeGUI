// DetailEvent.java

import java.util.EventObject;

public class DetailEvent extends EventObject
{	
	private String text;

	public DetailEvent(Object source, String t)
	{
		super(source);
		this.text = t;
	}

	public String getText()
	{
		return text;
	}
}