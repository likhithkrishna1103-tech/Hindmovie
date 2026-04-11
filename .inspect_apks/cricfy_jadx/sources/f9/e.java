package f9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends p8.a {
    public static final Parcelable.Creator<e> CREATOR = new android.support.v4.media.a(17);
    public String A;
    public final v B;
    public long C;
    public v D;
    public final long E;
    public final v F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f4084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public s4 f4085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f4086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4087z;

    public e(e eVar) {
        o8.u.g(eVar);
        this.f4083v = eVar.f4083v;
        this.f4084w = eVar.f4084w;
        this.f4085x = eVar.f4085x;
        this.f4086y = eVar.f4086y;
        this.f4087z = eVar.f4087z;
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.D = eVar.D;
        this.E = eVar.E;
        this.F = eVar.F;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.r(parcel, 2, this.f4083v);
        qb.t1.r(parcel, 3, this.f4084w);
        qb.t1.q(parcel, 4, this.f4085x, i);
        long j4 = this.f4086y;
        qb.t1.v(parcel, 5, 8);
        parcel.writeLong(j4);
        boolean z10 = this.f4087z;
        qb.t1.v(parcel, 6, 4);
        parcel.writeInt(z10 ? 1 : 0);
        qb.t1.r(parcel, 7, this.A);
        qb.t1.q(parcel, 8, this.B, i);
        long j7 = this.C;
        qb.t1.v(parcel, 9, 8);
        parcel.writeLong(j7);
        qb.t1.q(parcel, 10, this.D, i);
        qb.t1.v(parcel, 11, 8);
        parcel.writeLong(this.E);
        qb.t1.q(parcel, 12, this.F, i);
        qb.t1.y(parcel, iW);
    }

    public e(String str, String str2, s4 s4Var, long j4, boolean z10, String str3, v vVar, long j7, v vVar2, long j10, v vVar3) {
        this.f4083v = str;
        this.f4084w = str2;
        this.f4085x = s4Var;
        this.f4086y = j4;
        this.f4087z = z10;
        this.A = str3;
        this.B = vVar;
        this.C = j7;
        this.D = vVar2;
        this.E = j10;
        this.F = vVar3;
    }
}
