import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int frame, num;
        Student[] students = new Student[101];
        List<Student> list = new ArrayList<>();

        frame = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++) {
            int studentNum = Integer.parseInt(st.nextToken());
            
            // 1. 추천 안받았으면 student 생성 
            if(students[studentNum] == null) {
                students[studentNum] = new Student(
                    studentNum,
                    0, 
                    0, 
                    false);
            }
            // 2. 추천 받아서 이미 게시되어 있으면
            if(students[studentNum].isPosted) {
                students[studentNum].recommendCount++;
            }
            // 3. 게시된 적 없지만 추천 받았으면
            else {
                // 3-1. 게시판이 꽉 찬 경우 - 추천수 적은 순 -> 오래된 순으로 제거
                if(list.size() == frame) {
                    Collections.sort(list, new Comparator<Student>() {
                        public int compare(Student o1, Student o2) {
                            if(o1.recommendCount == o2.recommendCount) {
                                return o1.sequence - o2.sequence;
                            }
                            return o1.recommendCount - o2.recommendCount;
                        }
                    });
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                 // 3-2. 게시판이 꽉 차지 않은 경우
                students[studentNum].recommendCount = 1;
                students[studentNum].sequence=i;
                students[studentNum].isPosted = true;
                list.add(students[studentNum]);
            }
        }
        Collections.sort(list, (o1,o2) -> o1.id - o2.id);
        for(Student a: list) {
            System.out.print(a.id + " ");
        }
    }

    static class Student {
        int id;
        int recommendCount;
        int sequence;
        boolean isPosted;

        public Student(int id, int recommendCount, int sequence, boolean isPosted) {
            this.id = id;
            this.recommendCount = recommendCount;
            this.sequence = sequence;
            this.isPosted = isPosted;
        }
    }
}
