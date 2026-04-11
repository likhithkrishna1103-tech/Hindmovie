package i5;

import android.os.Parcel;
import android.util.SparseIntArray;
import s.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f6369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f6370e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f6372h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6374k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(0), new e(0), new e(0));
    }

    @Override // i5.b
    public final c a() {
        Parcel parcel = this.f6370e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f6373j;
        if (i == this.f) {
            i = this.f6371g;
        }
        return new c(parcel, iDataPosition, i, l4.a.o(new StringBuilder(), this.f6372h, "  "), this.f6366a, this.f6367b, this.f6368c);
    }

    @Override // i5.b
    public final boolean e(int i) {
        while (this.f6373j < this.f6371g) {
            int i10 = this.f6374k;
            if (i10 == i) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i11 = this.f6373j;
            Parcel parcel = this.f6370e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f6374k = parcel.readInt();
            this.f6373j += i12;
        }
        return this.f6374k == i;
    }

    @Override // i5.b
    public final void i(int i) {
        int i10 = this.i;
        SparseIntArray sparseIntArray = this.f6369d;
        Parcel parcel = this.f6370e;
        if (i10 >= 0) {
            int i11 = sparseIntArray.get(i10);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(iDataPosition - i11);
            parcel.setDataPosition(iDataPosition);
        }
        this.i = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public c(Parcel parcel, int i, int i10, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.f6369d = new SparseIntArray();
        this.i = -1;
        this.f6374k = -1;
        this.f6370e = parcel;
        this.f = i;
        this.f6371g = i10;
        this.f6373j = i;
        this.f6372h = str;
    }
}
