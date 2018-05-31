import java.util.ArrayList;
/**
 * A steel factory (an implementation of an enterprise)
 * represented by its name and list of employees.
 * @author AlgoDat team
 *
 */
public class SteelFactory implements Enterprise {
  
    /** Name of the factory */
    private String name;
    /** List of workers */
    private ArrayList<Worker> workers;

    /**
     * Creates a new steel factory with a given name
     * @param name Name of the factory
     */
    public SteelFactory(String name) {
    	this.name = name;
    	this.workers =  new ArrayList<Worker>(); 
    }

    @Override
    public void addWorker(String firstName, String lastName) {
    	this.workers.add(new Worker(firstName,lastName));
    }

    @Override
    public String getName() {
    	 return this.name;
     
    }

    @Override
    public int compareTo(Enterprise o) {
    	int OtherCompany = o.getWorkerCount();
    	int OurCompany = workers.size();
    	if (OtherCompany > OurCompany)
    		return -1;
    	else
    		if (OtherCompany == OurCompany)
    			return 0;
    		else return 1;
    		
    }

    @Override
    public int getWorkerCount() {
    	return this.workers.size();
    }
}

