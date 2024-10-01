package programmers;

import java.util.*;

public class P42890 {
    public int solution(String[][] relation) {
//        int answer = 0;
//
//        Map<Integer, Map<String, List<Integer>>> duplicateIndexs = new HashMap<>();
//
//        int columnSize = relation[0].length,
//                relationSize = relation.length;
//
//        for(int i = 0; i < columnSize; i++) {
//            duplicateIndexs.put(i, new HashMap<>());
//        }
//
//        for(int i = 0; i < columnSize; i++) {
//            for(int j = 0; j < relationSize - 1; j++) {
//                if(duplicateIndexs.get(i).containsKey(relation[j][i])) {
//                    continue;
//                }
//
//                for(int k = j + 1; k < relationSize; k++) {
//                    if(relation[j][i].equals(relation[k][i])) {
//                        if(!duplicateIndexs.get(i).containsKey(relation[j][i])) {
//                            duplicateIndexs.get(i).put(relation[k][i], new ArrayList<>());
//                            duplicateIndexs.get(i).get(relation[k][i]).add(j);
//                        }
//                        duplicateIndexs.get(i).get(relation[k][i]).add(k);
//                    }
//                }
//            }
//        }
//
//        System.out.println(duplicateIndexs);
//
//        return answer;
//    }

//    boolean isCheck(String[][] relation, int columnSize, int relationSize, int subset) {
//        boolean cond = true;
//
//        for (int i = 0; i < relationSize - 1; i++) {
//            for (int j = i + 1; j < relationSize; j++) {
//            }
//        }
//
//        return cond;
//    };
//
//    public int solution(String[][] relation) {
//        int answer = 0;
//
//        int columnSize = relation[0].length,
//                relationSize = relation.length;
//
//        List<Integer> candidates = new ArrayList<>();
//
//        for (int i = 1; i < (1 << columnSize); i++) {
//            if (isCheck(relation, columnSize, relationSize, i)) {
//                candidates.add(i);
//            }
//        }
//
//        return answer;
//    }

        int answer = 0;

        int rowsize = relation.length;
        int colsize = relation[0].length;

        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i < 1<<colsize; ++i){
            if(check(relation , rowsize , colsize , i)){
                candidates.add(i);
            }
        }
        //최소성 만족
        while(!candidates.isEmpty()) {
            int n = candidates.remove(0); //최소성을 만족하는 후보키
            System.out.println(n + " / " +candidates);
            ++answer;

            for (Iterator<Integer> it = candidates.iterator(); it.hasNext();){
                int c = it.next();
                if( (n & c) == n ) //후보키가 속해있다면 삭제
                    it.remove();
            }
        }
        System.out.println(answer);
        return answer;
    }

    private boolean check(String[][] relation, int rowsize, int colsize, int subset) {
        for ( int i = 0; i < rowsize -1 ; ++i) {
            for (int j = i+1; j < rowsize; ++j){
                boolean isSame = true;
                for (int k = 0 ; k < colsize; ++k){
                    if((subset & 1<<k) == 0){
                        continue;
                    }
                    if(relation[i][k].equals(relation[j][k]) == false){
                        isSame = false;
                        break;
                    }
                }
                if(isSame)
                    return false;
            }
        }
        return true;
    }
}