package v1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Comparator, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new j(0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k[] f12824v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12825w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f12826x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f12827y;

    public l(String str, ArrayList arrayList) {
        this(str, false, (k[]) arrayList.toArray(new k[0]));
    }

    public final l a(String str) {
        return Objects.equals(this.f12826x, str) ? this : new l(str, false, this.f12824v);
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        k kVar = (k) obj;
        k kVar2 = (k) obj2;
        UUID uuid = f.f12657a;
        return uuid.equals(kVar.f12796w) ? uuid.equals(kVar2.f12796w) ? 0 : 1 : kVar.f12796w.compareTo(kVar2.f12796w);
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
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (Objects.equals(this.f12826x, lVar.f12826x) && Arrays.equals(this.f12824v, lVar.f12824v)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f12825w == 0) {
            String str = this.f12826x;
            this.f12825w = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f12824v);
        }
        return this.f12825w;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12826x);
        parcel.writeTypedArray(this.f12824v, 0);
    }

    public l(String str, boolean z10, k... kVarArr) {
        this.f12826x = str;
        kVarArr = z10 ? (k[]) kVarArr.clone() : kVarArr;
        this.f12824v = kVarArr;
        this.f12827y = kVarArr.length;
        Arrays.sort(kVarArr, this);
    }

    public l(Parcel parcel) {
        this.f12826x = parcel.readString();
        k[] kVarArr = (k[]) parcel.createTypedArray(k.CREATOR);
        int i = y1.a0.f14551a;
        this.f12824v = kVarArr;
        this.f12827y = kVarArr.length;
    }
}
