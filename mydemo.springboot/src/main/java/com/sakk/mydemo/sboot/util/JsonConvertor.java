package com.sakk.mydemo.sboot.util;

import com.google.gson.Gson;
import com.sakk.mydemo.sboot.model.BookDTO;

public class JsonConvertor {

	public static void main(String[] args){
		String jsonString = new Gson().toJson(new BookDTO());
		System.out.println(jsonString);
	}
}
