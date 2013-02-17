package com.tomlowmc.discourager;

public class CommandException extends Exception
{
	public CommandException(String string, Exception e)
	{
		super(string, e);
	}
        
        public CommandException(String string)
	{
		super(string);
	}
}
