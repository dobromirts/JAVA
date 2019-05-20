package jediGalaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int[] enemyPossitions) {
        int enemyRow=enemyPossitions[0];
        int enemyCol=enemyPossitions[1];

        while (enemyRow>=0 && enemyCol>=0){

            if (isInRange(enemyRow,enemyCol)){
                this.galaxy.setStar(enemyRow,enemyCol,new Star(0));

            }

            enemyRow--;
            enemyCol--;
        }
    }

    private boolean isInRange(int enemyRow, int enemyCol) {
        return enemyRow>=0 && enemyRow<this.galaxy.getRows() && enemyCol>=0 && enemyCol<this.galaxy.getCols(enemyRow);
    }


    public long collectStars(int[] playerPositions) {
        int row=playerPositions[0];
        int col=playerPositions[1];
        long sum=0;

        while (row>=0&&col<this.galaxy.getCols(0)){

            if (isInRange(row,col)){
                sum+=this.galaxy.getStarValue(row,col);

            }

            row--;
            col++;
        }
        return sum;
    }
}
