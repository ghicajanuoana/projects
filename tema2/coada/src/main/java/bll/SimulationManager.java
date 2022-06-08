package main.java.bll;

import main.java.model.Queue;

public class SimulationManager {

    private Queue[] queue;
    private boolean flag = false;

    public SimulationManager(int nrQueues) {
        queue = new Queue[nrQueues];
        for (int i = 0; i < nrQueues; i++) {
            queue[i] = new Queue(this);
        }
    }

    public int minQueue() {
        int minim = queue[0].getWaitingPeriodQueue();
        int nr = 0;

        for (int i = 1; i < queue.length; i++) {
            if (queue[i].getWaitingPeriodQueue() < minim) {
                minim = queue[i].getWaitingPeriodQueue();
                nr = i;
            }
        }
        return nr;
    }

    public Queue getQueue(int i) {
        return queue[i];
    }

    public void setFinal(boolean f) {
        this.flag = f;
    }

    public boolean getFinal() {
        return flag;
    }

    public Queue[] getQueues() {
        return queue;
    }
}