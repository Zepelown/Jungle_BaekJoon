package m03.d25;

import java.util.List;

public class 병합정렬 {
    public static void main(String[] args) {

    }
    private static void mergeSort(List list, int left, int right){
        if(right >= left){
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(list, left,middle-1);
        mergeSort(list,middle,right);
    }
    // Merge Sort 메서드
    public static void mergeSort(int[] array) {
        if (array.length < 2) { // 배열의 길이가 1 이하일 경우 정렬 완료
            return;
        }

        // 배열을 두 부분으로 나누기
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // 재귀적으로 좌우 부분 정렬
        mergeSort(left);
        mergeSort(right);

        // 병합
        merge(left, right, array);
    }
    private static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        // 작은 값을 선택하여 병합
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 남은 요소 추가
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
