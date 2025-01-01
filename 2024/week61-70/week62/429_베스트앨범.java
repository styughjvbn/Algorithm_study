import java.util.*;

class Solution {
    class Music {
        int idx;
        int count;
        Music(int a, int b){
            this.idx=a;
            this.count=b;
        }
    }
    class genre{
        int total;
        ArrayList<Music> MusicList=new ArrayList<>();
        genre(int a, Music b){
            this.total=a;
            this.MusicList.add(b);
        }
    }
    public ArrayList<Integer> solution(String[] genres,int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, genre> genreMap=new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Music MusicObj=new Music(i,plays[i]);
            if (genreMap.putIfAbsent(genres[i],new genre(plays[i],MusicObj))!=null){
                genreMap.get(genres[i]).total+=plays[i];
                genreMap.get(genres[i]).MusicList.add(MusicObj);
            };
        }
        ArrayList<String> temp=new ArrayList<>(genreMap.keySet());
        temp.sort((o1, o2) -> genreMap.get(o2).total-genreMap.get(o1).total);
        for (String o : temp) {
            genreMap.get(o).MusicList.sort((a,b)->{
                if (a.count==b.count){
                    return a.idx-b.idx;
                }else{
                    return b.count-a.count;
                }
            });
            int tmp=0;
            for (Music music : genreMap.get(o).MusicList) {
                tmp++;
                if(tmp>2){
                    break;
                }

                answer.add(music.idx);
            }
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution temp=new Solution();
        String[] temp1= {"classic", "pop", "classic", "classic", "pop"};
        int[] temp2= {500, 600, 150, 800, 2500};
        System.out.println(temp.solution(temp1,temp2));
    }
}
