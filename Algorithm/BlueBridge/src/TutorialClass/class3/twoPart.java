package TutorialClass.class3;

/**
 * @ author Egcoo
 * @ date 2023/3/3 - 13:26
 */
public class twoPart {
    // 结果是右区间的左端点
    // 区间[1,r] 被分为[1,mid],[mid+1,r] 两部分
    public int bsearch1(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return 1;
    }

    // 要求的结果是左区间的右端点
    // 区间[1,r] 被分为[1,mid-1],[mid,r] 两部分
    public int bsearch2(int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return 1;
    }

    public boolean check(int i) {
        return false;
    }
}
