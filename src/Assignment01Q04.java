import java.util.Arrays;

public class Assignment01Q04 {

   public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        // אם הכיוון אינו 'R' או 'L', המערך נשאר ללא שינוי
        if (direction != 'R' && direction != 'L') {
            return array;
        }

        // אם המערך ריק, בעל איבר בודד, או שאין הזזה
        if (array.length <= 1 || move == 0) {
            return array;
        }

        // טיפול בהזזה שלילית: הופכים את הסימן ומחליפים כיוון
        if (move < 0) {
            move = -move;
            direction = (direction == 'R') ? 'L' : 'R';
        }

        int n = array.length;
        int k = move % n; // צמצום סיבובים שלמים

        // המרת הזזה שמאלה להזזה שקולה ימינה
        if (direction == 'L') {
            k = (n - k) % n;
        }

        if (k == 0) {
            return array;
        }

        // שימוש במערך עזר כדי לחשב את המיקומים החדשים
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = array[i];
        }

        // העתקת הערכים בחזרה למערך המקורי
        for (int i = 0; i < n; i++) {
            array[i] = temp[i];
        }

        return array;
    }
    

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}