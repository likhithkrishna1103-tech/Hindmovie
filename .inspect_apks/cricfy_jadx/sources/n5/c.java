package n5;

import android.os.Parcel;
import android.util.SparseIntArray;
import v.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f8768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f8769e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8771h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8773k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(0), new e(0), new e(0));
    }

    @Override // n5.b
    public final c a() {
        Parcel parcel = this.f8769e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f8772j;
        if (i == this.f) {
            i = this.f8770g;
        }
        return new c(parcel, iDataPosition, i, q4.a.q(new StringBuilder(), this.f8771h, "  "), this.f8765a, this.f8766b, this.f8767c);
    }

    @Override // n5.b
    public final boolean e(int i) {
        while (this.f8772j < this.f8770g) {
            int i10 = this.f8773k;
            if (i10 == i) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i11 = this.f8772j;
            Parcel parcel = this.f8769e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f8773k = parcel.readInt();
            this.f8772j += i12;
        }
        return this.f8773k == i;
    }

    @Override // n5.b
    public final void i(int i) {
        int i10 = this.i;
        SparseIntArray sparseIntArray = this.f8768d;
        Parcel parcel = this.f8769e;
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
        this.f8768d = new SparseIntArray();
        this.i = -1;
        this.f8773k = -1;
        this.f8769e = parcel;
        this.f = i;
        this.f8770g = i10;
        this.f8772j = i;
        this.f8771h = str;
    }
}
