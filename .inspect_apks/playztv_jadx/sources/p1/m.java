package p1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Comparator, Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new k(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l[] f9935u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9936v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f9937w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9938x;

    public m(String str, ArrayList arrayList) {
        this(str, false, (l[]) arrayList.toArray(new l[0]));
    }

    public final m a(String str) {
        return Objects.equals(this.f9937w, str) ? this : new m(str, false, this.f9935u);
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        UUID uuid = g.f9745a;
        return uuid.equals(lVar.f9892v) ? uuid.equals(lVar2.f9892v) ? 0 : 1 : lVar.f9892v.compareTo(lVar2.f9892v);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (Objects.equals(this.f9937w, mVar.f9937w) && Arrays.equals(this.f9935u, mVar.f9935u)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9936v == 0) {
            String str = this.f9937w;
            this.f9936v = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f9935u);
        }
        return this.f9936v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9937w);
        parcel.writeTypedArray(this.f9935u, 0);
    }

    public m(l... lVarArr) {
        this(null, true, lVarArr);
    }

    public m(String str, boolean z2, l... lVarArr) {
        this.f9937w = str;
        lVarArr = z2 ? (l[]) lVarArr.clone() : lVarArr;
        this.f9935u = lVarArr;
        this.f9938x = lVarArr.length;
        Arrays.sort(lVarArr, this);
    }

    public m(Parcel parcel) {
        this.f9937w = parcel.readString();
        l[] lVarArr = (l[]) parcel.createTypedArray(l.CREATOR);
        int i = s1.b0.f11647a;
        this.f9935u = lVarArr;
        this.f9938x = lVarArr.length;
    }
}
