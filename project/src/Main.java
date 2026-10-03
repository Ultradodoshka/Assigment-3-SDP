public class Main {
    public static void main(String[] args) {
        runDemo();
    }

    private static void runDemo() {
        int passed = 0;
        int total = 7;

        Device tv = new TVDevice();
        Device radio = new RadioDevice();

        Remote basicRemote = new BasicRemote("R1", tv);
        Remote quietRemote = new QuietRemote("R2", tv);

        String t1Result = basicRemote.execute();
        boolean t1Pass = "Type: TV, Power: on, Volume: 30".equals(t1Result);
        if (t1Pass) passed++;
        System.out.println("T1 " + (t1Pass ? "PASS" : "FAIL") + " | BasicRemote + TvDevice | result=" + t1Result);

        basicRemote.setImplementation(radio);
        String t2Result = basicRemote.execute();
        boolean t2Pass = "Type: Radio, Power: on, Volume: 30".equals(t2Result);
        if (t2Pass) passed++;
        System.out.println("T2 " + (t2Pass ? "PASS" : "FAIL") + " | BasicRemote + RadioDevice | result=" + t2Result);

        String t3Result = quietRemote.execute();
        boolean t3Pass = "Type: TV, Power: on, Volume: 5".equals(t3Result);
        if (t3Pass) passed++;
        System.out.println("T3 " + (t3Pass ? "PASS" : "FAIL") + " | QuietRemote + TvDevice | result=" + t3Result);

        quietRemote.setImplementation(radio);
        String t4Result = quietRemote.execute();
        boolean t4Pass = "Type: Radio, Power: on, Volume: 5".equals(t4Result);
        if (t4Pass) passed++;
        System.out.println("T4 " + (t4Pass ? "PASS" : "FAIL") + " | QuietRemote + RadioDevice | result=" + t4Result);

        Remote t5Remote = new BasicRemote("R3", tv);
        Remote originalRef = t5Remote;
        String beforeId = t5Remote.getId();
        int beforeVol = t5Remote.getVolumePreset();
        String beforeResult = t5Remote.execute();

        t5Remote.setImplementation(radio);

        String afterResult = t5Remote.execute();
        boolean sameObject = (t5Remote == originalRef);
        boolean stateUnchanged = beforeId.equals(t5Remote.getId()) && (beforeVol == t5Remote.getVolumePreset());
        boolean beforeCorrect = "Type: TV, Power: on, Volume: 30".equals(beforeResult);
        boolean afterCorrect = "Type: Radio, Power: on, Volume: 30".equals(afterResult);

        boolean t5Pass = sameObject && stateUnchanged && beforeCorrect && afterCorrect;
        if (t5Pass) passed++;

        System.out.println("T5 " + (t5Pass ? "PASS" : "FAIL") + " sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        System.out.println("before=" + beforeResult + " | after=" + afterResult);

        Device projector = new ProjectorDevice();

        basicRemote.setImplementation(projector);
        String t6Result = basicRemote.execute();
        boolean t6Pass = "Type: Projector, Power: on, Volume: 30".equals(t6Result);
        if (t6Pass) passed++;
        System.out.println("T6 " + (t6Pass ? "PASS" : "FAIL") + " | BasicRemote + ProjectorDevice | result=" + t6Result);

        quietRemote.setImplementation(projector);
        String t7Result = quietRemote.execute();
        boolean t7Pass = "Type: Projector, Power: on, Volume: 5".equals(t7Result);
        if (t7Pass) passed++;
        System.out.println("T7 " + (t7Pass ? "PASS" : "FAIL") + " | QuietRemote + ProjectorDevice | result=" + t7Result);

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}