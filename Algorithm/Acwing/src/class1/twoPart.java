package class1;

/**
 * @ author Egcoo
 * @ date 2023/2/20 - 20:35
 *
 * 假设有一个总区间，经由我们的 check 函数判断后，可分成两部分，
 * 这边以o作 true，.....作 false 示意较好识别
 *
 * 如果我们的目标是下面这个v，那麽就必须使用模板 1
 *
 * ................vooooooooo
 *
 * 假设经由 check 划分后，整个区间的属性与目标v如下，则我们必须使用模板 2
 *
 * oooooooov...................
 */
public class twoPart {

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
