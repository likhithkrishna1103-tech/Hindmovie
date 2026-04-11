package t7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends u7.a {
    public static final Parcelable.Creator<l> CREATOR = new k8.x(19);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12319u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f12320v;

    public l(int i, List list) {
        this.f12319u = i;
        this.f12320v = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f12319u);
        List list = this.f12320v;
        if (list != null) {
            int iE2 = t1.E(parcel, 2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                Parcelable parcelable = (Parcelable) list.get(i10);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    int iDataPosition = parcel.dataPosition();
                    parcel.writeInt(1);
                    int iDataPosition2 = parcel.dataPosition();
                    parcelable.writeToParcel(parcel, 0);
                    int iDataPosition3 = parcel.dataPosition();
                    parcel.setDataPosition(iDataPosition);
                    parcel.writeInt(iDataPosition3 - iDataPosition2);
                    parcel.setDataPosition(iDataPosition3);
                }
            }
            t1.G(parcel, iE2);
        }
        t1.G(parcel, iE);
    }
}
