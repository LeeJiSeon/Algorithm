class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skillarr = skill.split("");

        for(String tree : skill_trees) {
            boolean possible = true;
            int index = -2;
            for(String sk : skillarr) {
                if(index < tree.indexOf(sk)) {
                    if(index == -1) {
                        possible = false;
                        break;
                    }
                    else
                        index = tree.indexOf(sk);
                }
                else if(tree.indexOf(sk) == -1) {
                    index = -1;
                }
                else {
                    possible = false;
                    break;
                }
            }
            if(possible)
                answer++;
        }
        return answer;
    }
}