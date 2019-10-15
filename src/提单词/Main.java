package 提单词;

import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

/**
 * des:
 * created by miapoeng on 2019/10/13 20:29
 */
public class Main {

    private static Map<String, String> allMap = new LinkedHashMap<>();

    private static int xuanXiangNum = 5;

    static {
        allMap.put("alliance", "[n]联盟");
        allMap.put("allowance", "[n]津贴");
        allMap.put("along", "沿着");
        allMap.put("alongside", "靠着");
        allMap.put("alter", "[v]改变");
        allMap.put("alternative", "无可替代的");
        allMap.put("altogether", "[adv]完全的，总而言之");
        allMap.put("ambition", "[n]理想，追求");
        allMap.put("among", "在---当中");
        allMap.put("analysis", "[n]分析");
        allMap.put("analyst", "分析师");
        allMap.put("ancient", "古代的");
        allMap.put("announce", "[v]宣布");
        allMap.put("announcement", "[n]通告，宣布");
        allMap.put("appear", "[v]显得");
//        allMap.put("appearance", "[n]外表");
//        allMap.put("application", "[n]申请");
//        allMap.put("appoint", "[v]任命，委派");
//        allMap.put("appointment", "[n]任命，约定");
//        allMap.put("appreciate", "[v]感激");
//        allMap.put("approach", "[v]走近，靠近");
//        allMap.put("approval", "[n]批准，同意");
//        allMap.put("approve", "[v]认可，同意");
//        allMap.put("approximate", "大致的，大概的");
//        allMap.put("architect", "建筑师");
//        allMap.put("artificial", "人造的");
//        allMap.put("artist", "[n]画家");
//        allMap.put("ashamed", "羞耻的");
//        allMap.put("aside", "[adv]到旁边，存钱");
//        allMap.put("assess", "[v]评价");
//        allMap.put("assessment", "[n]评价");
//        allMap.put("assignment", "[n]任务");
//        allMap.put("assist", "[v]帮助");
//        allMap.put("assistance", "[n]帮助");
//        allMap.put("assistant", "[n]助手， 帮手");
//        allMap.put("associate", "[v]联系， 与...有关");
//        allMap.put("association", "[n]社团，协会");
//        allMap.put("annoy", "[v]惹怒，恼怒");
//        allMap.put("annual", "每年的");
//        allMap.put("anticipate", "[v]预料，预测");
//        allMap.put("anxiety", "[n]焦虑，忧虑， 渴望");
//        allMap.put("anxious", "紧张的，焦虑的");
//        allMap.put("anyhow", "无论怎样");
//        allMap.put("anyway", "无论如何");
//        allMap.put("anywhere", "无论何处");
//        allMap.put("apart", "相隔");
//        allMap.put("apartment", "公寓，房间");
//        allMap.put("apparent", "显而易见的");
//        allMap.put("apparently", "[adv]显然地，明显地");
//        allMap.put("appeal", "呼吁，恳请");
//        allMap.put("architecture", "建筑学");
//        allMap.put("area", "地区，领域");
//        allMap.put("argue", "[v]争辩，争吵");
//        allMap.put("argument", "[n]争论，论点");
//        allMap.put("arise", "[v]引起");
//        allMap.put("arm", "手臂， 武器");
//        allMap.put("armed", "武装的");
//        allMap.put("arrange", "[v]整理，安排");
//        allMap.put("arrangement", "[n]安排");
//        allMap.put("arrest", "[v]逮捕");
//        allMap.put("arrival", "[n]到达");
//        allMap.put("arrive", "[v]到达");
//        allMap.put("article", "[n]文章");
//        allMap.put("assume", "[v]假定");
//        allMap.put("assumption", "[n]假定");
//        allMap.put("assure", "[v]保证");
//        allMap.put("atmosphere", "气氛，大气层");
//        allMap.put("attach", "系(鞋带)， 附上");
//        allMap.put("attempt", "[n/v]尝试，努力");
//        allMap.put("attend", "[v]出席");
//        allMap.put("attention", "[n]注意");
//        allMap.put("atterney", "律师，代理人");
//        allMap.put("attraction", "[n]吸引力");
//        allMap.put("attractive", "[adj]有吸引力的");
//        allMap.put("audience", "[n]观众，听众");
//        allMap.put("aunt", "[n]姑、姨、舅");
//        allMap.put("authority", "[n]权力");
//        allMap.put("automatic", "自动的");
//        allMap.put("automatically", "[adv]自动地，机械地");
//        allMap.put("avoid", "避免");
//        allMap.put("awake", "醒着的");
//        allMap.put("award", "[n]奖励");
//        allMap.put("aware", "[adj]意识到的");
//        allMap.put("awareness", "[n]意识");
//        allMap.put("awful", "[adj]糟糕的");
//        allMap.put("awkward", "[adj]尴尬的");
//        allMap.put("acid", "酸");
//        allMap.put("active", "积极的");
//        allMap.put("activist", "积极分子");
//        allMap.put("activity", "活动");
//        allMap.put("ad", "广告");
//        allMap.put("in addition to", "除---之外");
//        allMap.put("addition", "添加，加法");
//        allMap.put("additional", "额外的");
//        allMap.put("adequate", "足够的");
//        allMap.put("adjust", "[v]适应，习惯");
//        allMap.put("administration", "行政机构，行政，管理");
//        allMap.put("admission", "[n]承认");
//        allMap.put("admit", "[v]承认");
//        allMap.put("adopt", "[v]收养");
//        allMap.put("adult", "成人");
//        allMap.put("advantage", "[n]优势，有利条件");
//        allMap.put("advert", "[n]广告");
//        allMap.put("advertise", "[v]为....做广告");
//        allMap.put("advertisement", "[n]广告");
//        allMap.put("advise", "[v]建议，劝告");
//        allMap.put("adviser", "[n]顾问");
//        allMap.put("affair", "[n]事件，事务");
//        allMap.put("affect", "感动，影响");
//        allMap.put("afford", "买得起");
//        allMap.put("afterwards", "随后");
//        allMap.put("against", "违背");
//        allMap.put("aged", "年老的，...岁的");
//        allMap.put("agency", "[n]代理，中介，经销");
//        allMap.put("agent", "代理人");
//        allMap.put("aggressive", "有进取心的， 有闯劲的");
//        allMap.put("agriculture", "农业");
//        allMap.put("aid", "援助，帮助");
//        allMap.put("aim", "目的，目标");
//        allMap.put("aircraft", "飞机，飞行器");
//        allMap.put("album", "相册");
//        allMap.put("alcohol", "酒精");
//        allMap.put("actor", "演员");
//        allMap.put("absorb", "吸收（营养）");
//        allMap.put("abuse", "虐待");
//        allMap.put("academic", "学业优秀的");
//        allMap.put("accent", "口音");
//        allMap.put("acceptance", "[n]接受");
//        allMap.put("access", "访问，进入，使用权");
//        allMap.put("accommodation", "住处");
//        allMap.put("accompany", "[v]陪伴");
//        allMap.put("according to", "根据");
//        allMap.put("account", "账户");
//        allMap.put("accurate", "[adj]精确的");
//        allMap.put("accuse", "[v]控告，指控");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println("模式：");
            StringBuilder sb = new StringBuilder();
            sb.append("1-根据词找词义").append("\n");
            sb.append("2-根据词义找词").append("\n");
            sb.append("3-根据词义写出单词").append("\n");
            System.out.println(sb.toString());
            System.out.println("请选择模式：");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String insertIndex = scanner.next();
            if (!insertIndex.equals("1") && !insertIndex.equals("2") && !insertIndex.equals("3")) {
                System.out.println("请输入序号内的数字选项");
                continue;
            }
            if (insertIndex.equals("exit")) {
                System.out.println("安全退出");
                System.exit(0);
            }
            if (Integer.valueOf(insertIndex) == 1) {
                ciToYi();
            } else if (Integer.valueOf(insertIndex) == 2) {
                yiToCi();
            } else if (Integer.valueOf(insertIndex) == 3) {
                yiXieCi();
            }
        }
    }

    private static void writeFile (String content) {
        FileUtil.writeContentToFile("./src/提单词", "error.txt", "utf-8", "\n" + content, StandardOpenOption.APPEND);
        FileUtil.readFileToSet("./src/提单词", "error.txt", "utf-8");
    }

    /**
     * 意写词
     */
    private static void yiXieCi() {
//        int xuanXiangNum = 3;
        String insertIndex1 = "";
        while (true) {
            System.out.println("1-从题库");
            System.out.println("2-从错题集");
            System.out.println("3-删除错题集后从题库");
            Scanner scanner1 = new Scanner(System.in);
            scanner1.useDelimiter("\n");
            insertIndex1 = scanner1.next();
            if (!insertIndex1.equals("1") && !insertIndex1.equals("2") && !insertIndex1.equals("3")) {
                System.out.println("请输入序号内的数字选项");
                continue;
            } else {
                if (insertIndex1.equals("2")) {
                    if (!FileUtil.isExsits("./src/提单词/error.txt")) {
                        System.out.println("错题集不存在");
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        List<String> danCiList = new ArrayList<>();
        List<String> yuYiList = new ArrayList<>();
        if (insertIndex1.equals("1")) {
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        } else if (insertIndex1.equals("2")) {
            Set<String> errors = FileUtil.readFileToSet("./src/提单词", "error.txt", "utf-8");
            for (String error : errors) {
                if (error.contains("--")) {
                    String yuYi = error.split("--")[0];
                    String danCi = error.split("--")[1];
                    danCiList.add(danCi);
                    yuYiList.add(yuYi);
                }
            }
        } else if (insertIndex1.equals("3")) {
            FileUtil.deleFile("./src/提单词", "error.txt");
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        }
        Map<String, Integer> errList = new LinkedHashMap<>();
        int sum = danCiList.size();
        while (true) {
            Random random = new Random();
            int selectRandom = random.nextInt(danCiList.size());
            String selectDanCi = danCiList.get(selectRandom);
            String selectYuYi = yuYiList.get(selectRandom);
//            List<Integer> noRepeatList = getNoRepeatRandom(yuYiList.size(), xuanXiangNum, selectRandom);
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < noRepeatList.size(); i++) {
//                int value = noRepeatList.get(i);
//                String noRepeatYuYi = danCiList.get(value);
//                sb.append(value).append("---").append(noRepeatYuYi).append("\n");
//            }
//            System.out.println(sb);
            System.out.println("[" + (sum - danCiList.size() + 1) + "/" +sum + "] " + selectYuYi);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String insertIndex = scanner.next();
            if (insertIndex.equals("exit")) {
                System.out.println("已退出当前模式");
                break;
            }
            if (insertIndex.equals(selectDanCi)) {
                System.out.println("正确");
                danCiList.remove(selectRandom);
                yuYiList.remove(selectRandom);
            } else {
                System.out.println("错误, " + selectYuYi + " 的单词是 " + selectDanCi);
                if (errList.containsKey((selectYuYi + "--" + selectDanCi))) {
                    errList.put((selectYuYi + "--" + selectDanCi), errList.get((selectYuYi + "--" + selectDanCi)) + 1);
                } else {
                    errList.put((selectYuYi + "--" + selectDanCi), 1);
                    writeFile((selectYuYi + "--" + selectDanCi));
                }
            }
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println();
            if (danCiList.size() <= 0) {
                break;
            }
        }
        System.out.println("错误列表：" + errList.size());
        errList = sortMapByValues(errList);
        for (String key : errList.keySet()) {
            System.out.println(key + " #### " + errList.get(key));
        }
        System.out.println("\n\n\n");
    }

    /**
     * Map按照value排序
     * @param aMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }

    /**
     * 意选词
     */
    private static void yiToCi() {
        String insertIndex1 = "";
        while (true) {
            System.out.println("1-从题库");
            System.out.println("2-从错题集");
            System.out.println("3-删除错题集后从题库");
            Scanner scanner1 = new Scanner(System.in);
            scanner1.useDelimiter("\n");
            insertIndex1 = scanner1.next();
            if (!insertIndex1.equals("1") && !insertIndex1.equals("2") && !insertIndex1.equals("3")) {
                System.out.println("请输入序号内的数字选项");
                continue;
            } else {
                if (insertIndex1.equals("2")) {
                    if (!FileUtil.isExsits("./src/提单词/error.txt")) {
                        System.out.println("错题集不存在");
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        List<String> danCiList = new ArrayList<>();
        List<String> yuYiList = new ArrayList<>();
        if (insertIndex1.equals("1")) {
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        } else if (insertIndex1.equals("2")) {
            Set<String> errors = FileUtil.readFileToSet("./src/提单词", "error.txt", "utf-8");
            for (String error : errors) {
                if (error.contains("--")) {
                    String yuYi = error.split("--")[0];
                    String danCi = error.split("--")[1];
                    danCiList.add(danCi);
                    yuYiList.add(yuYi);
                }
            }
        } else if (insertIndex1.equals("3")) {
            FileUtil.deleFile("./src/提单词", "error.txt");
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        }
        Map<String, Integer> errList = new LinkedHashMap<>();
        int sum = danCiList.size();
        while (true) {
            Random random = new Random();
            int selectRandom = random.nextInt(danCiList.size());
            String selectDanCi = danCiList.get(selectRandom);
            String selectYuYi = yuYiList.get(selectRandom);
            List<Integer> noRepeatList = getNoRepeatRandom(yuYiList.size(), xuanXiangNum, selectRandom);
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> xuHaoConvertMap = new LinkedHashMap<>();
            for (int i = 0; i < noRepeatList.size(); i++) {
                int value = noRepeatList.get(i);
                xuHaoConvertMap.put((i + 1), value);
                String noRepeatYuYi = danCiList.get(value);
                sb.append((i + 1)).append("---").append(noRepeatYuYi).append("\n");
            }
            System.out.println(sb);
            System.out.println("[" + (sum - danCiList.size() + 1) + "/" +sum + "] " + selectYuYi);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String insertIndex = scanner.next();
            if (insertIndex.equals("exit")) {
                System.out.println("已退出当前模式");
                break;
            }
            if (Integer.valueOf(insertIndex) > noRepeatList.size()) {
                System.out.println("请输入选项内的数字");
                continue;
            }
            String answer = danCiList.get(xuHaoConvertMap.get(Integer.valueOf(insertIndex)));
            if (answer.equals(selectDanCi)) {
                System.out.println("正确");
                danCiList.remove(selectRandom);
                yuYiList.remove(selectRandom);
            } else {
                System.out.println("错误, " + selectYuYi + " 的单词是 " + selectDanCi);
                if (errList.containsKey((selectYuYi + "--" + selectDanCi))) {
                    errList.put((selectYuYi + "--" + selectDanCi), errList.get((selectYuYi + "--" + selectDanCi)) + 1);
                } else {
                    errList.put((selectYuYi + "--" + selectDanCi), 1);
                    writeFile((selectYuYi + "--" + selectDanCi));
                }
            }
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println();
            if (danCiList.size() <= 0) {
                break;
            }
        }
        System.out.println("错误列表：" + errList.size());
        errList = sortMapByValues(errList);
        for (String key : errList.keySet()) {
            System.out.println(key + " #### " + errList.get(key));
        }
        System.out.println("\n\n\n");
    }

    /**
     * 词选意
     */
    private static void ciToYi() {
        String insertIndex1 = "";
        while (true) {
            System.out.println("1-从题库");
            System.out.println("2-从错题集");
            System.out.println("3-删除错题集后从题库");
            Scanner scanner1 = new Scanner(System.in);
            scanner1.useDelimiter("\n");
            insertIndex1 = scanner1.next();
            if (!insertIndex1.equals("1") && !insertIndex1.equals("2") && !insertIndex1.equals("3")) {
                System.out.println("请输入序号内的数字选项");
                continue;
            } else {
                if (insertIndex1.equals("2")) {
                    if (!FileUtil.isExsits("./src/提单词/error.txt")) {
                        System.out.println("错题集不存在");
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        List<String> danCiList = new ArrayList<>();
        List<String> yuYiList = new ArrayList<>();
        if (insertIndex1.equals("1")) {
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        } else if (insertIndex1.equals("2")) {
            Set<String> errors = FileUtil.readFileToSet("./src/提单词", "error.txt", "utf-8");
            for (String error : errors) {
                if (error.contains("--")) {
                    String yuYi = error.split("--")[0];
                    String danCi = error.split("--")[1];
                    danCiList.add(danCi);
                    yuYiList.add(yuYi);
                }
            }
        } else if (insertIndex1.equals("3")) {
            FileUtil.deleFile("./src/提单词", "error.txt");
            for (String key : allMap.keySet()) {
                String danCi = key;
                String yuYi = allMap.get(key);
                danCiList.add(danCi);
                yuYiList.add(yuYi);
            }
        }
        Map<String, Integer> errList = new LinkedHashMap<>();
        int sum = danCiList.size();
        while (true) {
            Random random = new Random();
            int selectRandom = random.nextInt(danCiList.size());
            String selectDanCi = danCiList.get(selectRandom);
            String selectYuYi = yuYiList.get(selectRandom);
            List<Integer> noRepeatList = getNoRepeatRandom(yuYiList.size(), xuanXiangNum, selectRandom);
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> xuHaoConvertMap = new LinkedHashMap<>();
            for (int i = 0; i < noRepeatList.size(); i++) {
                int value = noRepeatList.get(i);
                xuHaoConvertMap.put((i + 1), value);
                String noRepeatYuYi = yuYiList.get(value);
                sb.append((i + 1)).append("---").append(noRepeatYuYi).append("\n");
            }
            System.out.println(sb);
            System.out.println((sum - danCiList.size() + 1) + "/" +sum + " " + selectDanCi);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String insertIndex = scanner.next();
            if (insertIndex.equals("exit")) {
                System.out.println("已退出当前模式");
                break;
            }
            if (Integer.valueOf(insertIndex) > noRepeatList.size()) {
                System.out.println("请输入选项内的数字");
                continue;
            }
            String answer = danCiList.get(xuHaoConvertMap.get(Integer.valueOf(insertIndex)));
            if (answer.equals(selectDanCi)) {
                System.out.println("正确");
                danCiList.remove(selectRandom);
                yuYiList.remove(selectRandom);
            } else {
                System.out.println("错误, " + selectDanCi + " 的语义是 " + selectYuYi);
                if (errList.containsKey((selectYuYi + "--" + selectDanCi))) {
                    errList.put((selectYuYi + "--" + selectDanCi), errList.get((selectYuYi + "--" + selectDanCi)) + 1);
                } else {
                    errList.put((selectYuYi + "--" + selectDanCi), 1);
                    writeFile((selectYuYi + "--" + selectDanCi));
                }
            }
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println();
            if (danCiList.size() <= 0) {
                break;
            }
        }
        errList = sortMapByValues(errList);
        System.out.println("错误列表：" + errList.size());
        for (String key : errList.keySet()) {
            System.out.println(key + " #### " + errList.get(key));
        }
        System.out.println("\n\n\n");
    }

    /**
     * 在多少个总数里面，获取多少个不重复的数
     * @param sum
     * @return
     */
    private static List<Integer> getNoRepeatRandom (int sum, int num, int sureIndex) {
        List<Integer> retList = new ArrayList<>();
        if (sum <= num) {
            for (int i = 0; i < sum; i++) {
                retList.add(i);
            }
            Collections.shuffle(retList);
            return retList;
        }
        retList.add(sureIndex);
        int index = 0;
        Random random = new Random();
        while (true) {
            index++;
            if (index >= 1000 * 10000) {
                break;
            }

            if (retList.size() >= num) {
                break;
            }
            int randomNum = random.nextInt(sum);
            if (retList.contains(randomNum)) {
                continue;
            }
            retList.add(randomNum);
        }
        Collections.shuffle(retList);
        return retList;
    }

}
