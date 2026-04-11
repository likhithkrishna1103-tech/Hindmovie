package id;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable, Serializable {
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6563u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6564v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f6565w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f6566x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f6567y = -1;

    public final void a(int i) {
        this.f6564v = i;
    }

    public final void b(int i) {
        this.f6563u = i;
    }

    public final void c(long j5) {
        this.f6567y = j5;
    }

    public final void d(long j5) {
        this.f6566x = j5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(long j5) {
        this.f6565w = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.DownloadBlockInfo");
        b bVar = (b) obj;
        return this.f6563u == bVar.f6563u && this.f6564v == bVar.f6564v && this.f6565w == bVar.f6565w && this.f6566x == bVar.f6566x && this.f6567y == bVar.f6567y;
    }

    public final int hashCode() {
        int i = ((this.f6563u * 31) + this.f6564v) * 31;
        long j5 = this.f6565w;
        int i10 = (i + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f6566x;
        int i11 = (i10 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j10 = this.f6567y;
        return i11 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        int i = this.f6563u;
        int i10 = this.f6564v;
        long j5 = this.f6565w;
        long j8 = this.f6566x;
        long j10 = this.f6567y;
        StringBuilder sbP = l4.a.p(i, i10, "DownloadBlock(downloadId=", ", blockPosition=", ", startByte=");
        sbP.append(j5);
        sbP.append(", endByte=");
        sbP.append(j8);
        sbP.append(", downloadedBytes=");
        return l4.a.n(sbP, j10, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        be.h.e(parcel, "dest");
        parcel.writeInt(this.f6563u);
        parcel.writeInt(this.f6564v);
        parcel.writeLong(this.f6565w);
        parcel.writeLong(this.f6566x);
        parcel.writeLong(this.f6567y);
    }
}
