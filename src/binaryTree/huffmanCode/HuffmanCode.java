package binaryTree.huffmanCode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {

    //用于存储赫夫曼编码表  供编码使用          解码的时候需要将键值对对调
   static  Map<Byte, String> huffmanCode = new HashMap<Byte, String>();

    static Map<String, Byte> huffmanDecode = new HashMap<String, Byte>();

    public static void main(String[] args) {
        String src = "E:\\ideapringboot\\shujujiegouyusuanfa\\src\\binaryTree\\huffmanCode\\huffman.zip";
        String dst = "huffman";

        try {
            unzipFile(src,dst);
        } catch (Exception e) {
            e.printStackTrace();
        }





       /* String msg = "can you can a can as a can canner can a can";
        byte[] zipBytes = zip(msg.getBytes());*/
        //将编码表的键值对调换  生成解码表
//        geneHuffmanDecode(huffmanCode);
        //解码
//        byte[] unzipByte = unzipByhuffmanDecode(zipByte);
        //将解码后的byte数组转成压缩前的字符串
//        System.out.println(new String(unzipByte));
    }

    /**
     * 压缩文件
     * @param src
     * @param dst
     */
    public static void zipFile(String src,String dst) throws IOException {
       //创建一个输入流
       InputStream is = new FileInputStream(src);
       byte[] b = new byte[is.available()];
       is.read(b);
       is.close();

       // 压缩byte
        byte[] zipByte = zip(b);

       // 将压缩后的数据跟赫夫曼编码表写入目标文件中
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        // 写入文件内容
        oos.writeObject(zipByte);

        // 将编码表的键值对调换  生成解码表
        geneHuffmanDecode(huffmanCode);
        // 写入解码表
        oos.writeObject(huffmanDecode);

        oos.close();
        os.close();

    }

    /**
     * 解压文件
     * @param src
     * @param dst
     */
    public static void unzipFile(String src,String dst) throws Exception{
        InputStream is = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(is);

        // 读取数据
        byte[] b = (byte[]) ois.readObject();
        // 读取赫夫曼解码表
         huffmanDecode = (Map<String, Byte>) ois.readObject();

         // 关流
         ois.close();
         is.close();

        byte[] unzipByte = unzipByhuffmanDecode(b);

        // 写入目标文件
        OutputStream os = new FileOutputStream(dst);
        os.write(unzipByte);

        os.close();

    }



    /**
     * 压缩byte
     * @param bytes
     * @return
     */
     public static byte[] zip(byte[] bytes){
         //统计每个byte出现的次数
         List<Node> byteNumList = countByte(bytes);

         //生成赫夫曼树
         Node tree = getHuffmanTree(byteNumList);

         //生成赫夫曼编码表
         getHuffmanCode(tree);

         //使用赫夫曼编码表对byte数组进行编码
         byte[] zipByte = huffmanZip(bytes,huffmanCode);

         return zipByte;
     }

    /**
     * 使用赫夫曼解码表对数组进行解码
     * @param zipByte
     * @return
     */
    private static byte[] unzipByhuffmanDecode(byte[] zipByte) {
        //用于临时存储解码后的byte集合
        List<Byte> upzipByteList = new ArrayList<Byte>();
        StringBuilder sb = new StringBuilder();  //用于临时存储二进制流
        //先将byte转成二进制字符串
        for (int i=0;i<zipByte.length;i++) {
            if(i==zipByte.length-1 && zipByte[i]>0) {
                sb.append(Integer.toBinaryString(zipByte[i]));
            }else {
                sb.append(byteToBinaryStr(zipByte[i]));
            }
        }

        // 使用赫夫曼解码表对二进制流进行解码
        int start =0;  //记录开始截取字符串的位置
        String binaryStr;
        Byte upzipByte = null;
        for (int i = 1; i <= sb.length(); i++) {
            binaryStr = sb.substring(start, i);
            upzipByte = huffmanDecode.get(binaryStr);
            if(upzipByte!=null) {
                upzipByteList.add(upzipByte);
                start = i;
            }
        }
        //将集合转byte数组
        int index = 0;
        byte[] byteArray = new byte[upzipByteList.size()];
        for (Byte b : upzipByteList) {
            byteArray[index++] = b;
        }

        return byteArray;
    }

    /**
     * byte转二进制流
     * @param b
     * @return
     */
    private static String byteToBinaryStr(byte b) {

        return Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
    }

    /**
     * 根据编码表生成解码表
     * @param huffmanCode2
     */
    private static void geneHuffmanDecode(Map<Byte, String> huffmanCod) {

        for (Map.Entry<Byte, String> entry:huffmanCod.entrySet()) {
            huffmanDecode.put(entry.getValue(), entry.getKey());
        }
    }


    //编码
    private static byte[] huffmanZip(byte[] bytes, Map<Byte, String> huffCode) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffCode.get(b));
        }
        int len = sb.length()%8==0?sb.length()/8:sb.length()/8+1;
        byte[] zipByte = new byte[len];
        int index = 0; //记录下标
        String binaryStr;
        for (int i = 0; i < sb.length(); i+=8) {
            if (i+8<sb.length()) {
                binaryStr = sb.substring(i, i+8);
            }else {
                binaryStr = sb.substring(i);
            }

            zipByte[index++] = (byte) Integer.parseInt(binaryStr, 2);
        }
        return zipByte;
    }

    /**
     * 根据赫夫曼树生成赫夫曼编码表
     * @param tree
     * @return
     */
    private static void getHuffmanCode(Node tree) {
        StringBuilder sb = new StringBuilder();
        if (tree == null) {
            return ;
        }
        getCodes(tree.getlNode(),"0",sb);
        getCodes(tree.getrNode(),"1",sb);
    }

    private static void getCodes(Node node, String s, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(s);
        if (node.getData()==null){
            getCodes(node.getlNode(),"0",sb2);
            getCodes(node.getrNode(),"1",sb2);
        }else{
            huffmanCode.put(node.getData(),sb2.toString());
        }
    }



    /**
     * 生成赫夫曼树
     * @param byteNumList
     * @return
     */
    private static Node getHuffmanTree(List<Node> byteNumList) {
        while (byteNumList.size()>1) {
            //排序
            Collections.sort(byteNumList);

            //取出集合末尾的两个节点
            Node lNode = byteNumList.get(byteNumList.size()-1);
            Node rNode = byteNumList.get(byteNumList.size()-2);
            //生成新的树
            Node parent = new Node(lNode.getWeight()+rNode.getWeight());
            parent.setlNode(lNode);
            parent.setrNode(rNode);
            //删除原集合中的两个节点
            byteNumList.remove(lNode);
            byteNumList.remove(rNode);

            //将新创建的树添加到集合中
            byteNumList.add(parent);
        }

        return byteNumList.get(0);
    }


    /**
     * 根据byte数组统计每个byte出现的次数 并组成节点的集合
     * @param bytes
     * @return
     */
    private static List<Node> countByte(byte[] bytes) {
        Map<Byte, Integer> countByte = new HashMap<Byte, Integer>();
        List<Node> nodeList = new ArrayList<Node>();
        Integer count;
        //统计出现的次数
        for (byte b : bytes) {
            count = countByte.get(b);
            if (count!=null) {
                countByte.put(b, count+1);
            }else {
                countByte.put(b, 1);
            }
        }
        //转成节点的集合
        for (Map.Entry<Byte, Integer> entry:countByte.entrySet()) {
            nodeList.add(new Node(entry.getValue(),entry.getKey()));
        }
        return nodeList;
    }

}
