class Rectangle {
    public long solution(int w,int h) {
        long answer = (long)w * (long)h - (w + h);
        if(w > h) {
            int tmp = w;
            w = h;
            h = tmp;
        }
        while(h % w != 0) {
            int tmp = h % w;
            h = w;
            w = tmp;
        }
		return answer + w;
    }
}