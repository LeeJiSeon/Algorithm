import java.util.*;

class SkillTree_other {
    public int solution(String skill, String[] skill_trees) {
        List<String> skill_list = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skill_list.iterator();
        
        while(it.hasNext()) {
            if(skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0)
                it.remove();
        }
        return skill_list.size();
    }
}