
package principal;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * Classe contenant des méthodes statiques utiles pour raccourcir le code
 * @author Agustin Cartaya
 */
public class JeuMemoryUtil {
    
    /**
     * Buaca la URL de la imagen del personaje,
     * dependiendo el nombre del personaje
     * aun no esta en funcionamiento
     * @param name nombre del personaje
     * @return String con la URL de la imagen
     * @deprecated 
     */
    public static String getURLByNamePersonnage(String name){
        String s = "src/img/";
        
        if( (new File(name)).exists() )
            return name;
        else if ( ( new File(name+".jpg")).exists() )
            return name+".jpg";
        
        else if ( ( new File(name+".png")).exists() )
            return name+".png";
        
        else if ( ( new File(name+".gif")).exists() )
            return name+".gif";
 
        else if ( ( new File(s+name+".jpg")).exists() )
            return s+name+".jpg";
        
        else if ( ( new File(s+name+".png")).exists() )
            return s+name+".png";
        
        else if ( ( new File(s+name+".gif")).exists() )
            return s+name+".gif";
        
        if(!name.toLowerCase().equals(name))
            JeuMemoryUtil.getURLByNamePersonnage(name.toLowerCase());
        
        return s + "anonyme.png";
    }
    
    /**
     * Escala una imagen manteneidno sus demensiones
     * @param imgI imagen a escar
     * @param max dimension maxima
     * @return ImageIcon con la imagen escalada
     */
    public static ImageIcon imageScale( ImageIcon imgI, int max){
        Image img ;
        int w,h;
        w=imgI.getIconWidth();
        h =imgI.getIconHeight();
        if( w >h )
            img = imgI.getImage().getScaledInstance(max, -1, Image.SCALE_SMOOTH);
        else
            img = imgI.getImage().getScaledInstance(-1,max , Image.SCALE_SMOOTH);


        return new ImageIcon(img);
    }
    
}
