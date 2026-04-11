package oc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import k8.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new x(9);
    public boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f9540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f9541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f9542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f9543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f9544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9545z;

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

    public static f b(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f9544y = "pronull";
        fVar.f9545z = 0;
        fVar.f9540u = jSONObject.getString("name");
        fVar.f9541v = jSONObject.getString("link");
        if (jSONObject.has("api") && !jSONObject.isNull("api") && !TextUtils.isEmpty(jSONObject.getString("api"))) {
            fVar.f9542w = jSONObject.getString("api");
        }
        fVar.f9543x = jSONObject.optString("tokenApi", null);
        fVar.f9544y = jSONObject.optString("audio", "pronull");
        fVar.f9545z = jSONObject.optInt("scheme", 0);
        fVar.A = jSONObject.optBoolean("secure_decoder", false);
        return fVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9540u);
        parcel.writeString(this.f9541v);
        parcel.writeString(this.f9542w);
        parcel.writeString(this.f9543x);
        parcel.writeString(this.f9544y);
        parcel.writeInt(this.f9545z);
        parcel.writeInt(this.A ? 1 : 0);
    }
}
