package class1;

/**
 * @ author Egcoo
 * @ date 2023/2/20 - 15:57
 */
public class merge {

    public static void mergeSort(int q[], int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) / 2);
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        int[] temp = new int[q.length];
        while (i <= mid && j <= r) {
            if (q[i] < q[j]) {
                temp[k++] = q[i++];
            } else {
                temp[k++] = q[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = q[i++];
        }
        while (j <= r) {
            temp[k++] = q[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = temp[j];
        }
    }
}
