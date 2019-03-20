package binaryTree.huffmanCode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码
        byte[] b = huffmanZip(bytes);
        //使用赫夫曼解码
        byte[] newByte = decode(b,huffCodes);
        System.out.println(bytes.length);
        System.out.println(newByte.length);
    }


    /**
     * 使用赫夫曼编码表进行解码
     * @param b
     * @param huffCodes
     * @return
     */
    private static byte[] decode(byte[] b, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //将byte数组转为一个二进制的字符串
        boolean flag;  //是否需要用0补位
        for (int i =0;i<b.length;i++) {
                flag = i == (b.length-1)?false:true;
                sb.append(byteToBitStr(flag,b[i]));
        }
        // 1.把字符串按照指定的护肤满编码进行解码
        // 1.1将赫夫曼编码表的键值对进行调换
        Map<String,Byte>  newHuffCodes = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffCodes.entrySet()){
            newHuffCodes.put(entry.getValue(),entry.getKey());
        }
       // 1.2处理字符串
        int m =0;
        String key;
        List<Byte> byteList = new ArrayList<>();//用于存储取出来的byte
        for (int i=1;i<sb.length();i++){
            key = sb.substring(m,i);
            Byte aByte = newHuffCodes.get(key);
            if (aByte != null){
               byteList.add(aByte);
               m = i;
            }
        }
        byte[] newb = new byte[byteList.size()];
        int f = 0;
        for (Byte aByte : byteList) {
            newb[f++] = aByte;
        }
        return newb;
    }

    /**
     * byte转二进制流
     * @param flag  前面是否需要0来补齐
     * @param b
     * @return
     */
    private static String byteToBitStr(boolean flag,byte b){
        int tmp = b;
        if (flag){
            tmp|=256;
        }
        String str = Integer.toBinaryString(tmp);
        if (flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }
    }


    /**
     * 使用赫夫曼编码进行压缩
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每个byte出现的次数
        List<Node> nodes = getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffManCodes = getCodes(tree);
        //编码
        byte[] encode = zipByHuffMancodes(bytes,huffManCodes);
        return encode;
    }


    /**
     * 使用赫夫曼编码表对数组进行编码
     * @param bytes
     * @param huffManCodes
     * @return
     */
    private static byte[] zipByHuffMancodes(byte[] bytes, Map<Byte, String> huffManCodes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffManCodes.get(b));
        }
        //定义长度
        int len;
        if (sb.length()%8 == 0){
            len = sb.length()/8;
        }else{
            len = sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[] by = new byte[len];
        int index = 0;
        for (int m=0;m<sb.length();m+=8){
            String strByte;
            if (m+8 <sb.length()){
                 strByte = sb.substring(m,m+8);
            }else{
                strByte = sb.substring(m);
            }
            byte newByte = (byte) Integer.parseInt(strByte,2);
            by[index++] = newByte;
        }
        return by;
    }


    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //用于存储赫夫曼编码
    static  Map<Byte,String> huffCodes = new HashMap<>();
    /**
     * 创建赫夫曼编码表
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree == null){ return null;}
        getCodes(tree.getlNode(),"0",sb);
        getCodes(tree.getrNode(),"1",sb);

        return huffCodes;
    }

    private static void getCodes(Node node, String s, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(s);
        if (node.getData()==null){
            getCodes(node.getlNode(),"0",sb2);
            getCodes(node.getrNode(),"1",sb2);
        }else{
            huffCodes.put(node.getData(),sb2.toString());
        }
    }

    /**
     * 创建一颗赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            //排序 倒序
            Collections.sort(nodes);
           //取出最小的两个节点
            Node lNode = nodes.get(nodes.size()-1);
            Node rNode = nodes.get(nodes.size()-2);

            //创建一颗新树 左右节点为取出来的两个节点
            Node parent = new Node(lNode.getWeight()+rNode.getWeight());
            parent.setlNode(lNode);
            parent.setrNode(rNode);

            //从原集合中移除取出来的两个节点
            nodes.remove(lNode);
            nodes.remove(rNode);

            //将新节点添加到原集合中
            nodes.add(parent);
        }


        return nodes.get(0);
    }


    /**
     * 把byte数组转成node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //统计每个byte出现的次数
        Map<Byte,Integer> countsByte = new HashMap<>();
        for (byte b : bytes) {
            Integer count = countsByte.get(b);
            if (count != null){
                countsByte.put(b,count+1);
            }else{
                countsByte.put(b,1);
            }
        }
        //转成node集合
        for (Map.Entry<Byte,Integer> entry:countsByte.entrySet()){
            nodes.add(new Node(entry.getValue(),entry.getKey()));
        }
         return nodes;
    }
}
