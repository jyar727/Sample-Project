package com.example.jasongwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JsonGwtProject implements EntryPoint {
	   public void onModuleLoad() {
		   			Window.alert("blah");
			         
			        final Button sendDataButton = new Button("Fetch Data");
			        sendDataButton.addStyleName("sendButton");
			        final Button MyButton = new Button("my button");
			        RootPanel.get("sendButtonContainer").add(sendDataButton);
			        RootPanel.get("MyButton").add(MyButton	);
			         
			        sendDataButton.addClickHandler(new ClickHandler() {
			            public void onClick(ClickEvent event) {
			                fetchDataFromServer();
			            }
			        });
			         
			    }
	   
	   
	   	    private void fetchDataFromServer() {
		   	         
		   	        try {
		   	             //try this original: "/jsongwtproject/products.json
		   	            RequestBuilder rb = new RequestBuilder(
		   	                 RequestBuilder.GET, "/JsonGwtProject/users.json");
		   	             
		   	            rb.setCallback(new RequestCallback() {
		   	                
		   	                public void onResponseReceived(Request request, Response response) {
		   	                    parseJsonData(response.getText());
		   	                }
		   	                public void onError(Request request, Throwable exception) {
		   	                    Window.alert("Error occurred" + exception.getMessage());
		   	                }
				
		   	            });
		   	            rb.send();
		   	             
		   	        }
		   	        catch (Exception e) {
		   	            Window.alert("Error occurred" + e.getMessage());
		   	        }
		   	    }
	   	 private void parseJsonData(String json) {
	   			 
	   			        @SuppressWarnings("deprecation")
						JSONValue value = JSONParser.parse(json);
	   			 
	   			        JSONObject childrenObj = value.isObject();
	   			         
	   			        JSONArray childrenArray = childrenObj.get("children").isArray();
	   			         
	   			        if (childrenArray != null) {
	   			             
	   			            for (int i=0; i<=childrenArray.size()-1; i++) {
	   			                 
	   			                JSONObject childObj = childrenArray.get(i).isObject();
	   			                 
	   			                String name = childObj.get("name").isString().stringValue();
	   			                double age = childObj.get("age").isNumber().doubleValue();
	   			                 
	   			                StringBuffer childSb = new StringBuffer();
	   			                 
	   			                JSONArray pricesArray = childObj.get("child").isArray();
	   			                if (pricesArray != null) {
	   			                    for (int j=0; j<=pricesArray.size()-1; j++) {
	   			                        JSONObject priceObj = pricesArray.get(j).isObject();
	   			                        String price = priceObj.get("price").isString().toString();
	   			                        if (j!=pricesArray.size()-1) {
	   			                        	childSb.append("-");
	   			                        }
	   			                    }
	   			                }
	   			                String message = "User -- " +
	   			                    "\nName: " + name +
	   			                    "\nAge: " + age +
	   			                    "\nChildren: " +  childSb.toString();
	   			                Window.alert(message);
	   			                 
	   			            }
	   			             
	   			        }
	   			    }
	   	    
	   	    
	   	    
}
