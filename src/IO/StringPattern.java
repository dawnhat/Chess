package IO;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringPattern 
{	
	private String s = null;
	private Pattern p = null;
	private CommandType c = null;
	private Matcher m = null;
	
	public StringPattern(String string, CommandType c)
	{
		this.s = string;
		this.p = Pattern.compile(s);
		this.c = c;
		
	}
	
	public String getString()
	{
		return this.s;
	}
	
	public Pattern getPattern()
	{
		return this.p;
	}
	
	public CommandType getCommandType()
	{
		return this.c;
	}
	
	public Matcher getMatcher(String input)
	{
		m = p.matcher(input);
		return m;
	}

}
