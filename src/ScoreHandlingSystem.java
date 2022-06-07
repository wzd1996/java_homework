import java.util.Scanner;

public class ScoreHandlingSystem {
    public static void main(String[] args) {

        // 声明7个变量， 分别代表7门科目的成绩
        int ChineseIndex = 0;
        int mathIndex = 1;
        int EnglishIndex = 2;
        int physicsIndex = 3;
        int chemistryIndex = 4;
        int biologyIndex = 5;
        int physicalEducationIndex = 6;

        int totalScoreCount = 7;

        // 每门课的名字
        String[] names = new String[totalScoreCount];
        names[ChineseIndex] = "语文";
        names[mathIndex] = "数学";
        names[EnglishIndex] = "外语";
        names[physicsIndex] = "物理";
        names[chemistryIndex] = "化学";
        names[biologyIndex] = "生物";
        names[physicalEducationIndex] = "体育";
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入共有多少年的成绩：");

        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];

        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = Math.floor(95 + Math.random() * 5);
                System.out.println("第" + (i + 1) + "年" + names[j] + "成绩为：" + scores[i][j]);
            }
        }

        boolean cont = true;
        while (cont) {
            System.out.println("请选择要进行的操作：");
            System.out.println("1: 求某年最好成绩\n" +
                    "2: 求某年的平均成绩\n" +
                    "3: 求所有年份最好成绩\n" +
                    "4: 求某门课历年最好成绩");

            int oprtId = scanner.nextInt();

            int year = 0;
            switch (oprtId) {
                case 1:
                    // 让用户输入指定的年份
                    System.out.println("请输入要计算第几年的最好成绩");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("非法的年份：" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    // 指定年份的最好成绩的编号，开始假设是0
                    int bestOfYearScoreId = 0;
                    int samebestOfYearScoreId = 0;
                    // 循环指定年份的成绩，找出最好的成绩
                    // TODO：如果有两门课的成绩一样，而且都是最高的，怎么办？
                    for (int i = 1; i < totalScoreCount; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) {
                            bestOfYearScoreId = i;
                        }
                        if (scores[year][bestOfYearScoreId] == scores[year][i-1]) {
                            samebestOfYearScoreId = i-1;
                        }
                    }
                    if (scores[year][bestOfYearScoreId] != scores[year][samebestOfYearScoreId]) {
                        System.out.println("第" + (year + 1) + "年成绩最好的科目为" + names[bestOfYearScoreId] + "，成绩为" + scores[year][bestOfYearScoreId] + "。");
                    }
                    if (scores[year][bestOfYearScoreId] == scores[year][samebestOfYearScoreId]) {
                        System.out.println("第" + (year + 1) + "年成绩最好的科目有2门,分别为" + names[bestOfYearScoreId] + "与"+names[samebestOfYearScoreId]+"，成绩为" + scores[year][bestOfYearScoreId] + "。");
                    }
                    break;
                case 2:
                    System.out.println("请输入要计算第几年的平均成绩");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("非法的年份：" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    double totalCountForAvg = 0;
                    for (int i = 0; i < totalScoreCount; i++) {
                        totalCountForAvg += scores[year][i];
                    }
                    double avgOfYear = totalCountForAvg / totalScoreCount;
                    System.out.println("第" + (year + 1) + "年的平均成绩为" + avgOfYear + "。");
                    break;
                case 3:
                    int bestYear = 0;
                    int bestScore = 0;

                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalScoreCount; j++) {
                            if (scores[bestYear][bestScore] < scores[i][j]) {
                                bestYear = i;
                                bestScore = j;
                            }
                        }
                    }
                    System.out.println("所有年度最好成绩为第" + (bestYear + 1) + "年的" + names[bestScore] + "，成绩为" + scores[bestYear][bestScore] + "。");
                    break;
                case 4:
                    System.out.println("请输入科目编号");
                    int subjectId = scanner.nextInt();
                    if (subjectId <= 0 || totalScoreCount < subjectId) {
                        System.out.println("非法的科目编号：" + subjectId);
                        cont = false;
                        break;
                    }
                    subjectId = subjectId - 1;
                    year = 0;
                    for (int i = 1; i < yearCount; i++) {
                        if (scores[year][subjectId] < scores[i][subjectId]) {
                            year = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年度" + names[subjectId] + "成绩最好，为" + scores[year][subjectId] + "。");

                    break;
                default:
                    cont = false;
                    System.out.println("不支持：" + oprtId + "， 程序结束。");
            }
        }

    }
}
