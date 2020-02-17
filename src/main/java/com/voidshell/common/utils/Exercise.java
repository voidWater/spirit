package com.voidshell.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

public class Exercise {

	public static void main(String[] args) {


	}
	private static String genHeader(String head)  
    {  
        String[] header = new String[3];  
        header[0] = StringUtils.repeat("*", 50);  
        header[1] = StringUtils.center("  " + head + "  ", 50, "^O^");  
        header[2] = header[0];  
        return StringUtils.join(header, "/n");  
    } 

}
