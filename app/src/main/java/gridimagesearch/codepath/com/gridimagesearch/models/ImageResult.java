package gridimagesearch.codepath.com.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import java.io.Serializable;
//import java.io.Serializable;
//import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;


public class ImageResult implements Serializable {
    private static final long serialVersionUID = -6827630709355604609L;
    public String fullUrl;
    public String thumbUrl;
    public String title;

    public ImageResult(JSONObject json)  {
        try {
            this.fullUrl= json.getString("url");
            this.thumbUrl=json.getString("tbUrl");
            this.title=json.getString("title");

        }catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<ImageResult> fromJSONArray(JSONArray array)  {
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();

        for (int i=0 ; i < array.length();i++ ){
            try {
                results.add(new ImageResult(array.getJSONObject(i)));

            }catch (JSONException e){
                e.printStackTrace();

            }
        }
        return results;

    }
}
