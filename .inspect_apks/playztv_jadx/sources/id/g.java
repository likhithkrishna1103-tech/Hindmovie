package id;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import od.r;
import od.t;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g implements Parcelable, Serializable {
    public static final f CREATOR = new f();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final g f6576v = new g(r.f9571u);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map f6577u;

    public g(Map map) {
        this.f6577u = map;
    }

    public final String a() {
        Map map = this.f6577u;
        if (map.isEmpty()) {
            return "{}";
        }
        String string = new JSONObject(t.J(map)).toString();
        be.h.b(string);
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
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.Extras");
        return be.h.a(this.f6577u, ((g) obj).f6577u);
    }

    public int hashCode() {
        return this.f6577u.hashCode();
    }

    public String toString() {
        return a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        be.h.e(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.f6577u));
    }
}
