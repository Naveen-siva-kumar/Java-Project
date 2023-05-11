public class Graph extends JPanel {

    public void paintGraph (Graphics g){

        ArrayList<Integer> scores = new ArrayList<Integer>(10);

        Random r = new Random();

        for (int i : scores){
            i = r.nextInt(20);
            System.out.println(r);
        }

        int y1;
        int y2;

        for (int i = 0; i < scores.size(); i++){
            y1 = scores.get(i);
            y2 = scores.get(i+1);
            g.drawLine(i, y1, i+1, y2);
        }
    }
}
