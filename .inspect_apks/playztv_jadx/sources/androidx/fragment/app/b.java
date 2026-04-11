package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a9.b(5);
    public final int A;
    public final int B;
    public final CharSequence C;
    public final int D;
    public final CharSequence E;
    public final ArrayList F;
    public final ArrayList G;
    public final boolean H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f1247u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f1248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f1249w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f1250x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f1252z;

    public b(a aVar) {
        int size = aVar.f1225a.size();
        this.f1247u = new int[size * 6];
        if (!aVar.f1230g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1248v = new ArrayList(size);
        this.f1249w = new int[size];
        this.f1250x = new int[size];
        int i = 0;
        for (int i10 = 0; i10 < size; i10++) {
            v0 v0Var = (v0) aVar.f1225a.get(i10);
            int i11 = i + 1;
            this.f1247u[i] = v0Var.f1399a;
            ArrayList arrayList = this.f1248v;
            v vVar = v0Var.f1400b;
            arrayList.add(vVar != null ? vVar.f1398z : null);
            int[] iArr = this.f1247u;
            iArr[i11] = v0Var.f1401c ? 1 : 0;
            iArr[i + 2] = v0Var.f1402d;
            iArr[i + 3] = v0Var.f1403e;
            int i12 = i + 5;
            iArr[i + 4] = v0Var.f;
            i += 6;
            iArr[i12] = v0Var.f1404g;
            this.f1249w[i10] = v0Var.f1405h.ordinal();
            this.f1250x[i10] = v0Var.i.ordinal();
        }
        this.f1251y = aVar.f;
        this.f1252z = aVar.i;
        this.A = aVar.f1241s;
        this.B = aVar.f1232j;
        this.C = aVar.f1233k;
        this.D = aVar.f1234l;
        this.E = aVar.f1235m;
        this.F = aVar.f1236n;
        this.G = aVar.f1237o;
        this.H = aVar.f1238p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1247u);
        parcel.writeStringList(this.f1248v);
        parcel.writeIntArray(this.f1249w);
        parcel.writeIntArray(this.f1250x);
        parcel.writeInt(this.f1251y);
        parcel.writeString(this.f1252z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        TextUtils.writeToParcel(this.C, parcel, 0);
        parcel.writeInt(this.D);
        TextUtils.writeToParcel(this.E, parcel, 0);
        parcel.writeStringList(this.F);
        parcel.writeStringList(this.G);
        parcel.writeInt(this.H ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f1247u = parcel.createIntArray();
        this.f1248v = parcel.createStringArrayList();
        this.f1249w = parcel.createIntArray();
        this.f1250x = parcel.createIntArray();
        this.f1251y = parcel.readInt();
        this.f1252z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.C = (CharSequence) creator.createFromParcel(parcel);
        this.D = parcel.readInt();
        this.E = (CharSequence) creator.createFromParcel(parcel);
        this.F = parcel.createStringArrayList();
        this.G = parcel.createStringArrayList();
        this.H = parcel.readInt() != 0;
    }
}
