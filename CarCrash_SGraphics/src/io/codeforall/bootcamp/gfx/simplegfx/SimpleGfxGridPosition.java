package io.codeforall.bootcamp.gfx.simplegfx;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.AbstractGridPosition;
import io.codeforall.bootcamp.grid.position.GridPosition;
import io.codeforall.bootcamp.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        switch (this.getColor()) {
            case BLUE:
                rectangle.setColor(Color.BLUE);
                break;
            case RED:
                rectangle.setColor(Color.RED);
                break;
            case GREEN:
                rectangle.setColor(Color.GREEN);
                break;
        }
        this.rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        switch (direction) {
            case UP:
                moveUp(distance);
                hide();
                this.rectangle = new Rectangle(this.simpleGfxGrid.columnToX(getCol()), this.simpleGfxGrid.rowToY(getRow()),
                        this.simpleGfxGrid.getCellSize(), this.simpleGfxGrid.getCellSize());
                break;
            case DOWN:
                moveDown(distance);
                hide();
                this.rectangle = new Rectangle(this.simpleGfxGrid.columnToX(getCol()), this.simpleGfxGrid.rowToY(getRow()),
                        this.simpleGfxGrid.getCellSize(), this.simpleGfxGrid.getCellSize());
                break;
            case LEFT:
                moveLeft(distance);
                hide();
                this.rectangle = new Rectangle(this.simpleGfxGrid.columnToX(getCol()), this.simpleGfxGrid.rowToY(getRow()),
                        this.simpleGfxGrid.getCellSize(), this.simpleGfxGrid.getCellSize());
                break;
            case RIGHT:
                moveRight(distance);
                hide();
                this.rectangle = new Rectangle(this.simpleGfxGrid.columnToX(getCol()), this.simpleGfxGrid.rowToY(getRow()),
                        this.simpleGfxGrid.getCellSize(), this.simpleGfxGrid.getCellSize());
                break;
        }
        show();
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
    }
}
