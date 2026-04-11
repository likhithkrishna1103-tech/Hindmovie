package md;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import sd.q;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g implements Parcelable, Serializable {
    public static final f CREATOR = new f();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g f8432w = new g(q.f11670v);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map f8433v;

    public g(Map map) {
        this.f8433v = map;
    }

    public final String a() {
        Map map = this.f8433v;
        if (map.isEmpty()) {
            return "{}";
        }
        String string = new JSONObject(s.C(map)).toString();
        ge.i.b(string);
        return string;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.Extras");
        return ge.i.a(this.f8433v, ((g) obj).f8433v);
    }

    public int hashCode() {
        return this.f8433v.hashCode();
    }

    public String toString() {
        return a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ge.i.e(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.f8433v));
    }
}
