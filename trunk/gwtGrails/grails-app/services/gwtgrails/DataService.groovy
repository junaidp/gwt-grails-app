package gwtgrails

class DataService {

    static transactional = true
	
	static expose = [ 'gwt:gwtGrails.client' ]
	
	String helloWorld() {
		return "Gwt Rocks!!"
	}
    
}
