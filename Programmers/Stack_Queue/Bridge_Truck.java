import java.util.*;
class Bridge_Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int current_wg = 0;
        Queue<int[]> onBridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        for(int i : truck_weights)
            trucks.offer(i);

        while(!trucks.isEmpty()) {
            if(weight - current_wg >= trucks.peek()) {
                current_wg += trucks.peek();
                int[] truck = {trucks.poll(), time};
                onBridge.offer(truck);
            }
            time++;
            if(time - onBridge.peek()[1] == bridge_length) {
                current_wg -= onBridge.peek()[0];
                onBridge.poll();
            }
        }
        while(!onBridge.isEmpty()) {
            if(time - onBridge.peek()[1] == bridge_length) {
                onBridge.poll();
            }
            time++;
        }
        return time;
    }
}