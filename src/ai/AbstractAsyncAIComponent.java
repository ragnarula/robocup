package ai;

import ai.model.EnvironmentModel;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public abstract class AbstractAsyncAIComponent implements Runnable, IChainable {

    private IChainable next;
    private Thread thread = new Thread(this);
    private ArrayBlockingQueue<EnvironmentModel> modelQueue = new ArrayBlockingQueue<EnvironmentModel>(100);

    public AbstractAsyncAIComponent(){
        thread.start();
    }

    public AbstractAsyncAIComponent(IChainable next){
        this.next = next;
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // take blocks until something is available in the queue
                EnvironmentModel model = modelQueue.take();
                EnvironmentModel nextModel = processModel(model);
                if(shouldContinue(nextModel)){
                    getNext().put(nextModel);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private boolean shouldContinue(EnvironmentModel m){
        return hasNext() && m != null;
    }

    public void put(EnvironmentModel model){
        try {
            modelQueue.put(model);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setNext(IChainable next) {
        this.next = next;
    }

    @Override
    public IChainable getNext() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    abstract EnvironmentModel processModel(EnvironmentModel model);
}
