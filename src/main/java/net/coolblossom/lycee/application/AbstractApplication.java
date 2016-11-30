package net.coolblossom.lycee.application;

public abstract class AbstractApplication implements Application {


	abstract protected boolean initApplication(String[] args);
	abstract protected void executeApplication();
	abstract protected void releaseApplication();

	@Override
	public void run(String[] args) {
		try{
			if(initApplication(args)) {
				executeApplication();
			}
		}finally{
			releaseApplication();
		}
	}

}
