package y5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new f(0);
    public int A;
    public boolean B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f14938v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f14939w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f14940x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f14941y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f14942z;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.optBoolean("visible", true)) {
                    arrayList.add(b(jSONObject));
                }
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public static g b(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f14942z = "pronull";
        gVar.A = 0;
        gVar.f14938v = jSONObject.getString("name");
        gVar.f14939w = jSONObject.getString("link");
        if (jSONObject.has("api") && !jSONObject.isNull("api") && !TextUtils.isEmpty(jSONObject.getString("api"))) {
            gVar.f14940x = jSONObject.getString("api");
        }
        gVar.f14941y = jSONObject.optString("tokenApi", null);
        gVar.f14942z = jSONObject.optString("audio", "pronull");
        gVar.A = jSONObject.optInt("scheme", 0);
        gVar.B = jSONObject.optBoolean("secure_decoder", false);
        return gVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14938v);
        parcel.writeString(this.f14939w);
        parcel.writeString(this.f14940x);
        parcel.writeString(this.f14941y);
        parcel.writeString(this.f14942z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B ? 1 : 0);
    }
}
