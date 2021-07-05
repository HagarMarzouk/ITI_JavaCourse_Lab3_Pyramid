import java.util.*;

public class Pyramid {
    /*
        Instance variables definitions
    */
    private String pharaoh;
    private String ancientName;
    private String modernName;
    private int dynasty;
    private String site;
    private float base1;
    private float base2;
    private float height;
    private float slope;
    private float volume;
    private float latitude;
    private float longitude;
    private String type;
    private String lepsius;
    private String material;
    private String comment;

    /*
    Constructor that takes all inputs and initializes the instance variables
     */
    public Pyramid(String pharaoh, String ancientName, String modernName, int dynasty, String site, float base1, float base2, float height, float slope, float volume, float latitude, float longitude, String type, String lepsius, String material, String comment) {
        this.pharaoh = pharaoh;
        this.ancientName = ancientName;
        this.modernName = modernName;
        this.dynasty = dynasty;
        this.site = site;
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.slope = slope;
        this.volume = volume;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.lepsius = lepsius;
        this.material = material;
        this.comment = comment;
    }

    /*
    overriding toString method that returns the string representation of the object
    this step is done in order to be able to use System.out.println(pyramid), pyramid is Pyramid object
    more information can be found here: https://www.javatpoint.com/understanding-toString()-method#:~:text=The%20toString()%20method%20returns,depends%20on%20your%20implementation.
     */
    public String toString()
    {
        return "Pharaoh: "+pharaoh+", Ancient Name: "+ancientName+ ", Modern Name: "+modernName+", Dynasty: "+dynasty+
                ", Site: "+site+", Base1: "+base1+", Base2: "+base2+", Height: "+height+", Slope: "+slope+", Volume: "+volume+
                ", Latitude: "+latitude+", Longitude: "+longitude+", Type: "+type+", Lepsius: "+lepsius+", Material: "+material+
                ", Comment: "+comment;
    }
    /*
    Getters and setters, they are not used in this project. However, its a good practice to add
    them since our instance variables are private.
     */
    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getAncientName() {
        return ancientName;
    }

    public void setAncientName(String ancientName) {
        this.ancientName = ancientName;
    }

    public String getModernName() {
        return modernName;
    }

    public void setModernName(String modernName) {
        this.modernName = modernName;
    }

    public int getDynasty() {
        return dynasty;
    }

    public void setDynasty(int dynasty) {
        this.dynasty = dynasty;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getBase1() {
        return base1;
    }

    public void setBase1(float base1) {
        this.base1 = base1;
    }

    public float getBase2() {
        return base2;
    }

    public void setBase2(float base2) {
        this.base2 = base2;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getSlope() {
        return slope;
    }

    public void setSlope(float slope) {
        this.slope = slope;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLepsius() {
        return lepsius;
    }

    public void setLepsius(String lepsius) {
        this.lepsius = lepsius;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
