package class7;

/**
 * @ author Egcoo
 * @ date 2023/1/17 - 17:31
 */
public class TrieTree {

    //前缀树，一棵树，多个节点隶属于一条分支，某些节点是另一些节点的前缀 （eg: "ab" "abc" "abcd"）
    // eg
    // 一个字符串类型的数组 arr1，另一个字符串类型的数组 arr2，arr2中有哪些字符，是arr1中出现的
    //  arr2中有那些字符，是作为arr1中某个字符串前缀出现的？请打印
    //

    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // next[0] == null 没有走向 ‘a’的路
            // next[1] == null 没有走向 ‘b’的路
            //
            //
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            // 从左往右遍历字符
            for (int i = 0; i < chs.length; i++) {
                // 由字符，对应成走向那条路
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            // 将其作为前缀的节点
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        // 如果下一个节点的pass - 1 = 0；则直接置空
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            // 从左往右遍历字符
            for (int i = 0; i < chs.length; i++) {
                // 由字符，对应成走向那条路
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }


        //所有加入的字符串中，有几个是以pre这个字符串为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            // 从左往右遍历字符
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
