package cp213;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import javax.swing.JComponent;

/**
 * Provides a drawing canvas for a Model.
 *
 * @author David B. Brown
 * @version 2018-11-10
 */
@SuppressWarnings("serial")
public class Easel extends JComponent {

    /**
     * Repaints the easel whenever the model is updated.
     */
    private class ModelListener implements PropertyChangeListener {

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
	    Easel.this.repaint();
	}
    }

    private Model model = null;

    /**
     * The Easel needs direct access to the Model.
     *
     * @param newModel
     *            the Model to access.
     */
    public Easel(final Model model) {
	this.model = model;
	this.registerListeners();
    }

    /**
     * Randomly defines a shape based upon the current size of the easel. The
     * new shape is passed back to the model to be stored.
     *
     * @param t
     *            the type of shape to define.
     */
    public void defineShape(final String t) {
	final int x1 = (int) (Math.random() * this.getWidth());
	final int y1 = (int) (Math.random() * this.getHeight());
	final int x2 = (int) (Math.random() * this.getWidth());
	final int y2 = (int) (Math.random() * this.getHeight());

	if (t.equals("Rectangle")) {
	    this.model.addShape(new Rectangle(x1, y1, x2, y2));
	} else if (t.equals("Line")) {
	    this.model.addShape(new Line2D.Double(x1, y1, x2, y2));
	} else if (t.equals("Circle")) {
	    this.model.addShape(new Circle(x1, y1, x2));
	}
	else if (t.equals("Polygon")) {
		
		// Your code goes here
		
	}
    }
    
    /**
     * @param string
     */
    public void defineString(String string) {
    	
    	//Your code goes here
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;

	// Get a snapshot of the list of shapes in the model. Draw each in turn.
	final Iterator<Shape> i = this.model.getShapesIterator();

	while (i.hasNext()) {
		
		//Your code goes here
		//Use g2d.setColor to change paint color
		//use g2d.fill to paint a shape
	    g2d.draw(i.next());
	}
	
	
	//Print String
	//Your code goes here
	//Use g2d.drawString to print the text
    }

    /**
     * Registers the model listener.
     */
    private void registerListeners() {
	this.model.addPropertyChangeListener(new ModelListener());
    }
}