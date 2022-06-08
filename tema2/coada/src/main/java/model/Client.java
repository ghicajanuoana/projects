package main.java.model;
import java.util.Random;

public class Client implements Comparable<Client> {
        private int id;
        private int arrivalTime = 0;
        private int serviceTime = 0;
        private int waitingPeriod = 0;

        public int getArrival() {
                return arrivalTime;
        }

        public int getService() {
                return serviceTime;
        }

        public void setService(int ser) {
                this.serviceTime = ser;
        }

        public int getWaitingPeriodClient() {
                return waitingPeriod;
        }

        public void setWaitingPeriodClient(int wat) {
                this.waitingPeriod = wat;
        }

        public Client(int id, int minArrival, int maxArrival, int minProcessing, int maxProcessing) {
                this.id = id;
                this.waitingPeriod = 0;
                arrival(minArrival, maxArrival);
                service(minProcessing, maxProcessing);
        }

        

        public void arrival(int min, int max) {
                Random random = new Random();
                this.arrivalTime = random.nextInt(max - min + 1) + min;
        }

        public void service(int min, int max) {
                Random random = new Random();
                this.serviceTime = random.nextInt(max - min + 1) + min;
        }
        
        @Override
        public String toString() {
                return "(" + id + "," + arrivalTime + "," + serviceTime + ")";
        }

        @Override
        public int compareTo(Client client) {
                return this.arrivalTime - client.arrivalTime;
        }
}