package domain;
import java.awt.Color;

/**Information about a Resources<br>
<b>(valley,row,column,color)</b><br>
<br>
 */
public abstract class Resource implements Unit{
    private Valley valley;    
    protected int row,column;    
    protected Color color;
    
    /**Create a new Resource(<b>row,column</b>) in the valley <b>valley</b>..
     * @param valley 
     * @param row 
     * @param column 
     */
    public Resource(Valley valley,int row, int column){
        this.valley=valley;
        this.row=row;
        this.column=column;
        this.valley.setUnit(row,column,(Unit)this);    
    }
    

    /**Returns the row
    @return 
     */
    public final int getRow(){
        return row;
    }
    
    
    /**Returns the column
    @return 
     */
    public final int getColumn(){
        return column;
    }

    
    protected Valley getValley() {
    return valley;
    }
    
    /**Returns the color
    @return 
     */
    public final Color getColor(){
        return color;
    }
        
}
