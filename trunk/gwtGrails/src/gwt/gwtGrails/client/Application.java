package gwtGrails.client;

import gwtGrails.client.DataService;
import gwtGrails.client.DataServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.media.client.Audio;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
    	
    	final DataServiceAsync myService = (DataServiceAsync) GWT.create(DataService.class);
    	ServiceDefTarget endpoint = (ServiceDefTarget) myService;
    	// Note the URL where the RPC service is located!                                                                   
    	String moduleRelativeURL = GWT.getModuleBaseURL() + "rpc";
    	endpoint.setServiceEntryPoint(moduleRelativeURL);

    	
    	Button button = new Button("Call RPC");
    	button.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// Call a method on the service!                                                                                    
		    	myService.helloWorld( new AsyncCallback() {
		    	  public void onSuccess(Object result) {
		    	      // It's always safe to downcast to the known return type.                                               
		    	      String resultString = ( String ) result;
		    	      Window.alert( resultString );
		    	  }

		    	  public void onFailure(Throwable caught) {
		    		  Window.alert("Error lalmada rpc" + caught);
		    	  }

		    	}
		    	);		
			}});
    	
    	/* HTML5 componentes */   	
    	Audio audio = Audio.createIfSupported();
    	audio.setSrc("http://www.w3schools.com/html5/horse.ogg");
    	audio.setControls(true);

    	Video video = Video.createIfSupported();
    	video.setSrc("http://www.w3schools.com/html5/movie.ogg");
    	video.setControls(true);
    	
    	VerticalPanel vp = new VerticalPanel();
    	vp.add(button);
    	vp.add(video);
    	vp.add(audio);
    	

    	RootPanel.get().add(vp);
    	
    }
}
