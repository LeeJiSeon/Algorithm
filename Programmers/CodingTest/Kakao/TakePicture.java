class TakePicture {
    static final char[] k_friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited;
    static int count;

    public int solution(int n, String[] data) {
        char[] output = new char[8];
        count = 0;
        visited = new boolean[8];
        perm(output, 0, data);
        return count;
    }

    static void perm(char[] output, int depth, String[] data) {
        if(depth == 8) {
            for(int j = 0 ; j < data.length ; j++) {
                if(!condition(data[j], output))
                    return;
            }
            count++;
            return;
        }
        
        for(int i = 0 ; i < 8 ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = k_friends[i];
                perm(output, depth+1, data);
                visited[i] = false;
            }
        }
    }

    static boolean condition(String data, char[] output) {
        int com1 = 0, com2 = 0;
        char compare = data.charAt(3);
        int interval = data.charAt(4) - '0' + 1;

        for(int i = 0 ; i < output.length ; i++) {
            if(output[i] == data.charAt(0))
                com1 = i;
            else if(output[i] == data.charAt(2))
                com2 = i;
        }

        if(compare == '=') {
            if(Math.abs(com2-com1) != interval)
                return false;
        }
        else if(compare == '>') {
            if(Math.abs(com2-com1) <= interval)
                return false;
        }
        else {
            if(Math.abs(com2-com1) >= interval)
                return false;
        }
        return true;
    }
}