import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Person> person = new ArrayList<>();        

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            person.add(new Person(age, name));
        }
        person.sort(Comparator.comparing(p -> p.age));

        for(int i=0; i<person.size(); i++){
            Person tmp = person.get(i);
            sb.append(tmp.getAge()).append(" ").append(tmp.getName()).append('\n');
        }
        System.out.println(sb);
    }

    static class Person{
        Integer age;
        String name;

        public Person(Integer age, String name){
            this.age = age;
            this.name = name;
        }

        public Integer getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }
    }
}
