package f9;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j4 extends p8.a {
    public static final Parcelable.Creator<j4> CREATOR = new android.support.v4.media.a(23);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f4244v;

    public j4(ArrayList arrayList) {
        this.f4244v = arrayList;
    }

    public static j4 a(e3... e3VarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(e3VarArr[0].f4106v));
        return new j4(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        List list = this.f4244v;
        if (list != null) {
            int iW2 = qb.t1.w(parcel, 1);
            int size = list.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                parcel.writeInt(((Integer) list.get(i10)).intValue());
            }
            qb.t1.y(parcel, iW2);
        }
        qb.t1.y(parcel, iW);
    }
}
