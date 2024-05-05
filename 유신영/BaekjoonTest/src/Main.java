import java.util.ArrayList;

private static void Main(String[] people ) {
    int r = 3;
    boolean[] isChecked = new boolean[people.length];
    String[] result = new String[r];
    ArrayList<String[]> totalList = new ArrayList<String[]>();

    permutation(people, isChecked, result, r, 0, totalList);

    for (String[] strings : totalList) {
        String temp = "";
        for( String text : strings ) {
            temp += " " + text;
        }
        System.out.println(temp);
    }
    System.out.println("총 경우의 수 : " + totalList.size());
}

private static void permutation( String[] people, boolean[] isChecked, String[] result, int endPoint, int dept, ArrayList<String[]> totalList ) {
    if( endPoint == dept ) {
        totalList.add(result.clone());
    } else {
        for ( int i = 0; i < people.length; i++ ) {
            if( !isChecked[i] ) {
                isChecked[i] = true; // 사용된 배열 위치
                result[dept] = people[i]; // 저장
                permutation(people, isChecked, result, endPoint, dept + 1, totalList);
                isChecked[i] = false; // 사용된 것 다시 제자리
                result[dept] = ""; // 저장된 것 제자리
            }
        }
    }
}