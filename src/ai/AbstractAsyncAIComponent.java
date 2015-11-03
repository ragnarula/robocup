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

    public AbstractAsyncAIComponent(){};

    public AbstractAsyncAIComponent(IChainable next){
        this.next = next;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // take blocks until something is available in the queue
                EnvironmentModel model = modelQueue.take();
                processModel(model);
            } catch (InterruptedException e) {
                return;
            }
        }

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

    abstract void processModel(EnvironmentModel model);
}
